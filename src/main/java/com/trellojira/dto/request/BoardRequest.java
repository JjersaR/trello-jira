package com.trellojira.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardRequest {
  @NotBlank(message = "Board name is required")
  @Size(min = 3, max = 100, message = "Board name must be between 3 and 100 characters")
  private String name;

  @Size(max = 500, message = "Description cannot exceed 500 characters")
  private String description;

  @NotNull(message = "Owner ID is required")
  private Long ownerId;
}
