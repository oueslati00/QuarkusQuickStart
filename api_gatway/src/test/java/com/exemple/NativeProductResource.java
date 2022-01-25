package com.exemple;

import com.google.common.net.HttpHeaders;

import io.quarkus.test.junit.DisabledOnNativeImage;
import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Test;


import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;


@NativeImageTest
public class NativeProductResource extends ProductResource {
    //TODO: Run the same tests

    // write some code from book

    @Test
    void shouldPingOpenAPI(){
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/openapi")
                .then()
                .statusCode(OK.getStatusCode());
    }
    /*
    *  disable swagger test in native image
    * */
    @DisabledOnNativeImage
    @Test
    void shouldPingSwaggerUI(){
        given()
                .when()
                .get("/swagger-ui")
                .then()
                .statusCode(OK.getStatusCode());
    }


}
