package mocking.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.mocking.APIMocks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockGetUserAPITest extends BaseTest{

	
	@Test
	public void getDummyUserMockAPITest() {
		
		APIMocks.defineGetUserMock();
		
		Response response = 
				restClient.get(BASE_URL_MOCK_SERVER, "/api/users", null, null, AuthType.NO_AUTH, ContentType.ANY);
		
		response.then()
				.assertThat()
					.statusCode(200);		
	}
	
	
	@Test
	public void getDummyUserMockAPIWithJsonFileTest() {
		
		APIMocks.defineGetUserMockWithJSONFile();
		
		Response response = 
				restClient.get(BASE_URL_MOCK_SERVER, "/api/users", null, null, AuthType.NO_AUTH, ContentType.ANY);
		
		response.then()
				.assertThat()
					.statusCode(200);		
	}
	
	
	@Test(enabled=false)
	public void getDummyUserMockAPIWithQueryParam() {
		
		APIMocks.defineGetUserMockWithQueryParam();
		
		Map<String, String> userQueryMap = new HashMap<String, String>();
		userQueryMap.put("name", "Naveen");
		
		Response response = 
				restClient.get(BASE_URL_MOCK_SERVER, "/api/users", userQueryMap, null, AuthType.NO_AUTH, ContentType.ANY);
		
		response.then()
				.assertThat()
					.statusCode(200);		
	}
	
	
	@Test
	public void createAFakeUserTest() {
		
		APIMocks.defineCreateUserMock();
		
		String dummyUserJson = "{\n"
				+ "    \"name\": \"Tom\"\n"
				+ "}";

		Response response = 
				restClient.post(BASE_URL_MOCK_SERVER, "/api/users", dummyUserJson, null, null, AuthType.NO_AUTH, ContentType.JSON);
		
		response.then()
				.assertThat()
					.statusCode(201);		
	}
	
	
	
	
	
	
}
