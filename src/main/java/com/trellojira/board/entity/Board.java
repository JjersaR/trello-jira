package com.trellojira.board.entity;

import java.time.OffsetDateTime;
import java.util.List;

import com.trellojira.column.entity.Columns;
import com.trellojira.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "boards")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;

  // Un Board tiene UN dueño (propietario)
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  // Un Board tiene MUCHAS Columnas
  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  private List<Columns> columns;

  // Un Board puede tener MUCHOS Miembros (usuarios)
  @ManyToMany
  @JoinTable(name = "board_members", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> members;

  @Column(name = "created_at")
  private OffsetDateTime createdAt;

  @Column(name = "updated_at")
  private OffsetDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = OffsetDateTime.now();
    updatedAt = OffsetDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = OffsetDateTime.now();
  }
}
