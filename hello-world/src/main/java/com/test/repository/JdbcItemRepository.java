package com.test.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Profile("jdbc")
@Repository
public class JdbcItemRepository implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM item", Long.class);
    }

}
