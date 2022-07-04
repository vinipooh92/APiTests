package api;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import resuable.Utilties;
import uiAutomation.GetAccessCode;

public class Oauth2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Map<String,String> tokens = new HashMap<String,String>();
		String code = GetAccessCode.getAccessCodeGoogle();
		tokens.put("code", code);
		tokens.put("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
		tokens.put("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
		tokens.put("redirect_uri", "https://rahulshettyacademy.com/getCourse.php");
		tokens.put("grant_type", "authorization_code");
		
		String response = given().urlEncodingEnabled(false).log().all().queryParams(tokens).when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().
				assertThat().statusCode(200).extract().response().asString();
		
		String accessToken = Utilties.extractData(response, "access_token");
		
		
		String resp = given().queryParam("access_token", accessToken).when().get("https://rahulshettyacademy.com/getCourse.php").then()
		.log().all().assertThat().
		statusCode(200).extract().response().asString();
		
	
	}

}
