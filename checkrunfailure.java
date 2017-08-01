
import java.io.*;
import java.util.*;

public class checkrunfailure {

	
	public static void main(String[] args) {
		
		String out;
		File file = new File("/home/ptyler649/workspace/routines/src/routines/log.txt");
		//System.out.println(tail2(file, 10));
		
		out = tail2(file, 10);
		
		String[] checkinglines = out.split("\n");
		
		for(String line : checkinglines){
			//System.out.println(line);
			if(line.equals("-1")){
				System.out.println("Errored Talend job.");
			}
		}

	}
	
	static String tail2( File file, int lines) {
	    java.io.RandomAccessFile fileHandler = null;
	    try {
	        fileHandler = 
	            new java.io.RandomAccessFile( file, "r" );
	        long fileLength = fileHandler.length() - 1;
	        StringBuilder sb = new StringBuilder();
	        int line = 0;

	        for(long filePointer = fileLength; filePointer != -1; filePointer--){
	            fileHandler.seek( filePointer );
	            int readByte = fileHandler.readByte();

	             if( readByte == 0xA ) {
	                if (filePointer < fileLength) {
	                    line = line + 1;
	                }
	            } else if( readByte == 0xD ) {
	                if (filePointer < fileLength-1) {
	                    line = line + 1;
	                }
	            }
	            if (line >= lines) {
	                break;
	            }
	            sb.append( ( char ) readByte );
	        }

	        String lastLine = sb.reverse().toString();
	        return lastLine;
	    } catch( java.io.FileNotFoundException e ) {
	        e.printStackTrace();
	        return null;
	    } catch( java.io.IOException e ) {
	        e.printStackTrace();
	        return null;
	    }
	    finally {
	        if (fileHandler != null )
	            try {
	                fileHandler.close();
	            } catch (IOException e) {
	            }
	    }
	}

}

