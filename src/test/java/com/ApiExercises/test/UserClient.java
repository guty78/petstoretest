package com.ApiExercises.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserClient {

	/*
	 * Create user: HTTP POST
	 * Get information from user: HTTP GET
	 * */
	
	private static final String userBaseUrl = "https://petstore.swagger.io/v2/user"; 
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	
	public UserClient() {}
	
	public UserClient(String userName,
			String firstName,
			String lastName,
			String email,
			String password,
			String phone) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public void createUser() throws IOException, InterruptedException {
		
        String jsonBody = String.format(
        		"{ \"id\": 0, \"username\": \"%s\", \"firstName\": \"%s\", \"lastName\": \"%s\", \"email\": \"%s\", \"password\": \"%s\", \"phone\": \"%s\", \"userStatus\": 0 }",
                userName, firstName, lastName, email, password, phone
            );
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(userBaseUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Create User Response: " + response.body());
        
	}
	
    public void getUser(String userName) throws IOException, InterruptedException {
        
    	HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(userBaseUrl + "/" + userName))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Get User Response: " + response.body());
        
    }
	
}
