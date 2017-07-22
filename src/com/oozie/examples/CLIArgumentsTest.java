package com.oozie.examples;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Class accepts two CLI arguments 
 * inputValue_1 and inputValue_2
 * @author Prashant
 */
public class CLIArgumentsTest {
	
	public static void main(String[] args) throws ParseException {
		System.out.println("CLIArguments Test ");
		CommandLine cmd = initCLI(args);
		String value1 = cmd.getOptionValue("Value_1");
		String value2 = cmd.getOptionValue("Value_2");
		System.out.println("value1 :: "+value1 + "\t" + "value2 :: "+value2 );
	}

	private static CommandLine initCLI(String[] args) throws ParseException {
		CommandLineParser parser = new GnuParser();
		final Options gnuOptions = new Options();
		gnuOptions.addOption("Value_1"	, true, "VALUE 1");
		gnuOptions.addOption("Value_2"	, true, "VALUE 2");
		CommandLine cmd = parser.parse(gnuOptions, args);
		return cmd;
	}
}
