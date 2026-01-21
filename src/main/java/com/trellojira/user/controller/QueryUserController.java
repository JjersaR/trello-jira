package com.trellojira.user.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.dto.response.UserResponse;
import com.trellojira.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryUserController {

  private final UserService service;

  @QueryMapping(name = "findByUsername")
  public UserResponse byUsername(@Argument String username) {
    var userOp = service.getByUsername(username);
    if (userOp.isPresent()) {
      return userOp.get();
    }
    return null;
  }

  @QueryMapping(name = "findByName")
  public UserResponse byName(@Argument String name) {
    var userOp = service.getByName(name);
    if (userOp.isPresent()) {
      return userOp.get();
    }
    return null;
  }

  @QueryMapping(name = "findByEmail")
  public UserResponse byEmail(@Argument String email) {
    var userOp = service.getByEmail(email);
    if (userOp.isPresent()) {
      return userOp.get();
    }
    return null;
  }

  @QueryMapping(name = "findByBoard")
  public List<UserResponse> getByMemberBoardsId(@Argument Integer boardId) {
    return service.getByMemberBoardsId(Long.parseLong(boardId.toString()));
  }
}
