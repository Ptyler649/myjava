import java.util.*;

class myq{
// add to q
ArrayList<String> addq(ArrayList<String> q, String item){
	ArrayList<String> myq = q;
	myq.add(item);
	return myq;
} 

// remove from q
ArrayList<String> removeq(ArrayList<String> q, String item){
	ArrayList<String> myq = q;
	myq.remove(item);
	return myq;
}

// check q contents
boolean checkq(ArrayList<String> q, String item){
	boolean result = false;
	ArrayList<String> myq = q;
	
	for(String str : myq){
		if(str.equalsIgnoreCase(item)){
			result = true;
			break;
		}
	};
	
	return result;
}	

void showq(ArrayList<String> q){
		for(String mq : q ){
			System.out.println(mq);
		}
}

}


public class fileq3 {
	public static void main(String[] args) {

		// create q
		myq qc = new myq();
		ArrayList<String> q = new ArrayList<String>();
		String[] mainfilename;
		String thefile;
		
		// add to q test
		thefile = "CAPUSENTPRF161120110626.DAT";
		mainfilename = thefile.split("\\.");
		qc.addq(q, mainfilename[0]);

		thefile = "CAPUSACTPRF161120110626.DAT";
		mainfilename = thefile.split("\\.");
		qc.addq(q, mainfilename[0]);
		
		thefile = "CAPUSENTPRM161120110626.DAT";
		mainfilename = thefile.split("\\.");
		qc.addq(q, mainfilename[0]);

		
		// display q
		qc.showq(q);
		
		// check contents of q within a data set for dependencies
			// build dependencies
			ArrayList<String> dep = new ArrayList<String>();
			dep.add("ENTPRF");
			dep.add("ACTPRF");
			//dep.add("ACTLTJ");
			
			// check if dependencies are available in q
				//build string to match potential contents
				//String search = "CAPUSENTPRF161120110626";
				
				ArrayList<String> checkresult = new ArrayList<String>();
				for(String d : dep){
					// replace the filetype into the source string and check if available;
					String replaceString=mainfilename[0].replace("ENTPRM",d);
					System.out.println(d+":"+replaceString);
					
					boolean result = qc.checkq(q, replaceString);
					System.out.println(result);
					checkresult.add(Boolean.toString(result));
				};
				
			
				// check contents of result listings q, to check if all dependencies are still available
				boolean result = qc.checkq(checkresult, "FALSE");
				System.out.println("if result here is true then has dependencies then do not run: "+result);
		
				
				
		// if dependencies available in q then process these
		boolean success = false;
		if(!result){
			System.out.println("run: "+mainfilename[0]);
			success = true;
		}		
		
		// if run success then remove the item
		if(success){
			qc.removeq(q, mainfilename[0]);
			qc.showq(q);
		}
		
	}

}
