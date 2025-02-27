package com.ctw.workstation.simple;

import com.ctw.workstation.external.ExternalApi;
import com.ctw.workstation.external.ExternalRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class HelloAcademyExt {

    @Inject
    @RestClient
    ExternalApi externalApi;

    //ExternalMessageService externalMessageService;

    public String sayHello(String name) {
        //externalMessageService.fazAlgo();

        if (name != null) return externalApi.hello(new ExternalRequest(name)).message();
        else return externalApi.hello().message();
    }

}
