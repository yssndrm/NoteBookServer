package com.oracle.notebookServer.model;

public class Code {
	
	private String code ;
	
//	private Map<String, String> variables;

	private String result;
	
//	private PythonInterpreter interpreter = SharedPythonInterpreter.interpreter;
	
	public Code() {
		
		
	}
	
	public Code(String code, String result) {
		super();
		this.code = code;
		this.result = result;
	}
	
	

//	public Code(String code, Map<String, String> variables, String result) {
//		super();
//		this.code = code;
//		this.variables = variables;
//		this.result = result;
//	}

	

	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	} 

	public void setCode(String code) {
		this.code = code;
	}

//	public Map<String, String> getVariables() {
//		return variables;
//	}
//
//	public void setVariables(Map<String, String> variables) {
//		this.variables = variables;
//	}
	
	
	
	

}
