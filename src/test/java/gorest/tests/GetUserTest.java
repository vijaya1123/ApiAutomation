package gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import com.qa.api.constants.AuthType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserTest extends BaseTest{
	
	
	
	@Test
	public void getAllUsersTest() {
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, null, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"));
	}
	
	
	@Test
	public void getAllUsersWithQueryParamTest() {
		
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("name", "vijay");
		queryMap.put("status", "active");
		
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, queryMap, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"));
	}
	
	
	@Test
	public void getSingleUserTest() {
		
		String userId = "8522342"; //8522343 //8522344//8522346//8522347
		
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT+"/"+userId, null, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"));
	}
}
	
	/*
	 *
[
    {
        "id": 8522347,
        "name": "Revathy",
        "email": "apiautomation1782455915613@api.com",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8522346,
        "name": "Harsh",
        "email": "apiautomation1782455914358@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522344,
        "name": "Sandesh",
        "email": "apiautomation1782455913027@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522343,
        "name": "Jyothi",
        "email": "apiautomation1782455911700@api.com",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8522342,
        "name": "Karim",
        "email": "apiautomation1782455909599@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522336,
        "name": "Tom",
        "email": "apiautomation1782455815846@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522335,
        "name": "Revathy",
        "email": "apiautomation1782455765364@api.com",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8522334,
        "name": "Harsh",
        "email": "apiautomation1782455759233@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522333,
        "name": "Sandesh",
        "email": "apiautomation1782455758499@api.com",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8522332,
        "name": "Jyothi",
        "email": "apiautomation1782455754523@api.com",
        "gender": "female",
        "status": "inactive"
    }
]
[
    {
        "id": 8522295,
        "name": "Vijay Sharma ",
        "email": "vijaympct03@gmail.com",
        "gender": "male",
        "status": "active"
    }
]
Requ
Body:			<none>
{
    "id": 8522342,
    "name": "Karim",
    "email": "apiautomation1782455909599@api.com",
    "gender": "male",
    "status": "active
	 * */
	 

