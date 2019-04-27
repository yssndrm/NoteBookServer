package com.oracle.notebookServer.model;


public class PythonException extends Exception {



	public PythonException(Throwable root) {
		super(root);
	}

	public PythonException(String string, Throwable root) {
		super(string, root);
	}

	public PythonException(String s) {
		super(s);
	}
}