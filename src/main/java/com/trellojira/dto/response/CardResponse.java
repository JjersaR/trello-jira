package com.trellojira.dto.response;

import java.time.LocalDateTime;
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
  private LocalDateTime dueDate;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String priority;
  private Integer commentsCount;
  private List<CommentResponse> comments;
}
