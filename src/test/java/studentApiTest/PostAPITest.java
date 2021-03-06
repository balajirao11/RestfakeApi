package studentApiTest;

import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JavaUtilis;

public class PostAPITest extends BaseTest {

	String id;

	@Test(priority = 1)
	public void validPostAPITest() {

		test.log(LogStatus.INFO, "My test is starting.....");

		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		id = JavaUtilis.randomNumebr();

		Response response = RestAssured
				.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody(JavaUtilis.randomNumebr(),
						JavaUtilis.randomNumebr(), JavaUtilis.randomStrig(), JavaUtilis.randomStrig()))
				.when().post(APIPath.apiPath.CREATE_POST);

		System.out.println(response.getBody());
		System.out.println(response.statusCode());

		APIVerification.responseKeyValidationFromJsonObject(response, "title");
		APIVerification.responseCodeValiddation(response, 201);
		APIVerification.responseTimeValidation(response);

		String resp = response.asString();
		System.out.println(resp);

		test.log(LogStatus.INFO, "My test has been ended.....");

		// JsonPath js = new JsonPath(resp);
		// System.out.println("Response :" +resp);

	}
	/*
	 * @Test(priority =2) public void invalidPostAPITest() {
	 * 
	 * }
	 * 
	 */
}
