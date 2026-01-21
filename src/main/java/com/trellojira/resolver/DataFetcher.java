package com.trellojira.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.card.service.CardService;
import com.trellojira.column.service.ColumnService;
import com.trellojira.comment.service.CommentService;
import com.trellojira.dto.response.BoardResponse;
import com.trellojira.dto.response.CardResponse;
import com.trellojira.dto.response.ColumnResponse;
import com.trellojira.dto.response.CommentResponse;
import com.trellojira.dto.response.UserResponse;
import com.trellojira.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DataFetcher {
  private final UserService userService;
  private final ColumnService columnService;
  private final CardService cardService;
  private final CommentService commentService;

  @SchemaMapping(typeName = "BoardResponse", field = "owner")
  public UserResponse owner(BoardResponse response) {
    var userOp = userService.getBoardOwned(response.getId(), response.getOwnerId());
    if (userOp.isPresent()) {
      return userOp.get();
    }
    return null;
  }

  @SchemaMapping(typeName = "BoardResponse", field = "columns")
  public List<ColumnResponse> columns(BoardResponse response) {
    return columnService.getByBoardId(response.getId());
  }

  @SchemaMapping(typeName = "BoardResponse", field = "members")
  public List<UserResponse> members(BoardResponse response) {
    return userService.getByMemberBoardsId(response.getId());
  }

  @SchemaMapping(typeName = "ColumnResponse", field = "cards")
  public List<CardResponse> cards(ColumnResponse response) {
    return cardService.getByColumnId(response.getId());
  }

  @SchemaMapping(typeName = "CardResponse", field = "comments")
  public List<CommentResponse> comments(CardResponse response) {
    return commentService.getByCardId(response.getId());
  }

}
