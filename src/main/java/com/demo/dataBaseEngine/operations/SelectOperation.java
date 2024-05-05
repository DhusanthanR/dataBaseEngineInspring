package com.demo.dataBaseEngine.operations;

import java.util.List;
import java.util.Map;

public interface SelectOperation {
    List<Map<String, Object>> selectQueryForListOfMap(String query);
    <T> List<T> selectQueryForListOfObject(String query, Class<T> type);
}
