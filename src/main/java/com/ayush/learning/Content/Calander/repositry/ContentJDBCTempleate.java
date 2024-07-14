package com.ayush.learning.Content.Calander.repositry;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentJDBCTempleate {

    private final JdbcTemplate jdbcTemplate;

    public ContentJDBCTempleate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
