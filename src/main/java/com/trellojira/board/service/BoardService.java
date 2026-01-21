package com.trellojira.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trellojira.board.repository.IBoardRepository;
import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.dto.request.BoardRequest;
import com.trellojira.dto.request.UserRequest;
import com.trellojira.dto.response.BoardResponse;
import com.trellojira.user.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final IBoardRepository repository;
  private final IUserRepository userRepository;
  private final ModelMapper mapper;

  public List<BoardResponse> getByOwnerId(Long id) {
    return repository.findByOwnerId(id).stream().map(mapper::toBoardResponse).toList();
  }

  public List<BoardResponse> getByMembers(UserRequest user) {
    return repository.findByMembersContaining(mapper.toUser(user)).stream().map(mapper::toBoardResponse).toList();
  }

  public List<BoardResponse> getByOwnerUsername(String username) {
    return repository.findByOwnerUsername(username).stream().map(mapper::toBoardResponse).toList();
  }

  public void save(BoardRequest board) {
    var user = userRepository.findById(board.getOwnerId()).get();
    repository.save(mapper.toBoard(board, user));
  }

  public void update(BoardRequest request, Long id) {
    var boardOp = repository.findById(id);
    if (boardOp.isPresent()) {
      var board = boardOp.get();

      var user = userRepository.findById(request.getOwnerId()).get();
      board.setId(id);

      if (request.getName() != null) {
        board.setName(request.getName());
      }
      if (request.getDescription() != null) {
        board.setDescription(request.getDescription());
      }
      if (!board.getOwner().getId().equals(request.getOwnerId())) {
        board.setOwner(user);
      }

      repository.save(board);
    }
  }

  public void delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
