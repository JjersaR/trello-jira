package com.trellojira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.user.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  Optional<User> findByName(String name);

  Optional<User> findByEmail(String email);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  // Buscar usuarios que sean miembros de un board específico
  List<User> findByMemberBoardsId(Long boardId);

}
