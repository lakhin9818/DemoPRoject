package Base;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Base {

	protected static RequestSpecification requestSpec;

	protected static JsonPath js;

	@BeforeClass
	public static void spec() {
		requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").build();

	}

	public static JsonPath JsonReader(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
