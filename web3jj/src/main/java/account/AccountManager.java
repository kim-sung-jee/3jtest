package account;

import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.http.HttpService;
import utils.Environment;

import java.io.IOException;

public class AccountManager {
    private static Admin admin;

    public static void main(String[] args) {
        admin=Admin.build(new HttpService(Environment.RPC_URL));
        createNewAccount();
    }
    private static void createNewAccount() {
        String password = "lakweklasdik13!";
        try {
            NewAccountIdentifier newAccountIdentifier = admin.personalNewAccount(password).send();
            String address = newAccountIdentifier.getAccountId();
            System.out.println("new account address " + address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
