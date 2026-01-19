package com.trellojira.column.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.column.entity.Columns;

@Repository
public interface IColumnRepository extends JpaRepository<Columns, Long> {

  List<Columns> findByBoardId(Long id);

  List<Columns> findByBoardIdOrderByPositionAsc(Long id);
}
