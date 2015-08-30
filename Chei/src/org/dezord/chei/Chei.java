package org.dezord.chei;

import java.util.logging.Logger;

import com.esotericsoftware.yamlbeans.YamlException;

public class Chei {
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	public Chei() throws YamlException {
		PermissionManager manager = new PermissionManager();
		
	}

}
