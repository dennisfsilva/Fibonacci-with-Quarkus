package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fibonacci")
public class FibonacciResource {

    @Inject
    FibonacciService fibonacciService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{number}")
    public Long calculateFibonacci(@PathParam("number") Long n) {
        return fibonacciService.calculateFibonacci(n);
    }
}
