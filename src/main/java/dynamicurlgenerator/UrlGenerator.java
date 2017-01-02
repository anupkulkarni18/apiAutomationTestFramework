package dynamicurlgenerator;

import utils.HeadersProvider;
import utils.PropertyReader;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UrlGenerator {
	
	public static String baseUrl = PropertyReader.getProperties("baseUrl");
	public static HttpResponse<JsonNode> response;
	
	public synchronized static HttpResponse<JsonNode> makeRequest(Request REQUEST, String subString, HeadersProvider header,String param) throws UnirestException{
		
		switch(REQUEST){
		case GET:
			response = Unirest.get(baseUrl+subString).headers(header.getHeaders()).asJson();
			
			break;
		case POST:
			System.out.println("post");
			System.out.println(">>>"+baseUrl+subString);
			response = Unirest.post(baseUrl+subString).headers(header.getHeaders()).body(param).asJson();
			break;
		case PUT:
			response = Unirest.put(baseUrl+subString).headers(header.getHeaders()).body(param).asJson();
			break;
		case DELETE:
			response = Unirest.delete(baseUrl+subString).headers(header.getHeaders()).asJson();
		}
		return response;
		
	}
	
	
	public enum Request{ GET,POST,PUT,DELETE }
	
	
	
}
