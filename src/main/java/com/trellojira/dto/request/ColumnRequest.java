package com.trellojira.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ColumnRequest {
  private String name;

  private Integer position;

  @NotNull(message = "Board ID is required")
  private Long boardId;
}
