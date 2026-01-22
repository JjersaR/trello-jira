package com.trellojira.column.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trellojira.board.repository.IBoardRepository;
import com.trellojira.column.repository.IColumnRepository;
import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.dto.request.ColumnRequest;
import com.trellojira.dto.response.ColumnResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColumnService {

  private final IColumnRepository repository;
  private final IBoardRepository boardRepository;
  private final ModelMapper mapper;

  public List<ColumnResponse> getByBoardId(Long id) {
    return repository.findByBoardId(id).stream().map(mapper::toColumnResponse).toList();
  }

  public List<ColumnResponse> getByBoardIdOrder(Long id) {
    return repository.findByBoardIdOrderByPositionAsc(id).stream().map(mapper::toColumnResponse).toList();
  }

  public void save(ColumnRequest column) {
    if (boardRepository.existsById(column.getBoardId())) {
      var board = boardRepository.findById(column.getBoardId()).get();

      repository.save(mapper.toColumn(column, board));
    }
  }

  public void update(ColumnRequest request, Long id) {
    var columnOp = repository.findById(id);

    if (columnOp.isPresent()) {
      var column = columnOp.get();

      if (request.getName() != null) {
        column.setName(request.getName());
      }
      if (request.getPosition() != null) {
        column.setPosition(request.getPosition());
      }
      if (!column.getBoard().getId().equals(request.getBoardId())) {
        var board = boardRepository.findById(request.getBoardId()).get();
        column.setBoard(board);
      }

      repository.save(column);
    }
  }

  public void delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
