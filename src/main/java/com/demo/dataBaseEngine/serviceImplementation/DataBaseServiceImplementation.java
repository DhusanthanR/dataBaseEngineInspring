package com.demo.dataBaseEngine.serviceImplementation;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dataBaseEngine.operations.InsertOperation;
import com.demo.dataBaseEngine.operations.SelectOperation;
import com.demo.dataBaseEngine.service.DataBaseService;

@Service
public class DataBaseServiceImplementation implements DataBaseService {
    
    @Autowired
    private SelectOperation selectOperation;
    
    @Autowired
    private InsertOperation insertOperation;
    
    @Override
    public List<Map<String, Object>> selectQueryForListOfMap(String query) {
        return selectOperation.selectQueryForListOfMap(query);
    }
    
    @Override
    public <T> List<T> selectQueryForListOfObject(String query, Class<T> type) {
        return selectOperation.selectQueryForListOfObject(query, type);
    }

    @Override
    public <T> void singleInsert(T object, String query, BiConsumer<PreparedStatement, T> setter){
        insertOperation.singleInsert(query, object, setter);
    }
    
    @Override
    public <T> void bulkInsert(List<T> object, String query, BiConsumer<PreparedStatement, T> setter){
        insertOperation.bulkInsert(query, object, setter);
    }
}
