package com.example;

import io.quarkus.runtime.annotations.RegisterForReflection;


/*
*
@RegisterForReflection

The @RegisterForReflection annotation instructs Quarkus to include the class (including fields and methods)
*  when building the native executable. This will be useful later when we run the applications as native
*  executables inside containers. Without, the native compilation would remove the fields and methods during
* the dead-code elimination phase.
* */


@RegisterForReflection
public class Quote {
    public String id;
    public int price;

    /**
     * Default constructor required for Jackson serializer
     */
    public Quote() { }

    public Quote(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
