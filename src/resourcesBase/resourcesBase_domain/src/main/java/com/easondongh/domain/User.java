package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private int id;

    private String name;

    private String nickName;

    private String password;

    private String email;

    private long avatarId;

    private Date registerTime;

    private Date lastLoginTime;

    private int status;
}
