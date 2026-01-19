package com.trellojira.user.service;

import org.springframework.stereotype.Service;

import com.trellojira.user.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final IUserRepository repository;
}
