package org.dezord.chei;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Chei {
	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("C", "config", true, "read the security config from a file");
		options.addOption("c", "command", true, "the command to run");
		
		CommandLineParser parser = new DefaultParser();
		try {
			parser.parse(options, args);
		} catch (ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("chei", options );
		}
		
	}
}