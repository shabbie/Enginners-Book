package com.gtu.EngBook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@EnableJpaRepositories
@RunWith(SpringRunner.class)
public class EngBookApplicationTests {

/*
@Autowired UserModel userModel;
	@MockBean private UserService userService;
	private CheckInputService checkInputService=new CheckInputService();

	@Before
	public void setup()
	{

	}
*/
	@Test
	public void textInputTest() {



		//mresponse=checkInputService.inputText(text);
		//return mresponse;

	}
	/*@Test
	public Map<String,Object> dobInputTest() {
	*/


	/*@After
	public void onTearDown()
	{

	}
*/
}
