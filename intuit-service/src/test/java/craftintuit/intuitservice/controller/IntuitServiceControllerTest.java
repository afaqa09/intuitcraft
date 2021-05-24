package craftintuit.intuitservice.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import craftintuit.intuitservice.service.IBusinessProfileService;

public class IntuitServiceControllerTest {

	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private IBusinessProfileService businessprofService;
	
	@Test
	public void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBP() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBP() {
		fail("Not yet implemented");
	}

}
