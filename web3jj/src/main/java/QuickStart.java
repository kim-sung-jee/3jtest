import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import utils.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickStart {
    private static Web3j web3j;

    public static void main(String[] args) {
        web3j = Web3j.build(new HttpService(Environment.RPC_URL));

        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println("clientVersion " + clientVersion);
            List<String> ethAccounts =web3j.ethAccounts().send().getAccounts();
            for(String ethAccount : ethAccounts){
                System.out.println(ethAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
