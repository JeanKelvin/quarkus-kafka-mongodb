package org.acme.quarkus.sample;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

    @Inject FruitService fruitService;

    @GET
    public List<Fruit> list() {
        return fruitService.list();
    }
}