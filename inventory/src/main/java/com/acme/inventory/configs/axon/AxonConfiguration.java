package com.acme.inventory.configs.axon;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.queryhandling.DefaultQueryGateway;
import org.axonframework.queryhandling.QueryBus;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {
  @Bean
  public CommandGateway getCommandGateway(CommandBus commandBus) {
    return DefaultCommandGateway.builder().commandBus(commandBus).build();
  }

  @Bean
  public QueryGateway getQueryGateway(QueryBus queryBus) {
    return DefaultQueryGateway.builder().queryBus(queryBus).build();
  }
}
