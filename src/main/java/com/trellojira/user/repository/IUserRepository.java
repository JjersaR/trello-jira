package com.trellojira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

  // Obtener UN user si es owner de un board
  @Query(value = """
      SELECT u.id, u.created_at, u.email, u.name, u.username FROM users u
      join boards b
      on b.owner_id = u.id
      WHERE b.id = :boardId AND b.owner_id = :userId;
          """, nativeQuery = true)
  Optional<User> findBoardOwnedByUser(Long boardId, Long userId);

}
