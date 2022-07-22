package eternal.flame;

import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EtherumController {
    private static final Logger logger = LoggerFactory.getLogger(EtherumController.class);

    @Value("${rinkebyurl}")
    private String rinkebyUrl;





//    @Activity
//    @ApiOperation(value = "Api for fetching accounts in keystore", response = ResponseEntity.class)
    @GetMapping(value="geth/accounts")
    public void accounts() throws IOException {
        Web3j web3j=Web3j.build(new HttpService(rinkebyUrl));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion()+"dlqslek!!");
        System.out.println(rinkebyUrl);
//        logger.debug("Trying to fetch accounts from your geth client");
//        Web3ClientVersion web3ClientVersion;
//        String clientVersion ="Verson not Found";
//        Map<String,Object> accounts=null;
//        try {
//            web3ClientVersion = web3j.web3ClientVersion().send();
//            clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            logger.debug("client version"+clientVersion);
//            logger.debug("Trying to fetch Accounts");
//            accounts=new HashMap<String,Object>();
//            accounts.put("clientVersion", clientVersion);
//            java.util.List<String> accountAddress=web3j.ethAccounts().send().getAccounts();
//            accounts.put("accouts", accountAddress);
//
//        } catch (IOException e) {
//            logger.debug("Exception with web3j",e);
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}