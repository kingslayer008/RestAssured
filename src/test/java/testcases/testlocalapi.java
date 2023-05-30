package testcases;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testlocalapi {

    @Test
    public void get()
    {
        baseURI = "http://localhost:3000";
        given().
                get("/users").
        then().
            statusCode(200).log().all();
    }
    //@Test
    public void post()
    {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstname","agilesh");
        request.put("lastname","s");
        request.put("id",4);
        request.put("subid",1);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201);

    }
    //@Test
    public void put()
    {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstname","agil");
        request.put("lastname","s");
        request.put("id",4);
        request.put("subid",1);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/3").
                then().
                statusCode(200);

    }
    //@Test
    public void patch()
    {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstname","agil");
        request.put("lastname","ss");
        request.put("id",4);
        request.put("subid",1);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/3").
                then().
                statusCode(200);

    }
    @Test
    public void delete()
    {
        baseURI = "http://localhost:3000";

        when().
        delete("/users/3").
        then().
        statusCode(200);

    }
}
