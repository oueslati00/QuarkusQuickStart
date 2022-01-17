package com.example;

import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {

    // connect to product service via ... to get all service list

    public Multi<Integer> getProduct() {
        return Multi.createFrom().items(1,2,-1,4,5,6);

    }


}
