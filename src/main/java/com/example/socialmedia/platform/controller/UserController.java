package com.example.socialmedia.platform.controller;

import com.example.socialmedia.platform.entity.User;
import com.example.socialmedia.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    //--------------------------------------------------------------------------------------

    //Create Users
    @PostMapping("/adduser")
    public User adduser(@RequestBody User obj_user)
    {
        return userService.saveUser(obj_user);
    }
    @PostMapping("/addusers")
    public List<User> addusers(@RequestBody List<User> obj_user)
    {
        return userService.saveUsers(obj_user);
    }

    //------------------------------------------------------------------------------------

    //Search Users
    @GetMapping("/searchAll")
    public List<User> searchAll()
    {
        return userService.FindAllUsers();
    }
    @GetMapping("/searchUser/{username}")
    public User searchUser(@PathVariable String username)
    {

        return userService.getuser(username);
    }

    //-----------------------------------------------------------------------------------

    //Update Users

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedRecord)
    {
        return userService.updateUser(id, updatedRecord);
    }

    //------------------------------------------------------------------------------------

    //Delete Users

    /*@DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Student with ID " + id + " deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Student with ID " + id + " deletion unsuccessful.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }


    //-------------------------------------------------------------------------------------------

}
