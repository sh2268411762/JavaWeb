package org.example.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfo
{
    private int id;
    private String username;
    private String password;

}
