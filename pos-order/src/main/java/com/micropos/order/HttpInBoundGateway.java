package com.micropos.order;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.stereotype.Component;

@Component
public class HttpInBoundGateway {

    @Bean
    public IntegrationFlow inGate() {
        return IntegrationFlows.from(
                Http.inboundGateway("/delivery/{orderId}")
                        .headerExpression("orderId", "#pathVariables.orderId"))
                .channel("deliveryChannel")
                .get();
    }
}
