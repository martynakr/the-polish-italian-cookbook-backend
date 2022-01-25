package com.example.thepolitcookbook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ThePolItCookbookApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void getsAllRecipes() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recipes").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getsSingleRecipe() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recipes/10").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void returnsRecipeDoesNotExist() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recipes/123").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound()).andReturn();
	}

//	@Test
//	public void addsNewRecipe() throws Exception {
//		String newRecipe = "{\"name\": \"Tomato salad\", \"description\": \"Chop the tomatoes, mix them with salt and olive oil...\", \"countryId\": 2,  \"recipeCreatorId\": 2}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/").contentType(MediaType.APPLICATION_JSON).content(newRecipe).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn(); }

//	@Test
//	public void deletesRecipe() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/recipes")).andExpect(status().isOk()).andReturn();
//	}

}
