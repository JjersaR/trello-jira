package com.trellojira.dto.request;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CardRequest {
  @NotBlank(message = "Card title is required")
  @Size(min = 3, max = 200, message = "Card title must be between 3 and 200 characters")
  private String title;

  @Size(max = 2000, message = "Description cannot exceed 2000 characters")
  private String description;

  @Pattern(regexp = "^\\d+$", message = "Position must be a positive integer")
  private Integer position;

  @NotNull(message = "Column ID is required")
  private Long columnId;

  @Pattern(regexp = "^\\d+$", message = "Assigned to must be a positive integer")
  private Long assignedToId;

  @NotNull(message = "Created by ID is required")
  private Long createdById;

  private OffsetDateTime dueDate;

  private String priority;
}
