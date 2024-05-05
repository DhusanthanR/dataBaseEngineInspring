package com.demo.dataBaseEngine.service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public interface DataBaseService {
	
	public List<Map<String,Object>>selectQueryForListOfMap(String query);
	
	<T> List<T> selectQueryForListOfObject(String query, Class<T> type);
	
	public <T>void singleInsert(T object,String query, BiConsumer<PreparedStatement, T> setter);
	
	public <T>void bulkInsert(List<T> object,String query, BiConsumer<PreparedStatement, T> setter);
}
