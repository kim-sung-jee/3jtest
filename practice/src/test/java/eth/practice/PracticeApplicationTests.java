package eth.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class PracticeApplicationTests {
	@Value("${v3-api-key}")
	private String key;
	private final String infura_url = "https://mainnet.infura.io/v3/"+key;

	@Autowired
	private Web3j web3j;

	@Test
	void contextLoads() {
	}
	@Test
	public void ConnectEth() throws ExecutionException, InterruptedException, IOException {
		Web3j web3j = Web3j.build(new org.web3j.protocol.http.HttpService(infura_url));
		Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
		System.out.println(web3ClientVersion.getWeb3ClientVersion());

//		Web3j web3=Web3j.build(new org.web3j.protocol.http.HttpService(infura_url));
//		Web3ClientVersion web3ClientVersion=web3.web3ClientVersion().sendAsync().get();
//		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//		System.out.println(clientVersion);
	}
	@Test
	public void helloworld(){
		Web3j web3j = Web3j.build(new org.web3j.protocol.http.HttpService(infura_url));

	}
}
