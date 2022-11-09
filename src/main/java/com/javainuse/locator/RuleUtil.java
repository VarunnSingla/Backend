package com.javainuse.locator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.websocket.pojo.PojoEndpointBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.javainuse.service.JwtUserDetailsService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

import com.javainuse.model.Book;
import com.javainuse.model.BookTable;
import com.javainuse.model.TransactionDTO;

@Component

public class RuleUtil {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
		
	@Autowired 
	private ObjectMapper objectMapper;
	
	@Value("${jwt.BaseUrl}")
	private String baseUrl;
	
	@Value("${jwt.DivocToken}")
	private String divocToken;

	public String getCertify(Book book , String schemaname) {
		
		String CertifyUrl = baseUrl+schemaname;
		System.out.println(CertifyUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "
				+divocToken);
		System.out.println("payload" + book.toString());
		String requestPayload = null;

		try {
			requestPayload = objectMapper.writeValueAsString(book.toString());
			System.out.println(requestPayload);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpEntity<Book> entity = new HttpEntity<>(book, headers);
		System.out.println(entity);

//		if we use String instead of BookTable then we got in the form of JSON
		ResponseEntity<BookTable> response = restTemplate.exchange(
				CertifyUrl, 
				HttpMethod.POST, entity,BookTable.class);

		System.out.println(response);
//		bookTable.setRequestPayload(requestPayload);

		BookTable bookTable = response.getBody();
		System.out.println(bookTable);
		
		String transact = null ;
		try {
			transact = objectMapper.writeValueAsString(bookTable.getTransactionId());
			System.out.println(transact);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				System.out.println(response);

		jwtUserDetailsService.saveUser(bookTable,requestPayload,schemaname);

		return transact;
	}
	
	public ResponseEntity<TransactionDTO> getDownload(String transactionId) {
		String url = "http://52.172.132.121/vc-management/v1/transaction/";
		String transactionUrl = url+transactionId;
		System.out.println(transactionUrl);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+divocToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		System.out.println(divocToken);
		System.out.println(entity);
		
		ResponseEntity<TransactionDTO> result = restTemplate.exchange(
				transactionUrl, 
				HttpMethod.GET, entity,TransactionDTO.class);
	    System.out.println(result);

	    TransactionDTO transactionDTO = result.getBody();
		System.out.println(transactionDTO);
		
		String CertId = null ;
		try {
			CertId = objectMapper.writeValueAsString(transactionDTO.getCertificateId());
			System.out.println(CertId);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(CertId);

		
		String transact = transactionDTO.getTransactionId();
		System.out.println(transact);
		jwtUserDetailsService.saveCertificateId(CertId,transact);
		
//		transactionDTO.setCertificateId("SUCCESSFULL");
//		transactionDTO.setStatus("SUCCESSFULL");
		
		return result;
	
	}

	public ResponseEntity<byte[]> generateDivocCertificate(String CertId) {
		String url = "http://52.172.132.121/vc-certification/v1/certificate/NHAUIPCertificateSample/";
		String CertUrl = url+CertId;
		System.out.println(CertUrl);
	    HttpHeaders headers = new HttpHeaders();
	    // , MediaType.APPLICATION_OCTET_STREAM
	    headers.set("template-key", "html");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_PDF));
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
	    headers.set("Authorization", "Bearer "+divocToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		System.out.println(entity);
		
		ResponseEntity<byte[]> response = restTemplate.exchange(CertUrl,
				HttpMethod.GET, entity, byte[].class);
		byte[] content = response.getBody();

		System.out.println(response);
		return response;
	}
	
	
	
}
