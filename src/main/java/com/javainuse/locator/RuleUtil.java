package com.javainuse.locator;

import java.io.IOException;

import java.util.List;
import java.util.Objects;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.websocket.pojo.PojoEndpointBase;
import org.springframework.beans.factory.annotation.Autowired;
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
	
   private BookTable bookTable = new BookTable();
	
	@Autowired 
	private ObjectMapper objectMapper;

	public String getCertify( Book book)  {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJxMmRGQXVDYWV3V0xpcUtYcHZ4dmxzczFvaWw0VkZJLWNfNlFmVXlKa1VJIn0.eyJleHAiOjE2OTYzOTI3ODAsImlhdCI6MTY2NDg1Njc4MCwianRpIjoiZDQyM2ZjOTYtODkyMC00MTNlLTllNTctNTAzMWM2ODYyMTEwIiwiaXNzIjoiaHR0cDovLzUyLjE3Mi4xMzIuMTIxL2F1dGgvcmVhbG1zL3N1bmJpcmQtcmMiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiODZmOWRkYjUtMGE5MS00NzUxLTg5MGMtOGFkNTkwOTQ2MGZhIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoicmVnaXN0cnktZnJvbnRlbmQiLCJzZXNzaW9uX3N0YXRlIjoiZWE5Mzg5MmYtMDQ5My00MzgzLWFlODYtNDEyZTI4N2ZlMzFjIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2xvY2FsaG9zdDo0MjAyIiwiaHR0cDovL2xvY2FsaG9zdDo0MjAyIiwiaHR0cHM6Ly9sb2NhbGhvc3Q6NDIwMCIsImh0dHBzOi8vbmRlYXIueGl2LmluIiwiaHR0cDovL2xvY2FsaG9zdDo0MjAwIiwiaHR0cDovL25kZWFyLnhpdi5pbiIsImh0dHBzOi8vc3VuYmlyZC1jZXJ0aWZpY2F0ZS1kZW1vLnhpdi5pbiIsImh0dHA6Ly8yMC4xOTguNjQuMTI4Il0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW5kZWFyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwic2lkIjoiZWE5Mzg5MmYtMDQ5My00MzgzLWFlODYtNDEyZTI4N2ZlMzFjIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ2aXNod2ExIiwiZW50aXR5IjpbIlRlbmFudCJdLCJlbWFpbCI6InZpc2h3YTEifQ.lgmRuQsuEN1By44RRMpy1rMgzftI4-19S-Jflr4Ewy-4luNavXdL2T6nhdQqokN5ndlIKeRXcdpul1mxip-jLHLaFoW3DdW2FUqjpwfPWsNglWKMN5MxVCMXJTg2w-_zM1P314XvG9W-J1Qa9Q7rhb2LKZDukNUQap8UfT2yjmZy3A-qytXxlXZBrVU2RTvnIDeTAfqlO1Hbtkya68um1hz7_mG7-RN2IhG3uM0zpJtHVLIIE_RTUEB4rwUIv-9LVnDxpJY10st4lCRzEfe0w93QQZ5RyqnfbEmCGlJ30ve0yfRbswQ4GfpalAvai6uKdCw6Rqaz9cIF8S4fbOIqiA");
		System.out.println("payload" + book.toString());
		HttpEntity<Book> entity = new HttpEntity<>(book, headers);
		
		ResponseEntity<BookTable> response =
		    restTemplate.exchange("http://52.172.132.121/vc-certification/v1/certify/NHAUIPCertificateSample",
		                          HttpMethod.POST,entity,BookTable.class);
		System.out.println(response);
		jwtUserDetailsService.saveUser(book);

		String transact = null;
		try {
			transact = objectMapper.writeValueAsString(response.getBody().getTransactionId());
			System.out.println(transact);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jwtUserDetailsService.saveUser(bookTable);


//		String body1 = response.toString().substring(11, 61);
//		System.out.println(body1);
		
		return transact;
	
		
//		ResponseEntity<String> responseEntity = makeExternalServiceCall("bb-caller", selfName, apiUrl, baseUrl,true, requestEntity, HttpMethod.POST);
//        JSONObject responseJson = new JSONObject(responseEntity.getBody());
//        TypeReference<GetMaskedNumberResponse> typeReference = new TypeReference<GetMaskedNumberResponse>() {};
//        return objectMapper.readValue(responseJson.toString(), typeReference);
		

	}
}
