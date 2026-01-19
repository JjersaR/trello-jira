package com.trellojira.card.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.trellojira.column.entity.Columns;
import com.trellojira.comment.entity.Comment;
import com.trellojira.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cards")
public class Card {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  private Integer position;

  // Una Card pertenece a UNA Column
  @ManyToOne
  @JoinColumn(name = "column_id", nullable = false)
  private Columns column;

  // Una Card puede estar asignada a UN User
  @ManyToOne
  @JoinColumn(name = "assigned_to")
  private User assignedTo;

  // Una Card fue creada por UN User
  @ManyToOne
  @JoinColumn(name = "created_by")
  private User createdBy;

  // Una Card puede tener MUCHOS Comments
  @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
  private List<Comment> comments;

  @Column(name = "due_date")
  private LocalDateTime dueDate;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Enumerated(EnumType.STRING)
  private EPriority priority;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
