package witek.marcin.smarthome.pollution.client.rest;

import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

@Configuration
public class PollutionRestClientConfiguration {

    @Bean
    RestTemplate restTemplate(SSLContext sslContext, PollutionRestProperties pollutionRestProperties) {
        RestTemplate restTemplate = new RestTemplate(createClientHttpRequestFactory(sslContext));
        restTemplate.setUriTemplateHandler(createUriTemplateHandler());
        restTemplate.getInterceptors().add(createHttpRequestsInterceptor(pollutionRestProperties));
        return restTemplate;
    }
    
    @Bean
    PollutionRestClient pollutionRestClient(RestTemplate restTemplate){
        return new PollutionRestClient(restTemplate);
    }

    @Bean(name = "sslContext")
    SSLContext sslContext() throws KeyManagementException, NoSuchAlgorithmException {
        return SSLContextBuilder.create().build();
    }

    private ClientHttpRequestInterceptor createHttpRequestsInterceptor(PollutionRestProperties pollutionRestProperties) {
        return (request, body, execution) -> {
            request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            request.getHeaders().set("Accept-Language", pollutionRestProperties.getLanguage());
            request.getHeaders().set("apikey", pollutionRestProperties.getApiKey());
            return execution.execute(request, body);
        };
    }

    private ClientHttpRequestFactory createClientHttpRequestFactory(SSLContext sslContext) {
        return new HttpComponentsClientHttpRequestFactory(createHttpClient(sslContext));
    }

    private HttpClient createHttpClient(SSLContext sslContext) {
        return HttpClients.custom().setSSLContext(sslContext).build();
    }

    private UriTemplateHandler createUriTemplateHandler() {
        String baseUriTemplate = buildBaseUriForAirly();
        return new DefaultUriBuilderFactory(baseUriTemplate);
    }

    private String buildBaseUriForAirly() {
        return "https://airapi.airly.eu";
    }


}
