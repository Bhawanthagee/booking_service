package com.bawa.booking_service.util;

import com.bawa.booking_service.dto.res.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MSCalls {

    @Autowired
    WebClient webClient;

    public StandardResponse callMCWithBodyValues(String url,Object bodyValue){
        return webClient.post()
                .uri(url)
                .bodyValue(bodyValue)
                .retrieve()
                .bodyToMono(StandardResponse.class)
                .block();
    }
    public StandardResponse callMCWithReqParam(String url, String paramName, Object paramValue) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam(paramName, paramValue)
                        .build()
                )
                .retrieve()
                .bodyToMono(StandardResponse.class)
                .block();
    }


}
