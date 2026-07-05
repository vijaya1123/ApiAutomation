package com.qa.api.mocking;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockSetup {

    private static WireMockServer server;

    public static void startWireMockServer() {
        server = new WireMockServer(9099);
        WireMock.configureFor("localhost", 9099);
        server.start();
    }

    public static void stopWireMockServer() {
        server.stop();
    }

}


