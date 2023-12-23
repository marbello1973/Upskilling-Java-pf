package ApiRestfull.AdminGastos;

import ApiRestfull.AdminGastos.dto.request.GastosRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GastosControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void metodoPost() {

        GastosRequestDto requestDto = new GastosRequestDto();
        requestDto.setAmount(100.0);
        requestDto.setCategory("category");
        requestDto.setDate("2002/12/12");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/gastos",
                requestDto,
                String.class

        );

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Register ok",responseEntity.getBody());



    }
}
