package com.oracle.notebookServer.rest;

import java.io.StringWriter;

import javax.servlet.http.HttpSession;

import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.notebookServer.model.Code;
import com.oracle.notebookServer.model.PythonException;
import com.oracle.notebookServer.model.SharedPythonInterpreter;
import com.oracle.notebookServer.model.UnknownInterpreterException;

@RestController
@RequestMapping("/api")
public class PythonInterpreterRestController {

	@Autowired
	private SharedPythonInterpreter sharedPythonInterpreter;
	private static final String FUNC_TPL = String.join("\n", new String[] { "%s", "", });

	@PostMapping("/execute")
	public Code execute(@RequestBody Code c, HttpSession session) throws PythonException {

		PythonInterpreter python = sharedPythonInterpreter.interpreter;

		try {

			session.setAttribute("sessionInterpreter", python);

			String input = c.getCode();
			if (c.getCode().matches("%python(.*)")) {

				String code = (input.substring(7)).replaceAll("\\s*$", "").replaceAll("^\\s*", "");

				String[] lines = code.split("\n");
				for (int i = 1; i < lines.length; i++)
					lines[i] = "    " + lines[i];
				code = String.join("\n", lines);
				code = String.format(FUNC_TPL, code); 

				System.out.println(code);

				StringWriter sw = new StringWriter();
				python.setOut(sw);
				python.exec(code);

				String ret = sw.toString();

				System.out.println("value is : " + ret);

				c.setResult(ret);


			} else {
				throw new UnknownInterpreterException("Uknown Interpreter");
			}

		} catch (Exception ex) {

			throw new PythonException(String.format("Failed to load python code '%s'", c.getCode()), ex);

		}

		return c;

	}

}
