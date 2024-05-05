package com.demo.dataBaseEngine.operations;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.function.BiConsumer;

public interface InsertOperation {
    <T> void singleInsert(String query, T object, BiConsumer<PreparedStatement, T> setter);
    <T> void bulkInsert(String query, List<T> objects, BiConsumer<PreparedStatement, T> setter);
}
