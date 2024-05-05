package com.demo.dataBaseEngine.implementations;

import com.demo.dataBaseEngine.operations.SelectOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class SelectOperationImpl implements SelectOperation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> selectQueryForListOfMap(String query) {
        return jdbcTemplate.queryForList(query);
    }

    @Override
    public <T> List<T> selectQueryForListOfObject(String query, Class<T> type) {
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(type));
    }
}