package org.dezord.chei;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
	public static CommandLine parser;
	public static Options options = new Options();
	public static HelpFormatter formatter = new HelpFormatter();
	public static String syntax = "chei -c <command>";
	public static boolean defaultPerms = false;
	
	public static void main(String[] args) {
		options.addOption("C", "config", true, "security configuration file");
		options.addOption("c", "command", true, "the command to run");
		options.addOption("D", "defaults", false, "set default permissions, implied when -c omitted");
		options.addOption("r", "restore", true, "file, if exists to restore full program configuration, otherwise created");
		options.addOption("?", "help", false, "print this help message");
		
		try {
			parser = new DefaultParser().parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			showHelp();
		}
		
		if (parser.hasOption("?"))
			showHelp();
		
		if (!parser.hasOption("c")||parser.hasOption("D"))
			defaultPerms = true;
		
		new Chei();
	}
	
	public static void showHelp() {
		formatter.printHelp(syntax, options);
		System.exit(0);
	}
}