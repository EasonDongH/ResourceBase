package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String nickName;

    private String password;

    private String email;

    private Long avatarId;

    private Date registerTime;

    private Date lastLoginTime;

    private int status;
}
