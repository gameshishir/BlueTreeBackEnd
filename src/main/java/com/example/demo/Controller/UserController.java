package com.example.demo.Controller;

import com.example.demo.Domain.User;
import com.example.demo.Exception.UserAlreadyExist;
import com.example.demo.Exception.UserNotFound;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExist {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<?> getallUser()
    {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("http://localhost:4200/")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(userService.deleteUserbyId(id), HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable("id") int id) throws UserNotFound {
        return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.OK);
    }
}
