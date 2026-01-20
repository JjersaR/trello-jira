package com.trellojira.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
  private Long id;

  private String name;

  private String description;

  private UserResponse owner;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private Integer columnsCount;

  private Integer membersCount;

  private List<ColumnResponse> columns;
}
