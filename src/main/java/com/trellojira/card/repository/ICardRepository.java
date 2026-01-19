package com.trellojira.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.card.entity.Card;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {

  List<Card> findByColumnId(Long id);

  List<Card> findByAssignedToId(Long id);

  List<Card> findByColumnIdOrderByPositionAsc(Long id);
}
