package com.trellojira.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
  private Long id;

  private String content;

  private Long cardId;

  private String authorUsername;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
