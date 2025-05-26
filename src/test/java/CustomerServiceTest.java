import org.ayomide.Main;
import org.ayomide.dto.request.RegisterRequest;
import org.ayomide.dto.response.RegisterResponse;
import org.ayomide.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Main.class)
public class CustomerServiceTest {

    private final CustomerService customerService;

    @Autowired
    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testThatRegisterUser(){
    RegisterRequest request = registerUser();
        RegisterResponse response = customerService.createUserAccount(request);
        assertEquals("Register successfully!!",response.getMessage());

    }
    public RegisterRequest registerUser(){
    RegisterRequest request = new RegisterRequest();
    request.setFirstName("Ayomide");
    request.setLastName("Blessing");
    request.setAddress("hbwe7ywhs");
    request.setPassword("234rff");
    request.setPhoneNumber("09155300427");
    request.setUserGmail("fccsygt@gmail.com");
    return request;
    }
}
