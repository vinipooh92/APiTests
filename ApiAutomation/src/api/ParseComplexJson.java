package api;

import org.testng.Assert;

import Data.payload;
import io.restassured.path.json.JsonPath;
import resuable.Utilties;

public class ParseComplexJson {
	
	public static void main(String [] args)
	{
		JsonPath js = Utilties.jsonStuff(payload.complexJson());
		int totalNumberOfCourses = js.getInt("courses.size()");
		System.out.println("total number of courses: "+totalNumberOfCourses);
		int totalpurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("total Purchase amount: "+totalpurchaseAmount);
		String titleName = js.get("courses[0].title");
		System.out.println("Courses title name: "+titleName);
		int total = 0;
		for(int i=0; i<totalNumberOfCourses;i++)
		{
			System.out.println("CourseName: "+js.get("courses["+i+"].title"));
			System.out.println("Price: "+js.get("courses["+i+"].price"));
			total = total + (js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
			
			
		}
		
		Assert.assertEquals(total, totalpurchaseAmount);
		
		System.out.println("total amount: "+total+" total purchaseamount: "+totalpurchaseAmount);
		
		
		
		
	}

}
