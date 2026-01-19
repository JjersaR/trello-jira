package com.trellojira.column.service;

import org.springframework.stereotype.Service;

import com.trellojira.column.repository.IColumnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColumnService {

  private final IColumnRepository repository;
}
