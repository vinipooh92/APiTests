package api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import resuable.Utilties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import Data.payload;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8081";
		SessionFilter session = new SessionFilter();
		String resp = given().log().all().header("Content-Type","application/json").
				body(payload.getSessionIdJira("vinipooh", "MangoFruit@2021"))
		.filter(session).when().post("rest/auth/1/session").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//String sessionID = Utilties.extractData(resp, "session.name") +"="+ Utilties.extractData(resp, "session.value");
		//System.out.println(sessionID);
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type","application/json");
	
		//headers.put("cookie", sessionID);
		String createIssueResp = given().log().all().headers(headers).body(payload.createIssue("this is created from java code session file attachement", "Story"))
				.filter(session).when().post("/rest/api/2/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		String issueID = Utilties.extractData(createIssueResp, "id");
		String commentAdded = "this is from  def session java api file attachement to verify the commentAdded api";
		String commentResponse = given().log().all().headers(headers).pathParam("issueID", issueID).
				body(payload.addCommentToIssue(commentAdded)).
		filter(session).when().post("http://localhost:8081/rest/api/2/issue/{issueID}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		String commentID = Utilties.extractData(commentResponse, "id");
		
		Map<String,String> fileMapHeaders = new HashMap<String,String>();
		
		fileMapHeaders.put("Content-Type","multipart/form-data");
		fileMapHeaders.put("X-Atlassian-Token", "no-check");
		
		given().log().all().headers(fileMapHeaders).pathParam("issueID", issueID).
		multiPart("file",new File("E:\\ApiTest\\ApiAutomation\\src\\jira.txt")).
		filter(session).when().post("/rest/api/2/issue/{issueID}/attachments").then().
		log().all().assertThat().statusCode(200);
		
		
		
		
		Map<String,String> filters = new HashMap<String,String>();
		filters.put("fields", "comment");
		String commentResponseFilter = given().log().all().pathParam("issueID", issueID).queryParams(filters).filter(session).when().get("/rest/api/2/issue/{issueID}").then().
		log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Utilties.jsonStuff(commentResponseFilter);
		
		int countOfComment = js.getInt("fields.comment.comments.size()");
		String comment="";
		for(int i = 0; i<countOfComment;i++)
		{
			String id = js.getString("fields.comment.comments["+i+"].id");
			if(id.equals(commentID))
			{
				comment = js.getString("fields.comment.comments["+i+"].body");
			
			}
		}
		
		Assert.assertEquals(comment, commentAdded);

	}

}
