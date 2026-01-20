package com.trellojira.comment.service;

import org.springframework.stereotype.Service;

import com.trellojira.card.repository.ICardRepository;
import com.trellojira.comment.repository.ICommentRepository;
import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.dto.request.CommentRequest;
import com.trellojira.user.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final ICommentRepository repository;
  private final ICardRepository cardRepository;
  private final IUserRepository userRepository;
  private final ModelMapper mapper;

  public void save(CommentRequest request) {
    if (cardRepository.existsById(request.getCardId()) && userRepository.existsById(request.getAuthorId())) {

      var card = cardRepository.findById(request.getCardId()).get();
      var user = userRepository.findById(request.getAuthorId()).get();

      repository.save(mapper.toComment(request, card, user));
    }
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
