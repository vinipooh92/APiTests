package api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.payload;
import io.restassured.RestAssured;
import resuable.Utilties;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class LibraryAPI {
	
	@BeforeMethod
	public void SettingBaseURI()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
	}
	
	@Test(dataProvider = "bookData")
	public void addBook(String bookName,String isbn,String author,String aisle)
	{
		String resp = given().log().all().header("Content-Type","application/json").body(payload.addBook(bookName,isbn,author,aisle)).when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		String book_id = Utilties.extractData(resp, "ID");
		System.out.println("bookid: "+book_id);
	}
	
	@Test(dataProvider = "bookData")
	public void deleteBook(String bookName, String isbn, String author, String aisle)
	{
		String id = isbn+aisle;
		given().log().all().header("Content-Type","application/json").body(payload.deleteBook(id)).when().post("/Library/DeleteBook.php").then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("book is successfully deleted"));
	}
	
	@DataProvider(name="bookData")
	public Object[][] getData()
	{
		return new Object[][] {{"Java Book1","jb3456","Vinitha","9087"},{"Csharpbook","cs102","Vinitha","345"},{"JavaScript","js102","Vinitha","789"}};
	}
	
	

}
