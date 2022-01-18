package com.example.MongoEntity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.panache.common.Page;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.transaction.Status;
import java.util.List;

@MongoEntity(collection = "product")
public class Product extends PanacheMongoEntity {
    @BsonProperty("product_name")
    public String name;

    public Status status;

    public Double price;

    public static List<Product>  findByName(String name){
        return find("name",name).list();
    }

    public static List<Product> FindAlive(){
        return list("status", Status.STATUS_ACTIVE);
    }
    public void setName(String name){
        this.name = name.toLowerCase();
    }
    public static void deleteProductByName(String name){
        delete("name",name);
    }
}
