package com.oozie.excute;

import java.util.Date;
import java.util.Properties;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.WorkflowJob;

/**
 * Client is used to invoke Oozie Job 
 * @author Prashant
 *
 */
public class RunOozieClient {
	
	public static final String OozieClientURL = "http://blrlt202:11000/oozie";
	public static final String NAMENODEURL = "hdfs://blrlt202:9000";
	public static final String JOBTRACKERURL = "http://blrlt202:8032";
	public static final String LIBPATH = "/test/oozie";
	public static final String APPPATH = "/test/oozie";
	
	public static void main(String[] args) {
		
		OozieClient oozieClient = new OozieClient(OozieClientURL);
		Properties conf = oozieClient.createConfiguration();
		
		conf.setProperty("nameNode", NAMENODEURL);
		conf.setProperty("jobTracker", JOBTRACKERURL);
		conf.setProperty("oozie.libpath", LIBPATH);
		
		conf.setProperty("queueName", "default");
		conf.setProperty("oozie.wf.rerun.failnodes", "true");
		
		//Setting location of Workflow.xml. ie. App-path
		conf.setProperty("appPath", APPPATH);
		conf.setProperty(OozieClient.APP_PATH, "${appPath}");
		
		//Setting arguments 
		//conf.setProperty("cliArgs1", "1234");
		//conf.setProperty("cliArgs2", "12345");
		conf.setProperty("val1", "123455");
		try {
			Date startDt = new Date();
			System.out.println("Oozie Start time :: " + startDt);
			long start = startDt.getTime();
			String jobId = oozieClient.run(conf);
			System.out.println("Workflow job, " + jobId + " submitted");
			
			do{
				//Job is running
			}while (oozieClient.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING);
			
			System.out.println("Workflow job completed ... " +"\t Status : "+oozieClient.getJobInfo(jobId).getStatus());
			Date endDt = new Date();
			long end = endDt.getTime();
			System.out.println("Oozie End time :: " + endDt);
			System.out.println("Total time for program :: "+(end-start) + " millisec");
		} catch (Exception r) {
				System.out.println("Errors " + r.getLocalizedMessage());
		}
		
	}
}
