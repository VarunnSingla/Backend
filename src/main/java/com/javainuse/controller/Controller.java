package com.javainuse.controller;

//import org.websparrow.dto.Post;


	import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
	import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javainuse.dao.User1Dao;
import com.javainuse.locator.RuleUtil;
//import com.websparrow.locator.RuleUtil;
import com.javainuse.model.Book;
import com.javainuse.model.BookTable;
import com.javainuse.model.DAOUser;
import com.javainuse.model.RequestTable;
import com.javainuse.service.JwtUserDetailsService;

import ch.qos.logback.core.net.SyslogOutputStream;


@RestController
public class Controller {
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private RuleUtil ruleUtil;
	
	@Autowired
	private User1Dao user1Dao;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/certify/{Schemaname}")
	public String getCertificate(@RequestBody Book book ,@PathVariable String Schemaname) {
		return ruleUtil.getCertify(book,Schemaname);
	}
	
	@GetMapping("/listCertificate/{Schemaname_1}")
	public ResponseEntity<List<RequestTable>> getListCertificate(@PathVariable String Schemaname_1) {
		System.out.print(Schemaname_1);
		List<RequestTable> requestTable = userDetailsService.fetchBySchemaname(Schemaname_1);
	    return new ResponseEntity<List<RequestTable>>(requestTable,HttpStatus.OK);
	}
	
	
	
	
//	@RequestMapping("/listCertificate/{SchemaName}")
//	public List<RequestTable> getListCertificate(@PathVariable int SchemaName) {
//		return userDetailsService.getListCertificate(SchemaName);
//	}


}



