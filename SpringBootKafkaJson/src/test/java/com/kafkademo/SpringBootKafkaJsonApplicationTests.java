package com.kafkademo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kafkademo.domain.User;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class SpringBootKafkaJsonApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllRequisitionsTest() throws Exception {
		
		User user = new User();
		
		user.setId(new Long(3));
		user.setName("Ramjeevan Tadi");
		user.setRole("Software Engineer");
		user.setSalary(new Long(45000));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user );
		
		MockHttpServletRequestBuilder request = post("/kafka/api/v1/user").contentType(MediaType.APPLICATION_JSON).content(requestJson);
		
		mockMvc.perform(request)
			  	.andExpect(status().isOk());
		
	}

}
