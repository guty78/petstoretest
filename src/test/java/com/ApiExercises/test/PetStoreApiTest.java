package com.ApiExercises.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PetStoreApiTest {

	/*
	 * Create user: HTTP POST
	 * Get information from user: HTTP GET
	 * Get information from sold pets: HTTP GET
	 * List of sold pets that have the same name (using previous information)
	 * */
	
	public static void main(String[] args) {
		
        try {
        	/* Create user */
    		// UserClient userClient = new UserClient("user4", "user", "four", "user.four@4null.com", "Test_2000", "666666666");
            // userClient.createUser();
        	
        	/* Get user information */
        	// UserClient userClient = new UserClient();
            // userClient.getUser("user4");
        	
        	/* Get list of sold pets that have the same name */
            List<Map<String, Object>> soldPets = PetClient.getSoldPets();
            PetAnalysis analysis = new PetAnalysis(soldPets);
            System.out.println(analysis.formatNameCount());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
	}
	
}

