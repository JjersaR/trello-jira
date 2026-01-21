package com.trellojira.board.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.column.service.ColumnService;
import com.trellojira.dto.response.BoardResponse;
import com.trellojira.dto.response.ColumnResponse;
import com.trellojira.dto.response.UserResponse;
import com.trellojira.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardDataFetcher {
  private final UserService userService;
  private final ColumnService columnService;

  // Resuelve el campo 'owner' de BoardResponse
  @SchemaMapping(typeName = "BoardResponse", field = "owner")
  public UserResponse owner(BoardResponse response) {
    var userOp = userService.getBoardOwned(response.getId(), response.getOwnerId());
    if (userOp.isPresent()) {
      return userOp.get();
    }
    return null;
  }

  @SchemaMapping(typeName = "BoardResponse", field = "columns")
  public List<ColumnResponse> members(BoardResponse response) {
    return columnService.getByBoardId(response.getId());
  }

}
