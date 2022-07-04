package Data;

public class payload {
	
	public static String addPlace()
	{
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Frontline house\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String updateAddressPayLoad(String placeID)
	{
		return "{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\"Bangalore\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String complexJson()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String addBook(String title,String isbn, String author, String aisle) {
		return "{\r\n"
				+ "\"name\":\""+title+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\""+author+"\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String deleteBook(String bookId)
	{
		return "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+bookId+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
	}
	
	public static String getSessionIdJira(String userName, String password)
	{
		return "{ \"username\": \""+userName+"\", \"password\": \""+password+"\" }";
	}
	
	
	public static String createIssue(String summary, String issueType)
	{
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RSA\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \""+summary+"\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \""+issueType+"\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
	}
	
	
	public static String addCommentToIssue(String comment)
	{
		return "{\r\n"
				+ "    \"body\": \""+comment+"\"\r\n"
				+ "    \r\n"
				+ "}";
	}

}
