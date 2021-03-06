package com.ironhack.bankingsystem.controller.impl.users;

import com.ironhack.bankingsystem.controller.interfaces.users.IUserController;
import com.ironhack.bankingsystem.models.users.User;
import com.ironhack.bankingsystem.service.interfaces.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking")
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

/*    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }*/

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
