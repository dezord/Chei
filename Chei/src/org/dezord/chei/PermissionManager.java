package org.dezord.chei;

import java.util.HashMap;
import java.util.Map;

public class PermissionManager {
	public Map<String, String> permissions = new HashMap<String, String>();
	
	/**Get whether filename should be given a read permission.*/
	public boolean canRead(String filename) {
		if (permissions.getOrDefault(filename, "").contains("r"))
			return true;
		return false;
	}
	/**Alias to canRead.*/
	public boolean cR(String filename) { return canRead(filename); }
	
	/**Get whether filename should be given a write permission.*/
	public boolean canWrite(String filename) {
		if (permissions.getOrDefault(filename, "").contains("w"))
			return true;
		return false;
	}
	/**Alias to canWrite.*/
	public boolean cW(String filename) { return canWrite(filename); }
	
	/**Get whether filename should be given a execute permission.*/
	public boolean canExecute(String filename) {
		if (permissions.getOrDefault(filename, "").contains("x"))
			return true;
		return false;
	}
	/**Alias to canExecute.*/
	public boolean cX(String filename) { return canExecute(filename); }
}
