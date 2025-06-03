import lombok.AllArgsConstructor;
import org.ayomide.Main;
import org.ayomide.data.model.Customer;
import org.ayomide.dto.request.AccountRequest;
import org.ayomide.dto.response.AccountResponse;
import org.ayomide.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)

public class AccountServiceTest {
    @Autowired
    private  AccountService accountService;

    @Test
    public void createBankAccountTest(){
        AccountRequest request =  createAccount();
        AccountResponse response = accountService.createBankAccount(request);
//        assertEquals("ACCT-",response.getAccountNumber());
        assertEquals("Onyii",response.getUserName());
        assertEquals(0.0,response.getBalance());
        assertEquals("Bank Account Created Successful",response.getMessage());

    }
    public AccountRequest createAccount(){
        AccountRequest request = new AccountRequest();
       request.setUserName("Onyii");
       request.setCreatedAt(LocalDateTime.now());
       request.setBalance(0.0);
//        request.setAccountNumber("ACCT-");
        return request;
    }
}
