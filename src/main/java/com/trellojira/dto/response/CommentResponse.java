package com.trellojira.dto.response;

import java.time.OffsetDateTime;

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

  private OffsetDateTime createdAt;

  private OffsetDateTime updatedAt;
}
