package com.netgear.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netgear.dao.impl.SaveToDbDaoImpl;
import com.netgear.service.interfac.SaveInDbService;

@Service
public class SaveInDbServiceImpl implements SaveInDbService{
	@Autowired
	private SaveToDbDaoImpl toDbDao;
	public void saveInDb(String userName,String password){
		System.out.println("Inside Service");
		toDbDao.insertInDb(userName, password);
	}
}
