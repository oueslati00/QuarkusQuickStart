package com.example;


import io.smallrye.mutiny.Multi;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import com.example.MongoEntity.Product;
@Path("/Product")
public class ProductController {

    @Inject
    ProductService productService;


    /*@GET()
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Integer> getAllProducts(){
      return  productService.getProduct()
              .onSubscription().invoke(() -> System.out.println("⬇️ Subscribed"))
                .onItem().invoke(i -> System.out.println("⬇️ Received item: " + i))
                .onCompletion().invoke(() -> System.out.println("⬇️ Completed"))
                .onRequest().invoke(l -> System.out.println("⬆️ Requested: " + l));
    }
*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(){
        Product p2 = new Product();
        p2.persist();
        return Response.status(2001).build();
        }
}
