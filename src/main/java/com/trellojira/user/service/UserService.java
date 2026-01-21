package com.trellojira.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.dto.request.UserRequest;
import com.trellojira.dto.response.UserResponse;
import com.trellojira.user.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final IUserRepository repository;
  private final ModelMapper mapper;

  // GET
  public Optional<UserResponse> getByUsername(String username) {
    return repository.findByUsername(username).map(mapper::toUserResponse);
  }

  public Optional<UserResponse> getByName(String name) {
    return repository.findByName(name).map(mapper::toUserResponse);
  }

  public Optional<UserResponse> getByEmail(String email) {
    return repository.findByEmail(email).map(mapper::toUserResponse);
  }

  public boolean existsByUsername(String username) {
    return repository.existsByUsername(username);
  }

  public boolean existsByEmail(String email) {
    return repository.existsByEmail(email);
  }

  public List<UserResponse> getByMemberBoardsId(Long boardId) {
    return repository.findByMemberBoardsId(boardId).stream().map(mapper::toUserResponse).toList();
  }

  public Optional<UserResponse> getBoardOwned(Long boardId, Long userId) {
    return repository.findBoardOwnedByUser(boardId, userId).map(mapper::toUserResponse);
  }

  // SAVE
  public void save(UserRequest user) {
    repository.save(mapper.toUser(user));
  }

  // UPDATE
  public void update(UserRequest userRequest, Long id) {
    var userOp = repository.findById(id);
    if (userOp.isPresent()) {
      var user = userOp.get();
      user.setId(id);

      if (userRequest.getUsername() != null) {
        user.setUsername(userRequest.getUsername());
      }
      if (userRequest.getName() != null) {
        user.setName(userRequest.getName());
      }
      if (userRequest.getEmail() != null) {
        user.setEmail(userRequest.getEmail());
      }

      repository.save(user);
    }
  }

  // DELETE
  public void delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
