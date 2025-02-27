package com.ctw.workstation.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockResource implements QuarkusTestResourceLifecycleManager {

    WireMockServer wiremockServer;

    @Override
    public Map<String, String> start() {
        wiremockServer = new WireMockServer();
        //WireMockConfiguration.options().dynamicPort()
        //WireMock.configureFor("localhost", wiremockServer.port());

        wiremockServer.start();

        wiremockServer.stubFor(get(urlEqualTo("/external/hello"))
                .willReturn(aResponse()
                    .withStatus(200)));
        
        wiremockServer.stubFor(post(urlEqualTo("/external/hello"))
                .willReturn(aResponse()
                .withStatus(200)
                        .withBody("Hello Nuno!")));

        return Map.of("external-api.url", wiremockServer.baseUrl());
    }

    @Override
    public void stop() {
        wiremockServer.stop();
    }
}
