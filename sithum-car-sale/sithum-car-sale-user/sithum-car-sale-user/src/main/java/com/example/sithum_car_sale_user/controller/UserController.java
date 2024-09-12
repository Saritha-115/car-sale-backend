package com.example.sithum_car_sale_user.controller;

import com.example.sithum_car_sale_user.model.UserModel;
import com.example.sithum_car_sale_user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel){
        return new ResponseEntity<UserModel>(userService.saveUser(userModel), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<UserModel> getUserById(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") long Id){
        return new ResponseEntity<UserModel>(userService.getUserById(Id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") long Id,
                                                @RequestBody UserModel userModel){
        return new ResponseEntity<UserModel>(userService.updateUser(userModel,Id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
    }
}
