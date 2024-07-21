package com.ApiExercises.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetAnalysis {

	private Map<String, Integer> nameCount;
	
	public PetAnalysis(List<Map<String, Object>> soldPets) {
		
		this.nameCount = countPetNames(soldPets);
		
	}
	
    private Map<String, Integer> countPetNames(List<Map<String, Object>> pets) {
    	
        Map<String, Integer> nameCount = new HashMap<>();
        for (Map<String, Object> pet : pets) {
            String name = (String) pet.get("name");
            System.out.println(name);
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        
        return nameCount;
        
    }
    
    public String formatNameCount() {
    
    	return nameCount.entrySet().stream()
            .map(entry -> "\"" + entry.getKey() + "\":" + entry.getValue())
            .collect(Collectors.joining(", ", "{", "}"));
    
    }
    
}
