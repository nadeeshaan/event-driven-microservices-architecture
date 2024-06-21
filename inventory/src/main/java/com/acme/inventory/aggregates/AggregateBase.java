package com.acme.inventory.aggregates;

import org.axonframework.modelling.command.AggregateIdentifier;

public class AggregateBase {
    @AggregateIdentifier
    protected String id;
}
