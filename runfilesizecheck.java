import java.io.*;

public class runfilesizecheck{
	private static final runfilesizecheck instance = new runfilesizecheck();

	private runfilesizecheck(){};

	public static runfilesizecheck getinstance(){
		return instance;
	}

	public static Boolean runjob(String job){
    		final String command = job;
		final String output;
    		Boolean result = false;
    		runfilesizecheck obj = new runfilesizecheck();
    
    		System.out.println("Checking filesize: "+command);
    		output = obj.executeCommand(command);
    		System.out.println(output);

		if(output.length()>0){
			result = true;
		};
	
		return result;
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
