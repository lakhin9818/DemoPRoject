package Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Base.Base;
import Data.payload;
import io.restassured.path.json.JsonPath;

public class post extends Base {
	private static String place_id;

	public static String getPlace_id() {
		System.out.println("getting place id in getter" + place_id);
		return place_id;
	}

	public static String setPlace_id(String place_id) {
		post.place_id = place_id;
		System.out.println("setter place id " + place_id);
		return place_id;
	}

	@Test
	public Object addPlace() {
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(payload.AddPlace()).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);

		JsonPath js = JsonReader(response);
		String place_id = setPlace_id(js.getString("place_id"));
		System.out.println("place id captured is:********************************** " + getPlace_id());
		return setPlace_id(place_id);
	}

	@Test(enabled = false)
	public static void get() {
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", getPlace_id()).header("Content-Type", "application/json").when()
				.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		JsonPath js = JsonReader(response);

		if (js.getString("website").contains("rahulshettyacademy")) {
			System.out.println("  place id is saving **" + post.getPlace_id());

		} else if (js.getString("msg").contains("place_id  doesn't exists")) {
			System.out.println("check place id post wala " + getPlace_id());
		}

	}

//	public String SetPlace_id(String place_id) {
//		System.out.println("updating place id " + place_id);
//		return this.setPlace_id(place_id);
//	}
//
//	public static String getPlaceID() {
//		System.out.println("inside post class getter" + getPlace_id());
//		return getPlace_id();
//	}
}