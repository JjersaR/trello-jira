package com.trellojira.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnResponse {
  private Long id;

  private String name;

  private Integer position;

  private Long boardId;

  private Integer cardsCount;

}
