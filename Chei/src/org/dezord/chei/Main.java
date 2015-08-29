package org.dezord.chei;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
	public static CommandLine exec;
	public static Options options = new Options();
	public static HelpFormatter formatter = new HelpFormatter();
	public static String syntax = "chei -c <command>";
	
	public static void main(String[] args) {
		options.addOption("C", "config", true, "security configuration file");
		options.addOption("c", "command", true, "the command to run");
		options.addOption("D", "defaults", false, "set default permissions");
		options.addOption("?", "help", false, "print this help message");
		
		CommandLineParser parser = new DefaultParser();
		try {
			exec = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			showHelp();
		}
		
		if (exec.hasOption("?")) {
			showHelp();
		}
		
	}
	
	public static void showHelp() {
		formatter.printHelp(syntax, options);
		System.exit(0);
	}
}