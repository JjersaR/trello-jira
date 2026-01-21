package com.trellojira.dto.response;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
  private Long id;
  private String title;
  private String description;
  private Integer position;
  private ColumnResponse column;
  private UserResponse assignedTo;
  private UserResponse createdBy;
  private OffsetDateTime dueDate;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
  private String priority;
  private Integer commentsCount;
  private List<CommentResponse> comments;
}
