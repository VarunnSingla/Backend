package com.javainuse.service;

import java.util.ArrayList;

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
	
	
	


	public RequestTable saveUser(Book book) {
		RequestTable newuser = new RequestTable();
		newuser.setName(book.getName());
		newuser.setDob(book.getDob());
		newuser.setRegistrationId(book.getRegistrationId());
		newuser.setGender(book.getGender());
		newuser.setRegistrationCouncil(book.getRegistrationCouncil());
		newuser.setLatestQualification(book.getLatestQualification());
		newuser.setUniversity(book.getUniversity());
		newuser.setDegreeYear(book.getDegreeYear());
		newuser.setSystemOfMedicine(book.getSystemOfMedicine());
		newuser.setRegistrationDate(book.getRegistrationDate());
		newuser.setIssuer(book.getIssuer());
		newuser.setIssuanceDate(book.getIssuanceDate());
//		newuser.setTransactionId(bookTable.getTransactionId());
		user1Dao.save(newuser);
		return newuser;
	}
	
	public RequestTable saveUser(BookTable bookTable) {
		RequestTable newuser = new RequestTable();
		newuser.setTransactionId(bookTable.getTransactionId());
		user1Dao.save(newuser);
		return newuser;
	}
	
//	public DAOUser save(BookTable bookTable) {
//		DAOUser newUser = new DAOUser();
//		
//		System.out.println(bookTable.getTransactionId());
//		newUser.setTransactionId(bookTable.getTransactionId());
//		System.out.println(newUser);
//		return userDao.save(newUser);
//	}
	
}
	
