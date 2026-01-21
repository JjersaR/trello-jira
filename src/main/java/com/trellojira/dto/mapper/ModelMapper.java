package com.trellojira.dto.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.trellojira.board.entity.Board;
import com.trellojira.card.entity.Card;
import com.trellojira.card.entity.EPriority;
import com.trellojira.column.entity.Columns;
import com.trellojira.comment.entity.Comment;
import com.trellojira.dto.request.BoardRequest;
import com.trellojira.dto.request.CardRequest;
import com.trellojira.dto.request.ColumnRequest;
import com.trellojira.dto.request.CommentRequest;
import com.trellojira.dto.request.UserRequest;
import com.trellojira.dto.response.BoardResponse;
import com.trellojira.dto.response.CardResponse;
import com.trellojira.dto.response.ColumnResponse;
import com.trellojira.dto.response.CommentResponse;
import com.trellojira.dto.response.UserResponse;
import com.trellojira.user.entity.User;

@Component
public class ModelMapper {

  /**
   * USER
   */

  // Entity -> DTO
  public UserResponse toUserResponse(User user) {
    if (user == null)
      return null;

    var response = new UserResponse();
    response.setId(user.getId());
    response.setUsername(user.getUsername());
    response.setEmail(user.getEmail());
    response.setName(user.getName());
    response.setCreatedAt(user.getCreatedAt().toString());
    response.setBoardCount(user.getOwnedBoards().size());
    response.setMemberBoardsCount(user.getMemberBoards().size());

    return response;
  }

  // Optional Entity -> Optional DTO
  public Optional<UserResponse> toUserResponse(Optional<User> user) {
    return user.map(this::toUserResponse);
  }

  // Request -> Entity
  public User toUser(UserRequest request) {
    if (request == null)
      return null;

    var user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setName(request.getName());

    return user;
  }

  /**
   * BOARD
   */

  // Entity -> DTO
  public BoardResponse toBoardResponse(Board board) {
    if (board == null)
      return null;

    var response = new BoardResponse();
    response.setId(board.getId());
    response.setName(board.getName());
    response.setDescription(board.getDescription());
    response.setOwnerId(board.getOwner() != null ? board.getOwner().getId() : null);
    response.setCreatedAt(board.getCreatedAt());
    response.setUpdatedAt(board.getUpdatedAt());
    response.setColumnsCount(board.getColumns().size());
    response.setMembersCount(board.getMembers().size());

    return response;
  }

  // Request -> Entity
  public Board toBoard(BoardRequest request, User owner) {
    if (request == null)
      return null;

    var board = new Board();
    board.setName(request.getName());
    board.setDescription(request.getDescription());
    board.setOwner(owner);

    return board;
  }

  /**
   * CARD
   */
  // Entity -> DTO
  public CardResponse toCardResponse(Card card) {
    if (card == null)
      return null;

    var response = new CardResponse();
    response.setId(card.getId());
    response.setTitle(card.getTitle());
    response.setDescription(card.getDescription());
    response.setPosition(card.getPosition());
    response.setColumn(toColumnResponse(card.getColumn()));
    response.setAssignedTo(toUserResponse(card.getAssignedTo()));
    response.setCreatedBy(toUserResponse(card.getCreatedBy()));
    response.setDueDate(card.getDueDate());
    response.setCreatedAt(card.getCreatedAt());
    response.setUpdatedAt(card.getUpdatedAt());
    response.setPriority(card.getPriority().toString());
    response.setCommentsCount(card.getComments().size());
    response.setComments(card.getComments().stream().map(this::toCommentResponse).toList());

    return response;
  }

  // Request -> Entity
  public Card toCard(CardRequest request, Columns column, User assignedTo, User createdBy) {
    if (request == null)
      return null;

    var card = new Card();
    card.setTitle(request.getTitle());
    card.setDescription(request.getDescription());
    card.setPosition(request.getPosition());
    card.setColumn(column);
    card.setAssignedTo(assignedTo);
    card.setCreatedBy(createdBy);
    card.setDueDate(request.getDueDate());
    card.setPriority(EPriority.valueOf(request.getPriority()));

    return card;
  }

  /**
   * COLUMN
   */
  // Entity -> DTO
  public ColumnResponse toColumnResponse(Columns column) {
    if (column == null)
      return null;

    var response = new ColumnResponse();
    response.setId(column.getId());
    response.setName(column.getName());
    response.setPosition(column.getPosition());
    response.setBoardId(column.getBoard().getId());
    response.setCardsCount(column.getCards().size());

    return response;
  }

  // Request -> Entity
  public Columns toColumn(ColumnRequest request, Board board) {
    if (request == null)
      return null;
    var column = new Columns();
    column.setName(request.getName());
    column.setPosition(request.getPosition());
    column.setBoard(board);

    return column;
  }

  /**
   * COMMENT
   */
  // Entity -> DTO
  public CommentResponse toCommentResponse(Comment comment) {
    if (comment == null)
      return null;

    var response = new CommentResponse();
    response.setId(comment.getId());
    response.setContent(comment.getContent());
    response.setCardId(comment.getCard().getId());
    response.setAuthorUsername(comment.getAuthor().getUsername());
    response.setCreatedAt(comment.getCreatedAt());
    response.setUpdatedAt(comment.getUpdatedAt());

    return response;
  }

  // Request -> Entity
  public Comment toComment(CommentRequest request, Card card, User author) {
    if (request == null)
      return null;

    var comment = new Comment();
    comment.setContent(request.getContent());
    comment.setCard(card);
    comment.setAuthor(author);

    return comment;
  }
}
