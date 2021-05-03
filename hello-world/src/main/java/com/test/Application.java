package com.test;

import com.test.service.ItemService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan// ("com.test")
@Configuration
//@Slf4j
public class Application {

    // nebo jeste lepe pres @Slf4j
//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    // Uvnitr @Value je: SpEL (Spring Expression Language)
    public HikariDataSource dataSource(@Value("${java.version}") String javaVersion, @Value("#{1 + 1}") int dva) {
        System.out.println("java version = " + javaVersion);
        System.out.println("dva? 1 + 1 = " + dva);
//        log.info("DataSource constructed");
        System.out.println("DataSource constructed");
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:hsqldb:hsql://localhost/eshop");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    // NEBO prime volani metody:
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Application.class);

        ItemService itemService = applicationContext.getBean(ItemService.class);

        System.out.println(itemService.getHello());

        applicationContext.close();
    }

}
