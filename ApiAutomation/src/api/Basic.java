
package api;

import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



import Data.payload;
import resuable.*;
public class Basic {
	
	public static void main(String[] args)
	{
		//given-- all input details
		//when -- submit the api
		//then -- validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String resp =	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
		.statusCode(200).body("scope", equalTo("APP")).
		header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
	
	
		String placeid = Utilties.extractData(resp, "place_id");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", "qaclick123");
		map.put("place_id", placeid);
		
		
		String locationBeforeUpdate = given().log().all().queryParams(map).when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Adress before Update: "+Utilties.extractData(locationBeforeUpdate, "address"));
		
		
		given().log().all().queryParams(map).header("Content-Type","application/json").body(payload.updateAddressPayLoad(placeid)).when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String getApi = given().log().all().queryParams(map).when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Adress after Update: "+Utilties.extractData(getApi, "address"));
				
				
	
	
	
		
		
	}

}
