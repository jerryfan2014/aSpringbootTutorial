package com.kangda.po;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String name;
    private Integer age;
    private String email;

    private Long addrId;

}
