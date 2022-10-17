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
import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

	@PostMapping("/certify")
	public String getCertificate(@RequestBody Book book) {
		return ruleUtil.getCertify(book);
	}


}



