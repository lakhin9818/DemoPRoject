package Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Base;
import Data.payload;
import io.restassured.path.json.JsonPath;

public class post extends Base {
	private static String place_id;

	public static String getPlace_id() {
//		System.out.println("getting place id in getter" + place_id);
		return place_id;
	}

	public static String setPlace_id(String place_id) {
		post.place_id = place_id;
//		System.out.println("setter place id " + place_id);
		return place_id;
	}

	@Test(priority = 1, testName = "Post req")
	public static String addPlace() {
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(payload.AddPlace()).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);

		JsonPath js = JsonReader(response);
		String place_id = setPlace_id(js.getString("place_id"));
//		System.out.println("place id captured is:********************************** " + getPlace_id());
		return setPlace_id(place_id);
	}

	@Test(enabled = true)
	public static void Update() {
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(payload.update()).when()
				.put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		JsonPath js = JsonReader(response);
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(js.getString("msg"), "Address successfully updated", "msg verified ");
		if (js.getString("msg").contains("updated")) {
			System.out.println(" msg displayed for update action**" + js.getString("msg"));

		} else if (js.getString("msg").contains("Update address operation failed")) {
			System.out.println("Update address operation failed ");
		}

	}

	@Test(enabled = true)
	public static void Delete() {
		String response = given().spec(requestSpec).log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body("{\r\n" + "\r\n" + "    \"place_id\":\"" + getPlace_id() + "\"\r\n" + "}").when()
				.delete("maps/api/place/delete/json").then().log().all().assertThat().statusCode(200)
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		JsonPath js = JsonReader(response);
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(js.getString("status"), "OK", "msg verified ");
		if (js.getString("status").contains("OK")) {
			System.out.println(" msg displayed for delete action*" + js.getString("status"));

		} else if (js.getString("msg").contains("Update address operation failed")) {
			System.out.println("Update address operation failed ");
		}

	}

}