package com.trellojira.comment.service;

import org.springframework.stereotype.Service;

import com.trellojira.comment.repository.ICommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final ICommentRepository repository;
}
