package resuable;

import io.restassured.path.json.JsonPath;

public class Utilties {
	
	public static JsonPath jsonStuff(String reposonse)
	{
		JsonPath jsonApi = new JsonPath(reposonse);
		return jsonApi;
	}
	
	public static String extractData(String response, String param)
	{
		return jsonStuff(response).get(param);
	}

}