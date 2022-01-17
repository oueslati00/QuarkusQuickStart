package com.example;


import io.smallrye.mutiny.Multi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Product")
public class ProductController {

    @Inject
    ProductService productService;


    @GET()
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Integer> getAllProducts(){
      return  productService.getProduct()
              .onSubscription().invoke(() -> System.out.println("⬇️ Subscribed"))
                .onItem().invoke(i -> System.out.println("⬇️ Received item: " + i))
                .onCompletion().invoke(() -> System.out.println("⬇️ Completed"))
                .onRequest().invoke(l -> System.out.println("⬆️ Requested: " + l));
    }
}
