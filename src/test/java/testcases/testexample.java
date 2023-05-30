package testcases;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;


public class testexample {
    @Test
    public void test_01()
    {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        int status = response.getStatusCode();
        Assert.assertEquals(status, 200);
    }

    @Test
    public void test_02()
    {
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
        then().
               statusCode(200).
               body("data[1].id", equalTo(8));
    }

    @Test
    public void test_post()
    {
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                post("/users").
        then().
                statusCode(201).log().all();

    }
    @Test
    public void test_put()
    {
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                put("/user/2").
                then().
                statusCode(200).log().all();

    }
    @Test
    public void test_patch()
    {
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                patch("/user/2").
                then().
                statusCode(200).log().all();

    }
    @Test
    public void test_delete()
    {
        baseURI = "https://reqres.in";
        JSONObject request = new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");
        when().
        delete("/api/user/2").
        then().
        statusCode(204).log().all();

    }
}
