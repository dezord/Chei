package org.dezord.chei;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Chei {
	public static CommandLine exec;
	public static String syntax = "chei -C <config> -c <command>";
	
	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("C", "config", true, "security configuration file");
		options.addOption("c", "command", true, "the command to run");
		options.addOption("D", "defaults", false, "set default permissions");
		options.addOption("?", "help", false, "print this help message");
		HelpFormatter formatter = new HelpFormatter();
		
		CommandLineParser parser = new DefaultParser();
		try {
			exec = parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp(syntax, options);
			return;
		}
		
		if (exec.hasOption("?")) {
			formatter.printHelp(syntax, options);
			return;
		}
	}
}