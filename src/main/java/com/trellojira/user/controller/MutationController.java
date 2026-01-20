package com.trellojira.user.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.dto.request.UserRequest;
import com.trellojira.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationController {

  private final UserService service;

  @MutationMapping(name = "createUser")
  public String save(@Argument UserRequest user) {
    service.save(user);
    return "Usuario creado";
  }

  @MutationMapping(name = "updateUser")
  public String update(@Argument UserRequest user, @Argument Integer id) {
    service.update(user, Long.parseLong(id.toString()));
    return "Usuario actualizado";
  }

  @MutationMapping(name = "deleteUser")
  public String delete(@Argument Integer id) {
    service.delete(Long.parseLong(id.toString()));
    return "Usuario borrado";
  }
}
