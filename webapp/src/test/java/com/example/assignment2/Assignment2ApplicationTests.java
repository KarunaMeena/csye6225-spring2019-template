package com.example.assignment2;

import com.example.assignment2.BO.User;
import com.example.assignment2.controller.UserController;
import com.example.assignment2.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class Assignment2ApplicationTests {


	private MockMvc mvc;

	@Autowired
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");


		mvc = MockMvcBuilders.standaloneSetup(new UserController()).setViewResolvers(viewResolver).build();

	}

	@Test
	public void testUserController() throws Exception {
		RequestBuilder request = null;

		request = get("/user/signin");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk());

		request = get("/user/signup");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk());

		/*request = post("/user/signupvalidate")
				.param("id", "131231")
				.param("username", "98765@gmail.com")
				.param("password", "12345678");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk());

		request = post("/user/signinvalidate")
				.param("username", "98765@gmail.com")
				.param("password", "12345678");
		mvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk());
*/


	}
	@Test
	public void contextLoads() {
	}

}
