package com.gpcoder.patterns.other.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<UserModel> {
    private List<UserModel> users = new ArrayList<>();

    public UserDao() {
        UserModel user = new UserModel();
        user.setId(1);
        user.setUserName("gpcoder");
        user.setEmail("phuongheh@gmail.com");
        user.setFullName("Gian Phuong");
        user.setPassword("1234");
        user.setBankAccount("9999-9999-9999-9999");
        users.add(user);
    }

    @Override
    public List<UserModel> getAll() {
        return users;
    }

    @Override
    public Optional<UserModel> get(Integer id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void save(UserModel userModel) {
        users.add(userModel);
    }

    @Override
    public void update(UserModel userModel) {
        int index = -1;
        for (UserModel u : users) {
            index++;
            if (userModel.getId().equals(u.getId())) {
                users.set(index, userModel);
                break;
            }
        }
    }

    @Override
    public void delete(UserModel userModel) {
        get(userModel.getId()).ifPresent(existUser -> users.remove(existUser));
    }
}
