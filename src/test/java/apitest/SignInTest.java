package apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.PropertyReader;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dynamicurlgenerator.SignInHelper;



public class SignInTest {
	
		@Test(priority=1)
		public void testValidLogin() throws UnirestException
		{
			SignInHelper signInHelper =new SignInHelper();
			Assert.assertTrue(signInHelper.SignIn("/users/sign_in.json", " {\"user\" : {\"email\" : \"anup.kulkarni@forgeahead.io\", \"password\" : \"password\"}}"),"Failed to Login");
			
		}
		
		@Test(priority=2)
		public void loginFailed() throws Exception{
			SignInHelper signInHelper =new SignInHelper();
			Assert.assertTrue(signInHelper.SignInInvalid("/users/sign_in.json", " {\"user\" : {\"email\" : \"anup.kulkarnasi@forgeahead.io\", \"password\" : \"password\"}}"),"Should not login with wrong credentials");
	    }
		
		@Test(priority=3)
		public void unSufficientData() throws Exception{
			SignInHelper signInHelper =new SignInHelper();
			Assert.assertTrue(signInHelper.SignInInvalid("/users/sign_in.json", " {\"user\" : {\"email\" : \"\", \"password\" : \"\"}"),"Should not login with wrong credentials");
	        
	    }

	
}
