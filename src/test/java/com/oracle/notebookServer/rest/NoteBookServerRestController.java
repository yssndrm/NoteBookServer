package com.oracle.notebookServer.rest;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.notebookServer.model.Code;
import com.oracle.notebookServer.model.SharedPythonInterpreter;

@RestController
public class NoteBookServerRestController {

	@InjectMocks
	private PythonInterpreterRestController pythonInterpreterRestController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void execute() {

		HttpSession session = new MockHttpSession(null, "test-session-id");

		Code c = new Code();
		c.setCode("%python  print 1+1");
		c.setResult("");

		try { 

			Code code = pythonInterpreterRestController.execute(c, session);

			assertEquals("2\n", code.getResult());

		} catch (Exception ex) {

			System.out.println("Boom!");
		}

	}

}
