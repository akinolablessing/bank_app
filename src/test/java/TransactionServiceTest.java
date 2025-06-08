import org.ayomide.Main;
import org.ayomide.data.model.AccountType;
import org.ayomide.data.model.Status;
import org.ayomide.data.model.Transaction;
import org.ayomide.data.model.TransactionType;
import org.ayomide.data.repositories.TransactionRepo;
import org.ayomide.dto.request.TransactionRequest;
import org.ayomide.dto.response.TransactionResponse;
import org.ayomide.services.TransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.ayomide.validation.Validation.transactionTypeForWithdrawValidation;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;



    @Test
    public void testThatDepositMoney(){
        TransactionRequest request = depositRequest();
        TransactionResponse response = transactionService.deposit(request);
        assertEquals(Status.SUCCESS,response.getStatus());
        assertEquals(200,response.getAmount());
        assertEquals(TransactionType.DEPOSIT,response.getTransactionType());
        assertEquals(200,response.getUpdatedBalance());
        assertEquals("Deposit successful",response.getMessage());

    }
    public TransactionRequest depositRequest(){
        TransactionRequest transaction = new TransactionRequest();
        transaction.setAccountNumber("8336429725");
        transaction.setAmount(200);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAccountType(AccountType.SAVINGS);
        transaction.setDescription("cake");
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }
    @Test
    public void testThatWithdrawMoney(){
        TransactionRequest request = withdrawMoney();
        TransactionResponse response = transactionService.withdraw(request);
        assertEquals(Status.SUCCESS,response.getStatus());
        assertEquals(50,response.getAmount());
        assertEquals(TransactionType.WITHDRAWAL,response.getTransactionType());
        assertEquals(150,response.getUpdatedBalance());
        assertEquals("Withdrawal successful",response.getMessage());
    }
    public TransactionRequest withdrawMoney(){
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber("8336429725");
        request.setAmount(200);
        request.setTransactionType(TransactionType.WITHDRAWAL);
        request.setAccountType(AccountType.SAVINGS);
        request.setDescription("for yam and egg");
        request.setTransactionDate(LocalDateTime.now());
        return request;
    }
}
