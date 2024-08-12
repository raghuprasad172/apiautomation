package org.generalUtility;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class JsonUtility {
FileUtility fileUtility = new FileUtility();

    public String getAccessToken() {
        String access_token = null;
        try {
          Response response=given()
                    .formParam("client_id",fileUtility.getDataFromPropertyFile("clientID"))
                    .formParam("client_secret",fileUtility.getDataFromPropertyFile("clientSecret"))
                    .formParam("grant_type","client_credentials")
                    .when()
                    .post(fileUtility.getDataFromPropertyFile("BaseURI")+"<<endpoint>>");
                   response.then().log().all();
            access_token =  response.jsonPath().get("access_token");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return  access_token;
    }
}
