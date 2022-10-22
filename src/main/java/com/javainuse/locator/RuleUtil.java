package com.javainuse.locator;

import java.io.IOException;

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
import com.javainuse.model.Book;
import com.javainuse.model.BookTable;

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

	public String getCertify(Book book , String SchemaName) {
		String a = baseUrl+SchemaName;
		System.out.println(a);
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
				baseUrl, 
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

		jwtUserDetailsService.saveUser(bookTable,requestPayload,SchemaName);

		return transact;
	}
}
