package com.example.coursaty.Controller;

import com.example.coursaty.Entitiy.Response.CustomResponseEntity;
import com.example.coursaty.Entitiy.User.User;
import com.example.coursaty.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public CustomResponseEntity<?> registerUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PostMapping("/login")
  public CustomResponseEntity<?> authenticateUser(@RequestBody User user) {
    return userService.authenticateUser(user);
  }

  @GetMapping("{userId}/progress/{courseId}")
  public CustomResponseEntity<?> checkUserProgress(@PathVariable long courseId, @PathVariable long userId) {
    return userService.checkUserProgress(courseId, userId);
  }

  @GetMapping("/{id}")
  public CustomResponseEntity<User> getUser(@PathVariable long id) {
    return userService.getUserById(id);
  }


  @PutMapping("/update")
  public void updateUser(@RequestBody User user) {
    userService.updateUser(user);
  }

  @GetMapping("/otp/{email}")
  public CustomResponseEntity<?> generateOtp(@PathVariable String email) {
    return userService.generateOtp(email);
  }

  @PostMapping("/otp/validate")
  public CustomResponseEntity<?> checkOtp(@RequestBody User user) {
    return userService.checkOtp(user.getOtp(), user.getEmail());
  }

  @PutMapping("/password")
  public CustomResponseEntity<?> updatePassword(@RequestBody User user) {
    return userService.updatePassword(user);
  }
}
