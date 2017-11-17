package com.netgear.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netgear.service.interfac.SaveInDbService;

@Repository
public class SaveToDbDaoImpl implements SaveInDbService{

	private static final String TABLE_NAME = "user";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	public void insertInDb(String userName,String password){
		System.out.println("Inside Dao");
		String query = "INSERT INTO "+TABLE_NAME+" (username,password) VALUES (:userName,:password)";
		final MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("userName", userName);
		parameters.addValue("password", password);
		int update = jdbcTemplate.update(query, parameters);
		if(update==1){
			System.out.println("Successful");
		}
		else{
			System.out.println("UnSuccessful");
		}
	}
}
