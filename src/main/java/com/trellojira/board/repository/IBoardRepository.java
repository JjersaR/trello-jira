package com.trellojira.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.board.entity.Board;

@Repository
public interface IBoardRepository extends JpaRepository<Board, Long> {
  List<Board> findByOwnerId(Long id);
}
