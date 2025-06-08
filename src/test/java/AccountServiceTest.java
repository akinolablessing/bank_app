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
        assertEquals("Femi",response.getUserName());
        assertEquals(0.0,response.getBalance());
        assertEquals("Bank Account Created Successful",response.getMessage());

    }
    public AccountRequest createAccount(){
        AccountRequest request = new AccountRequest();
       request.setUserName("Femi");
       request.setCreatedAt(LocalDateTime.now());
       request.setBalance(0.0);
        return request;
    }
    @Test
    public void getAccountByNumberTest(){
        AccountRequest request = accountRequest();
        AccountResponse response = accountService.getAccountByNumber(request);
        assertEquals("8336429725",response.getAccountNumber());
        assertEquals("Ayomide",response.getUserName());
        assertEquals(6400,response.getBalance());
        assertEquals("Account retrieved successfully",response.getMessage());
    }
    public AccountRequest accountRequest(){
        AccountRequest request = new AccountRequest();
        request.setAccountNumber("8336429725");
        return request;
    }
}
