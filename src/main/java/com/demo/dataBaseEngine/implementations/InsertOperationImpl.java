package com.demo.dataBaseEngine.implementations;

import com.demo.dataBaseEngine.operations.InsertOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.BiConsumer;

@Component
public class InsertOperationImpl implements InsertOperation{
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public <T> void singleInsert(String query, T object, BiConsumer<PreparedStatement, T> setter) {
	        jdbcTemplate.update(query, ps -> setter.accept(ps, object));
	    }

	    @Override
	    public <T> void bulkInsert(String query, List<T> objects, BiConsumer<PreparedStatement, T> setter) {
	        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps, int i) throws SQLException {
	                setter.accept(ps, objects.get(i));
	            }

	            @Override
	            public int getBatchSize() {
	                return objects.size();
	            }
	        });
	    }
}
