package com.gpcoder.patterns.other.dto;

public class DataAccessObjectPatternExample {
    public static void main(String[] args) {
        UserService service = new UserService();
        UserDTO dto = service.getUser(1);
        System.out.println("User: " + dto);

        dto.setFullName("phuongheh.com");
        service.updateUser(dto);
        System.out.println("User updated: " + dto);
    }
}
