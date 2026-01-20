package com.trellojira.card.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trellojira.card.repository.ICardRepository;
import com.trellojira.column.repository.IColumnRepository;
import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.dto.request.CardRequest;
import com.trellojira.dto.response.CardResponse;
import com.trellojira.user.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

  private final ICardRepository repository;
  private final IColumnRepository columnRepository;
  private final IUserRepository userRepository;
  private final ModelMapper mapper;

  public List<CardResponse> getByColumnId(Long id) {
    return repository.findByColumnId(id).stream().map(mapper::toCardResponse).toList();
  }

  public List<CardResponse> getByAssignedToId(Long id) {
    return repository.findByAssignedToId(id).stream().map(mapper::toCardResponse).toList();
  }

  public List<CardResponse> getByColumnIdOrder(Long id) {
    return repository.findByColumnIdOrderByPositionAsc(id).stream().map(mapper::toCardResponse).toList();
  }

  public void save(CardRequest card) {
    if (columnRepository.existsById(card.getColumnId()) && userRepository.existsById(card.getAssignedToId())
        && userRepository.existsById(card.getCreatedById())) {

      var column = columnRepository.findById(card.getColumnId()).get();
      var assignedTo = userRepository.findById(card.getAssignedToId()).get();
      var createdBy = userRepository.findById(card.getCreatedById()).get();

      repository.save(mapper.toCard(card, column, assignedTo, createdBy));
    }
  }

  public void delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    }
  }
}
