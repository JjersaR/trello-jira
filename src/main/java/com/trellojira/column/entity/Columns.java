package com.trellojira.column.entity;

import java.util.List;

import com.trellojira.board.entity.Board;
import com.trellojira.card.entity.Card;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "columns")
public class Columns {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private Integer position;

  // Una Column pertenece a UN Board
  @ManyToOne
  @JoinColumn(name = "board_id", nullable = false)
  private Board board;

  // Una Column tiene MUCHAS Cards (tarjetas)
  @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
  @OrderBy("position ASC") // Las tarjetas se ordenan por posición
  private List<Card> cards;
}
