
	package com.javainuse.dao;

	import java.util.List;

import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	import com.javainuse.model.DAOUser;
	import com.javainuse.model.RequestTable;


	@Repository
	public interface User1Dao extends CrudRepository<RequestTable, Integer> {

//		RequestTable findbySchemaName(String SchemaName);

	}
	
