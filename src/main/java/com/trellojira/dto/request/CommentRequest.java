package com.trellojira.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentRequest {
  @NotBlank(message = "Content is required")
  @Size(min = 3, max = 100, message = "Content must be between 3 and 100 characters")
  private String content;

  @Pattern(regexp = "^\\d+$", message = "Card ID must be a positive integer")
  private Long cardId;

  @Pattern(regexp = "^\\d+$", message = "Author ID must be a positive integer")
  private Long authorId;
}
