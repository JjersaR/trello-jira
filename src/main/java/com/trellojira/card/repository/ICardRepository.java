package com.trellojira.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.card.entity.Card;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {

}
