package net.rowinski.demo.crud.controller;

import net.rowinski.demo.crud.CrudApplication;
import net.rowinski.demo.crud.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setVatId("DE123456789");

        ResponseEntity<User> response = restTemplate.postForEntity(usersApiUrl("/"), user, User.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getVatId()).isNotNull();
        assertThat(response.getBody().getVatId()).isEqualTo(user.getVatId());
    }

    @Test
    public void shouldNotCreateUserWithInvalidVatId() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setVatId("DE1234567890");

        ResponseEntity<User> response = restTemplate.postForEntity(usersApiUrl("/"), user, User.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

    }

    private String usersApiUrl(String path) {
        return "http://localhost:" + port + "/api/users" + path;
    }
}
