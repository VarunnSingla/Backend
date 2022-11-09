package com.javainuse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public RequestTable saveUser(BookTable bookTable, String requestpayload, String schemaname) {
		RequestTable newuser = new RequestTable();
//		newuser.setRequestPayload(bookTable.getRequestPayload());
		newuser.setName(null);
		newuser.setStatus(null);
		newuser.setRequestPayload(requestpayload);
		newuser.setRequest_Date_Time(null);
		newuser.setDivocCertificateId(null);
		newuser.setIs_Revoked(null);
		newuser.setIs_Suspended(null);
		newuser.setSuspended_Till(null);
		newuser.setRevoked_On(null);
		newuser.setSuspended_On(null);
		newuser.setTransactionId(bookTable.getTransactionId());
		newuser.setSchemaname(schemaname);
		user1Dao.save(newuser);
		return newuser;
	}
	
	public List<RequestTable> fetchBySchemaname(String schemaname) {
		System.out.println(schemaname);
		List<RequestTable> requestTable = user1Dao.findBySchemaname(schemaname);
		System.out.println(requestTable);
		return requestTable;
				}
	
	public RequestTable saveCertificateId(String CertId , String transact) {
		System.out.println(CertId);
		System.out.println(transact);
		RequestTable requestTable = user1Dao.findByTransactionId(transact);
		System.out.println(requestTable);
        if(requestTable != null) {
            requestTable.setDivocCertificateId(CertId); 
            requestTable.setStatus("SUCCESSFULL");
        }
  
        return user1Dao.save(requestTable);
    }

//    public Optional<RequestTable> getbyTransactionId(String transact){
//        RequestTable requestTable = user1Dao.findByTransactionId(transact);
//        return Optional.ofNullable(requestTable);
//    }
		
	
	public String fetchCertificateStatus(String transactionId) {
		System.out.println(transactionId);
        String a = null;
        String b = null;
		RequestTable requestTable = user1Dao.findByTransactionId(transactionId);
		System.out.println(requestTable);
        if(requestTable != null) {
        	a = requestTable.getStatus();
        	b= requestTable.getTransactionId();
        }
        System.out.println(a);
        System.out.println(b);
        return a;
	}
	
	public String fetchCertificateid(String CertId) {
		System.out.println(CertId);
        String a = null;
		RequestTable requestTable = user1Dao.findByDivocCertificateId(CertId);
		System.out.println(requestTable);
        if(requestTable != null) {
        	if(requestTable.getStatus() =="SUCCESSFULL")
        	a = requestTable.getDivocCertificateId();
        }
        System.out.println(a);
        return a;
	}
	
	
	
	
}
        
//        public String getDivocCertificateId(String transact) {
//    		String b = null;
//    		System.out.println(transact);
//    		RequestTable requestTable = user1Dao.findByTransactionId(transact);
//    		System.out.println(requestTable);
//            if(requestTable != null) {
//               b =  requestTable.getDivoc_Certificate_Id();
//            }
//            return b;
//            
//        }