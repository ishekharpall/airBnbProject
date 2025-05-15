package com.shekhar.projects.airBnbProject.Dto;

import com.shekhar.projects.airBnbProject.Entity.User;
import com.shekhar.projects.airBnbProject.Entity.enums.Gender;
import lombok.Data;


@Data
public class GuestDto {

    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;

}
