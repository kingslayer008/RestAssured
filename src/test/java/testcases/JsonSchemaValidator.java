package testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {

    @Test
    public void get()
    {
        baseURI = "http://reqres.in";
        given().
                get("/api/users?page=2").
                then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
                statusCode(200).log().all();
    }
}
