package com.example;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import com.example.MongoEntity.Product;
import org.bson.types.ObjectId;


@Path("/Product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService productService;

    @POST
    @Path("empty")
    public Response createEmptyProduct(){
        Product p2 = new Product();
        p2.persist();
        return Response.status(201).build();
        }
    @GET
    public Response getAllProduct(){
       List<Product> list = Product.findAll().list();
       return Response.status(201).entity(list).build();
    }
    @GET
    @Path("/{name}")
    public Response getProductByName(@PathParam("name") String name){
        System.out.println("get =>" + name);
        List<Product> list_product = Product.findByName(name);
        return Response.status(201).entity(list_product).build();
    }
    @POST
    public Response createProduct(Product product){
        product.persist();
        return Response.status(201).build();
    }
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") ObjectId id ,Product product){
        Product p =Product.findById(id);
        if(p ==null){
            return Response.status(404, "this Product does not found ").build();
        }
        product.id = id;
        Product.update(product);
        return Response.status(201,"the product was create successfully").build();
    }
    @DELETE
    public Response deleteAll(){
        Product.deleteAll();
        return Response.status(201,"all the product was deleted").build();
    }
}
