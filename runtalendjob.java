import java.io.*;

public class runtalendjob{
	private static final runtalendjob instance = new runtalendjob();

	private runtalendjob(){};

	public static runtalendjob getinstance(){
		return instance;
	}

	public static void runjob(String job){
    		final String command = job;
    		final String output;
    		runtalendjob obj = new runtalendjob();
    
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

}
