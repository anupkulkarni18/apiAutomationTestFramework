package dynamicurlgenerator;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import utils.HeadersProvider;
import utils.PropertyReader;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import dynamicurlgenerator.UrlGenerator.Request;

public class SignInHelper {
	
	public static String userToken = null;
	
	public boolean SignIn(String subString,String param) throws UnirestException
	{
		System.out.println("signin");
		HttpResponse<JsonNode> response = UrlGenerator.makeRequest(Request.POST, subString, 
																		new HeadersProvider() {
            																public Map<String, String> getHeaders() {
            																	Map<String, String> map = new HashMap<String, String>();
            																	map.put("Content-Type","application/json");
            																	return map;
            																}
        																}, param);
		if(response.getStatus() == 200){
			userToken = response.getBody().getObject().getString("authentication_token");
			return true;
		}
		return false;
		
	}
	
	
	public boolean SignInInvalid(String subString,String param) throws UnirestException
	{
		System.out.println("signin");
		HttpResponse<JsonNode> response = UrlGenerator.makeRequest(Request.POST, subString, 
																		new HeadersProvider() {
            																public Map<String, String> getHeaders() {
            																	Map<String, String> map = new HashMap<String, String>();
            																	map.put("Content-Type","application/json");
            																	return map;
            																}
        																}, param);
		int Code = response.getStatus();
        if (Code==401)
        {
            return false;

        }
        else{
            return true;

        }
	}
}
