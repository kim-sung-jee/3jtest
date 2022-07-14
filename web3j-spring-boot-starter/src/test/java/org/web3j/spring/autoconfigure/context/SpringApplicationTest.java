package org.web3j.spring.autoconfigure.context;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.web3j.protocol.Web3j;

import static org.mockito.Mockito.mock;

@SpringBootApplication
public class SpringApplicationTest {
    @Bean
    @Primary
    public Web3j nameService() {
        return mock(Web3j.class, Mockito.RETURNS_DEEP_STUBS);
    }

    @Value("${v3-api-key}")
    private String apikey;
    @Test
    public void hahah(){
        System.out.println(apikey+"dlqslek");
    }

}
