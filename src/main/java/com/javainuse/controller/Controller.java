package com.javainuse.controller;

//import org.websparrow.dto.Post;


	import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.dao.User1Dao;
import com.javainuse.locator.RuleUtil;
//import com.websparrow.locator.RuleUtil;
import com.javainuse.model.Book;
import com.javainuse.model.BookTable;
import com.javainuse.model.DAOUser;
import com.javainuse.model.HealthprofDTO;
import com.javainuse.model.RequestTable;
import com.javainuse.model.RevokeDTO;
import com.javainuse.model.TransactionDTO;
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
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${jwt.DivocToken}")
	private String divocToken;
	
	public TransactionDTO transactionDTO;
	
	@Autowired 
	private ObjectMapper objectMapper;

	
	@PostMapping("/certify/{Schemaname}")
	public ResponseEntity<BookTable> getCertificate(@RequestBody Book book ,@PathVariable String Schemaname) {
		return ruleUtil.getCertify(book,Schemaname);
	}
	
	//all details will be shown by schemaname
	@GetMapping("/listCertificate/{Schemaname_1}")
	public ResponseEntity<List<RequestTable>> getListCertificate(@PathVariable String Schemaname_1) {
		System.out.print(Schemaname_1);
		List<RequestTable> requestTable = userDetailsService.fetchBySchemaname(Schemaname_1);
	    return new ResponseEntity<List<RequestTable>>(requestTable,HttpStatus.OK);
	}
	
	// generate CertId from transactId 
	@GetMapping("/download/{transactionId}")
	public ResponseEntity<TransactionDTO> getconsumeAPI(@PathVariable String transactionId) {
		
		String DbStatus =  userDetailsService.fetchCertificateStatus(transactionId);
		System.out.println(DbStatus);
		if(DbStatus != "SUCCESSFULL") {
			return ruleUtil.getDownload(transactionId);
		}
		else
			System.out.println("CertifiacteId Alraedy generated");
		return null;
			
	}
	
	//download certificate by direct certid
	@GetMapping("/downloadCertificate/certificateId/{divocCertificateid}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String divocCertificateid) {
		String  CertId = userDetailsService.fetchCertificateid(divocCertificateid);
		String  dbSchemaname = userDetailsService.fetchSchemaname(divocCertificateid);
		System.out.println(CertId);
		System.out.println(dbSchemaname);

		if(CertId.equalsIgnoreCase(divocCertificateid)) {
			return ruleUtil.generateDivocCertificate(dbSchemaname,divocCertificateid);
		}
//		return divocCertificateId;
		return null;
		
	}
		
	
	// downloadCertifiate/certificateid/{CertId}
	// check in databse if certid exists nad status successfull
	// if yes -> download certificate and send the response
	
	//certificate download
	@GetMapping("/downloadCertificate/{schemaname}/{CertId}")
	public ResponseEntity<byte[]> getCertificateHeadCall(@PathVariable String schemaname,@PathVariable String CertId) {
		return ruleUtil.generateDivocCertificate(schemaname,CertId);
	}
	
	//update the details
	@PutMapping("/updatecertify/{Schemaname}")
	public ResponseEntity<BookTable> updateCertificate(@RequestBody HealthprofDTO healthprofDTO ,@PathVariable String Schemaname) {
		return ruleUtil.getCertificateupdate(healthprofDTO,Schemaname);
	}
	
	@PostMapping("/revoke")
	public ResponseEntity<Object> getRevokedService(@RequestBody RevokeDTO revokeDTO) {
		return ruleUtil.getRevokeDone(revokeDTO);
	}
			
		
}