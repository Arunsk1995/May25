package RestAssured;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BaseClass.BaseClass;

public class PostLogin extends BaseClass {
	@BeforeMethod
	public void beforeMethod() {
		baseURI("https://petstore.swagger.io");
	}

	@Test
	public void postExecution() throws StreamReadException, DatabindException, IOException {

		header("Content-Type", "application/json");
		Category category = new Category(0, "String");
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("String");
		Tags tags1 = new Tags(0, "String");
		ArrayList<Tags> tags = new ArrayList<Tags>();
		tags.add(tags1);
		PostRoot root = new PostRoot(0, category, "doggie", photoUrls, tags, "available");
		body(root);
		methodType("POST", "v2/pet");
		statusCode();
		ObjectMapper obj = new ObjectMapper();
		PostRootD value = obj.readValue(responseBody(), PostRootD.class);
		System.out.println(value.getId());
		System.out.println(value.getCategory().getId());
		System.out.println(value.getCategory().getName());
		System.out.println(value.getName());
		System.out.println(value.getPhotoUrls().get(0));
		System.out.println(value.getTags().get(0).getId());
		System.out.println(value.getTags().get(0).getName());
		System.out.println(value.getStatus());

	}
	
	@Test(dataProvider="PostData")
	public void postExecutionWithDataProvider(int id,int id1, String name,String name1, String photoUrls,int id2,String name2,String status) throws StreamReadException, DatabindException, IOException {

		header("Content-Type", "application/json");
		Category category = new Category(id1, name);
		ArrayList<String> photoUrls1 = new ArrayList<String>();
		photoUrls1.add(photoUrls);
		Tags tags1 = new Tags(id2, name2);
		ArrayList<Tags> tags = new ArrayList<Tags>();
		tags.add(tags1);
		PostRoot root = new PostRoot(id, category, name1, photoUrls1, tags, status);
		body(root);
		methodType("POST", "v2/pet");
		statusCode();
		ObjectMapper obj = new ObjectMapper();
		PostRootD value = obj.readValue(responseBody(), PostRootD.class);
		System.out.println(value.getId());
		System.out.println(value.getCategory().getId());
		System.out.println(value.getCategory().getName());
		System.out.println(value.getName());
		System.out.println(value.getPhotoUrls().get(0));
		System.out.println(value.getTags().get(0).getId());
		System.out.println(value.getTags().get(0).getName());
		System.out.println(value.getStatus());

	}
	
	@DataProvider(name ="PostData")
	public Object[][] dataProvider() throws IOException {
     Object[][]obj= new Object[][] {
    	 {(int) Double.parseDouble(getvalueFromExcel(1, 0)),(int) Double.parseDouble(getvalueFromExcel(1, 1)),getvalueFromExcel(1, 2),getvalueFromExcel(1, 3),getvalueFromExcel(1, 4),(int) Double.parseDouble(getvalueFromExcel(1, 5)),getvalueFromExcel(1, 6),getvalueFromExcel(1, 7)},
    	 {(int) Double.parseDouble(getvalueFromExcel(2, 0)),(int) Double.parseDouble(getvalueFromExcel(2, 1)),getvalueFromExcel(2, 2),getvalueFromExcel(2, 3),getvalueFromExcel(2, 4),(int) Double.parseDouble(getvalueFromExcel(2, 5)),getvalueFromExcel(2, 6),getvalueFromExcel(2, 7)},
    	 {(int) Double.parseDouble(getvalueFromExcel(3, 0)),(int) Double.parseDouble(getvalueFromExcel(3, 1)),getvalueFromExcel(3, 2),getvalueFromExcel(3, 3),getvalueFromExcel(3, 4),(int) Double.parseDouble(getvalueFromExcel(3, 5)),getvalueFromExcel(3, 6),getvalueFromExcel(3, 7)},
    	 {(int) Double.parseDouble(getvalueFromExcel(4, 0)),(int) Double.parseDouble(getvalueFromExcel(4, 1)),getvalueFromExcel(4, 2),getvalueFromExcel(4, 3),getvalueFromExcel(4, 4),(int) Double.parseDouble(getvalueFromExcel(4, 5)),getvalueFromExcel(4, 6),getvalueFromExcel(4, 7)}
    	 };
	return obj;
	}
	
	

}
