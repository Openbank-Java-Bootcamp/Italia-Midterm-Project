package com.ironhack.bankingsystem.controller.interfaces.users;

import com.ironhack.bankingsystem.models.users.User;

import java.util.List;

public interface IUserController {
    /*void saveUser(User user);*/
    List<User> getUsers();

}
