package com.qa.api.mocking;


import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public class APIMocks {


    //*************** Create Mock/Stub for GET CALL *************//

    public static void defineGetUserMock() {

        //http://localhost:8089/api/users

        stubFor(get(urlEqualTo("/api/users"))

                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n"
                                + "    \"id\": 1,\n"
                                + "    \"name\": \"Karim\",\n"
                                + "    \"age\": 30,\n"
                                + "    \"salary\": 23.33\n"
                                + "}")
                )
        );

    }


    public static void defineGetUserMockWithJSONFile() {

        //http://localhost:8089/api/users

        stubFor(get(urlEqualTo("/api/users"))

                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mockuser.json")
                )
        );

    }


    public static void defineGetUserMockWithQueryParam() {

        //http://localhost:8089/api/users?name=Karim

        stubFor(get(urlPathEqualTo("/api/users"))
                .withQueryParam("name", equalTo("Karim"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("server", "bank server")
                        .withBodyFile("mockuser.json")
                )
        );

    }


    //*************** Create Mock/Stub for POST CALL *************//


    public static void defineCreateUserMock() {

        stubFor(post(urlEqualTo("/api/users"))
                .withHeader("Content-Type", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("server", "bank server")
                        .withBody("{\n"
                                + "    \"id\": 101,\n"
                                + "    \"name\": \"Tom\",\n"
                                + "    \"age\": 33,\n"
                                + "    \"salary\": 43.33\n"
                                + "}")
                ));
    }






}
