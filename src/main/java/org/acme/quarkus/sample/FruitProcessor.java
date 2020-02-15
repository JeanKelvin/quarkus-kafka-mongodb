package org.acme.quarkus.sample;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * A bean consuming data from the "fruit-in" Kafka topic and applying some price conversion.
 * The result is pushed to the "fruit-out" stream.
 */
@ApplicationScoped
public class FruitProcessor {

    @Inject
    private FruitService fruitService;

    @Incoming("fruit-in")
    @Outgoing("fruit-out")
    @Broadcast
    public String process(Fruit fruit) {
        this.fruitService.add(fruit);
        return fruit.getName();
    }
}