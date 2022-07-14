package eth.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpService {

    private static final  String LOCAL="http://127.0.0.1:8545";

    public <T> T callEthFunction(String JSONInput,Class<T> classes){
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> param = new HttpEntity<String>(JSONInput,headers);

        RestTemplate restTemplate = new RestTemplate();
        return (T) restTemplate.postForObject(LOCAL,param,classes);
    }
}
