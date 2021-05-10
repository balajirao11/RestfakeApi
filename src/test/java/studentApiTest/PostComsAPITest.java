package studentApiTest;

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
import io.restassured.response.Response;
import utils.JavaUtilis;

public class PostComsAPITest extends BaseTest {

	String id;

	@Test(priority = 1)
	public void validCommAPITest() {

		test.log(LogStatus.INFO, "My test is starting.....");

		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();

		id = JavaUtilis.randomNumebr();

		Response response = RestAssured.given().when().headers(header.defaultHeaders())
				.body(builder.postComRequestBody(JavaUtilis.randomNumebr(), JavaUtilis.randomStrig(),
						JavaUtilis.randomStrig(), JavaUtilis.randomStrig()))
				.when().post(APIPath.apiPath.CREATE_COMMENTS);

		System.out.println(response.getBody());
		System.out.println(response.statusCode());

		String resp = response.asString();
		System.out.println(resp);

		APIVerification.responseKeyValidationFromJsonObject(response, "title");
		APIVerification.responseCodeValiddation(response, 201);
		APIVerification.responseTimeValidation(response);

		test.log(LogStatus.INFO, "My test has been ended.....");

	}

}
