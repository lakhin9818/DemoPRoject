package Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Base;
import io.restassured.path.json.JsonPath;

public class GetReq extends Base {
	SoftAssert sa = new SoftAssert();

	@Test(enabled = true, priority = 2)
	public static void get() {
		Object pID = post.addPlace();

		System.out.println("used  place id in get req **" + pID);
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", post.getPlace_id()).header("Content-Type", "application/json").when()
				.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		JsonPath js = JsonReader(response);

		if (js.getString("website").contains("rahulshettyacademy")) {
			System.out.println("verification done website name checked");

		} else if (js.getString("msg").contains("place_id  doesn't exists")) {
			System.out.println("check place id " + post.getPlace_id());
		}

	}

}
