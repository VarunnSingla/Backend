package com.javainuse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javainuse.dao.User1Dao;
import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;
import com.javainuse.model.Book;
import com.javainuse.model.BookTable;
import com.javainuse.model.RequestTable;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private User1Dao user1Dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setDob(user.getDob());
		return userDao.save(newUser);
	}

	public RequestTable saveUser(BookTable bookTable, String requestpayload, String SchemaName) {
		RequestTable newuser = new RequestTable();
//		newuser.setRequestPayload(bookTable.getRequestPayload());
		newuser.setName(null);
		newuser.setStatus(null);
		newuser.setRequestPayload(requestpayload);
		newuser.setRequest_Date_Time(null);
		newuser.setDivoc_Certificate_Id(null);
		newuser.setIs_Revoked(null);
		newuser.setIs_Suspended(null);
		newuser.setSuspended_Till(null);
		newuser.setRevoked_On(null);
		newuser.setSuspended_On(null);
		newuser.setTransactionId(bookTable.getTransactionId());
		newuser.setSchemaName(SchemaName);
		user1Dao.save(newuser);
		return newuser;
	}
	
//	@Override
//	public RequestTable fetchBySchemaName(String SchemaName) {
//		return user1Dao.fetchBySchemaName(SchemaName 
//	}

//	public List<RequestTable> getListCertify(String schemaName) {
////		RequestTable newuser = new RequestTable();
//		List<RequestTable> newuser = user1Dao.findbySchemaName(schemaName);
//		if(newuser == null) {
//			throw new UsernameNotFoundException("User not Found with Schema Name" + schemaName);
//		}
//		user1Dao.saveAll(newuser);
//		return newuser;
//
//	}
}
//	public RequestTable saveUser(BookTable bookTable) {
//		RequestTable newuser = new RequestTable();
//		newuser.setTransactionId(bookTable.getTransactionId());
//		user1Dao.save(newuser);
//		return newuser;
//	}
