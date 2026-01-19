package com.trellojira.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.trellojira.board.entity.Board;
import com.trellojira.card.entity.Card;
import com.trellojira.comment.entity.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  private String name;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // Un User puede ser dueño de MUCHOS Boards
  @OneToMany(mappedBy = "owner")
  private List<Board> ownedBoards;

  // Un User puede ser miembro de MUCHOS Boards
  @ManyToMany(mappedBy = "members")
  private List<Board> memberBoards;

  // Un User puede tener MUCHAS Cards asignadas
  @OneToMany(mappedBy = "assignedTo")
  private List<Card> assignedCards;

  // Un User puede crear MUCHAS Cards
  @OneToMany(mappedBy = "createdBy")
  private List<Card> createdCards;

  // Un User puede escribir MUCHOS Comments
  @OneToMany(mappedBy = "author")
  private List<Comment> comments;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}
