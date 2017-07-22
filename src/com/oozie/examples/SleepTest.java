package com.oozie.examples;

import java.util.Date;

/**
 * Class sleeps for 60 seconds
 * @author Prashant
 *
 */
public class SleepTest {

	public static void main(String[] args) throws Exception {
		
		Date startDt = new Date();
		System.out.println("Program Start time :: " + startDt);
		long start = startDt.getTime();
		System.out.println("Sleeping for : 60 seconds");
		Thread.sleep(60000);
		Date endDt = new Date();
		long end = endDt.getTime();
		System.out.println("Program End time :: " + endDt);
		System.out.println("Total time for program :: "+(end-start) + " millisec");
	}

}
