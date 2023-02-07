package com.gpcoder.patterns.other.dto;

import lombok.Data;

@Data
public class UserModel {
    private Integer id;
    private String userName;
    private String fullName;
    private String password;
    private String email;
    private String bankAccount;
}
