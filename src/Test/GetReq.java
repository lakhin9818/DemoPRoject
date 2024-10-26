package Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Base;
import io.restassured.path.json.JsonPath;
import Test.post;
public class GetReq extends Base {
	SoftAssert sa = new SoftAssert();

	@Test
	public static void get() {
		String place_id = post.getPlace_id();

		System.out.println("used  place id is **" + place_id);
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", post.getPlace_id()).header("Content-Type", "application/json").when()
				.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		JsonPath js = JsonReader(response);

		if (js.getString("website").contains("rahulshettyacademy")) {
			System.out.println("used  place id is ***" + post.getPlace_id());

		} else if (js.getString("msg").contains("place_id  doesn't exists")) {
			System.out.println("check place id " + post.getPlace_id());
		}

	}

}
