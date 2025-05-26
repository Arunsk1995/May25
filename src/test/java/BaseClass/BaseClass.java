package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static RequestSpecification given;
	public static Response response;

	public static void baseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
		given = RestAssured.given();
		//Already changes made
	}

	public static void queryParameter(String parameterName, String parameterValue) {
		given.queryParam(parameterName, parameterValue);
	}

	public static void pathParameter(String parameterName, String parameterValue) {
		given.pathParam(parameterName, parameterValue);
	}

	public static void body(Object object) {
		given.body(object);

	}

	public static void body(HashMap<String, Object> hm) {
		hm.put("name", "Arun");
		hm.put("job", "Leader");

		given.body(hm);
	}

	public static void body(JSONObject jsonObject) {

		jsonObject.put("name", "Arun");
		jsonObject.put("job", "Leader");
		given.body(jsonObject.toJSONString());

	}

	public static void header(String type, String value) {
		given.header(type, value);
	}

	public static void methodType(String requestType, String resources) {

		switch (requestType) {
		case "GET":
			response = given.request(Method.GET, resources);

			break;
		case "POST":
			response = given.request(Method.POST, resources);

			break;
		case "PUT":
			response = given.request(Method.PUT, resources);

			break;
		case "DELETE":
			response = given.request(Method.DELETE, resources);

			break;

		}

	}

	public static void statusCode() {
		System.out.println(response.getStatusCode());
	}

	public static String responseBody() {
		System.out.println(response.getBody().asPrettyString());
		String asPrettyString = response.getBody().asPrettyString();
		return asPrettyString;

	}

	public String getvalueFromExcel(int r, int c) throws IOException {
		File file = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\ApiRestAssured\\src\\test\\resources\\Payload_API.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(r);

		Cell cell = row.getCell(c);
		String data = null;
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			data = cell.getStringCellValue();

			break;
		default: {
			double numericCellValue = cell.getNumericCellValue();
			BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
			data = valueOf.toString();

		}

		}
		return data;
	}

}
