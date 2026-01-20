package com.trellojira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import graphql.scalars.ExtendedScalars;

@Configuration
public class GraphQLScalarConfig {
  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    return wiringConfigurer -> wiringConfigurer
        .scalar(ExtendedScalars.DateTime)
        .scalar(ExtendedScalars.Date)
        .scalar(ExtendedScalars.Time);
  }
}
