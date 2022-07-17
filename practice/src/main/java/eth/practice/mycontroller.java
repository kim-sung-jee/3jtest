package eth.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Controller
public class mycontroller {

    @Value("${v3-api-key}")
    private String key;
    private final String infura_url = "https://mainnet.infura.io/v3/"+key;

    @GetMapping("/hello")
    public void aa() throws IOException {
        Web3j web3j=Web3j.build(new HttpService(infura_url));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());
    }
}
