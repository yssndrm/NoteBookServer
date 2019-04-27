package com.oracle.notebookServer.model;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;

@Component
public final class SharedPythonInterpreter {
    
	public static final PythonInterpreter interpreter = new PythonInterpreter();
   
	
	
     
}
