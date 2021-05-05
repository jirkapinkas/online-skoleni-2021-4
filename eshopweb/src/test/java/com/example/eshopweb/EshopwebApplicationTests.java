package com.example.eshopweb;

import com.example.eshopweb.dto.ItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EshopwebApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void contextLoads() {
        ItemDto itemDto = testRestTemplate.getForObject("/item/1", ItemDto.class);
        // https://assertj.github.io/doc/
        assertThat(itemDto)
                .isNotNull();
        assertThat(itemDto.getId())
                .isEqualTo(1);

        // https://www.testcontainers.org/
    }

}
