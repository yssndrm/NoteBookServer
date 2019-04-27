package com.oracle.notebookServer.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public final class SharedScriptEngine {
	public static final ScriptEngine pyEngine = new ScriptEngineManager().getEngineByName("python");}
