package com.example.socialmedia.platform.service;

import com.example.socialmedia.platform.entity.Post;
import com.example.socialmedia.platform.entity.User;
import com.example.socialmedia.platform.repositary.UserRepositary;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositary userRepository;

    //-------------------------------------------------------------------

    public User saveUser(User obj_user)
    {
        return userRepository.save(obj_user);
    }
    public List<User> saveUsers(List<User> obj_user)
    {
        return userRepository.saveAll(obj_user);
    }

    //---------------------------------------------------------------------
    public List<User> FindAllUsers()
    {
        return userRepository.findAll();
    }

    public User getuser(String username) {
        return userRepository.findByUsername(username);
    }

    //---------------------------------------------------------------------
    public String updateUser(int id, User user) {
        User existingRecord = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + id));

        if(existingRecord != null) {

            existingRecord.setUsername(user.getUsername());
            existingRecord.setFirstname(user.getFirstname());
            existingRecord.setLastname(user.getLastname());
            existingRecord.setEmail(user.getEmail());
            existingRecord.setPassword(user.getPassword());


            userRepository.save(existingRecord);
            return "User updated..! ";
        }else{
            return "Not found..!";
        }
    }


    //--------------------------------------------------------------------

    /*public void deleteUser(int id )
    {
        userRepository.deleteById(id);
    }*/

    public String deleteUser(int id){

        try {
            User user = userRepository.findById(id).orElse(null);

            if (user != null) {
                userRepository.deleteById(id);
                return "User deleted successfully!";
            } else {
                return "User not found";
            }
        } catch (Exception e) {
            return "An error occurred while deleting a User";
        }
    }


}
