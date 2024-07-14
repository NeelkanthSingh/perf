package org.wojak.perf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.wojak.perf.entity.User;
import org.wojak.perf.model.UserDTO;
import org.wojak.perf.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/add")
  public ResponseEntity<User> addUser() {
    return ResponseEntity.ok(userService.addUser());
  }

}
