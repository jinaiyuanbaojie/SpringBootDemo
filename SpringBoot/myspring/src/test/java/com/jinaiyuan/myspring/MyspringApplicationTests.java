package com.jinaiyuan.myspring;

		import com.jinaiyuan.web.controller.HelloSprintBootController;
		import com.jinaiyuan.web.component.Person;
		import org.junit.Assert;
		import org.junit.Before;
		import org.junit.Test;
		import org.junit.runner.RunWith;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.http.MediaType;
		import org.springframework.test.context.junit4.SpringRunner;
		import org.springframework.test.web.servlet.MockMvc;
		import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
		import org.springframework.test.web.servlet.setup.MockMvcBuilders;

		import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
		import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
		import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringApplicationTests {

	private MockMvc mvc;
	@Autowired
	private Person person;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloSprintBootController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello spring boot")));
	}

	@Test
	public void personTest() throws Exception {
		Assert.assertEquals(person.getName(), "Andrew.Jin");
		Assert.assertEquals(person.getAge(), 300000);
	}

}
