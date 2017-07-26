package routines;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class multifiletomultitalend {
	
	public static void main(String[] args){
		String folder = "/home/ptyler649/mytesttemp";
		String job;
		String jobname;
		String jobnamewithpostfix;
		String path;

		String[] rawline = multifiletomultitalend.getfolderlistoffiles(folder);
		for(int i = 0; i < rawline.length; i++){
			//System.out.println("RAW Line: "+rawline[i]+"length:"+rawline[i].length());
			if(rawline[i].length()>4){
				multifiletomultitalend.collectandrun(rawline[1]);
			}
		}
		
	}
	
	public static void collectandrun(String rawline){
		String job;
		String jobname;
		String jobnamewithpostfix;
		String path;
		
		// run extractparms
		// run getjobname
		jobname = multifiletomultitalend.gettalendjobname(rawline);
		// add postfix
		// _run_PT.sh
		jobnamewithpostfix = multifiletomultitalend.addpostfix(jobname, "_run_PT.sh");
		// run getpath
		path = multifiletomultitalend.getpath();
		// run job
		job = path+jobnamewithpostfix;
		multifiletomultitalend.runtalendjob(job);				
	}
	
	
	public static String[] getfolderlistoffiles(String listfolder){

		System.out.println("List Folder contents: "+listfolder);
		multifiletomultitalend obj = new multifiletomultitalend();
    	String[] output = obj.executeCommandArray(listfolder);
    	
		return output;
	}
    
    public static String extractparms(){return null;}
    
    public static String gettalendjobname(String filenameline){
    	
    	//extract from filenameline provided and return only the related talend job name 
    	return "test_args_input";
    }
    
    public static String getpath(){
    	return "/home/ptyler649/talend/testfolder/test_args_input_0.1/test_args_input/";
    }
    
    public static String addpostfix(String jobname, String postfix){
    	return jobname+postfix;
    }
    
	
    public static void runtalendjob(String job){
    	final String command = job;
    	final String output;
    	multifiletomultitalend obj = new multifiletomultitalend();
    
    	System.out.println("Running Talend Job: "+command);
    	output = obj.executeCommand(command);
    	System.out.println(output);
    }
  
    
    private String executeCommand(String command){	
    	StringBuffer output = new StringBuffer();
    	Process p;
    	
    	try{
    		p = Runtime.getRuntime().exec(command);
    		p.waitFor();
    		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    		String line = "";
    		while((line = reader.readLine())!=null){
    			output.append(line + "\n");
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    		return output.toString();	
    }
     
    private String[] executeCommandArray(String listfolder){	
    	 // associate a unix folder
        File aDirectory = new File(listfolder);
        
        // get a listing of all files in the directory
        String[] filesInDir = aDirectory.list();

        return filesInDir;
    }
    
    
    
}


