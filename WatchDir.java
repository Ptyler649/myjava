import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import static java.nio.file.LinkOption.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;
import java.nio.charset.*;
 
/**
 * Example to watch a directory (or tree) for changes to files.
 */
 
public class WatchDir {
 
    private final WatchService watcher;
    private final Map<WatchKey,Path> keys;
    private final boolean recursive;
    private boolean trace = false;
 
    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }
 
    /**
     * Register the given directory with the WatchService
     */
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
			System.out.println("test");
                }
            }
        }
        keys.put(key, dir);
    }
 
    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException
            {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
 
    /**
     * Creates a WatchService and registers the given directory
     */
    WatchDir(Path dir, boolean recursive) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey,Path>();
        this.recursive = recursive;
 
        if (recursive) {
            System.out.format("Scanning %s ...\n", dir);
            registerAll(dir);
            System.out.println("Done.");
        } else {
            register(dir);
        }
 
        // enable trace after initial registration
        this.trace = true;
    }
 
    /**
     * Process all events for keys queued to the watcher
     */
    void processEvents() throws IOException {
        for (;;) {

	    System.out.format("\nWaiting....[CTRL+C -> Exit]\n");	    
 
            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
 
            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }
 
            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
 
                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    continue;
                }
 
                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = cast(event);
                Path name = ev.context();
                Path child = dir.resolve(name);
 
		
                // print out event
                System.out.format("%s: %s", event.kind().name(), child);

		// Calling Talend Job
		if (kind == ENTRY_MODIFY){
			String checkstatus = "SUCCESS";
			System.out.format("Running autotest process!\n");
			String thefilename = child.toString();
			String[] actfile = thefilename.split("/");
			String theactfile = actfile[1];
			System.out.format("create test output html files:"+theactfile+"\n");
			// load touched file into array
			List<String> lines = Files.readAllLines(Paths.get(thefilename), Charset.forName("UTF-8"));
			// load the touched file into a new array and added additional html formatting
			List<String> newlines = new ArrayList<String>();
			newlines.add("<!DOCTYPE html>");
			newlines.add("<html>");
			newlines.add("<body>");
			for(String oldline : lines){
				// add routine to check if template lines are in the file,
				// depending on the status returned then add font format as required
				// and also change the checkstatus as appropriate
				Boolean linestatus = isvalidline(oldline,"testfiles/template");
				if(!linestatus){
					checkstatus = "FAILED";
					newlines.add("<font color=\"red\">"+oldline+"</font><br>");
				}
				else{
					newlines.add(oldline+"<br>");
				};	
			
			};


			// now check if there is line completely missing
			// so reverse previous check, validate template lines against file
			// and if template line is not found in file, add this template line in red at the end
			// of the file with MISSING + template line itself
			List<String> templatelines = Files.readAllLines(Paths.get("testfiles/template"), Charset.forName("UTF-8"));
			for(String templine : templatelines){
				Boolean linestatus = isvalidline(templine,thefilename);
				if(!linestatus){
					checkstatus = "FAILED";
					newlines.add("<font color=\"red\">MISSING:"+templine+"</font><br>");
				};
			}			
			newlines.add("</body>");
			newlines.add("</html>");
			Path file = Paths.get("status/"+theactfile+"_PRECHECK_"+checkstatus+".html");
			Files.write(file, newlines, Charset.forName("UTF-8"));

			//runtalendjob.runjob("cp testfiles/"+theactfile+" status/"+theactfile+"_PRECHECK_"+checkstatus+".html");
			runtalendjob.runjob("cp testfiles/"+theactfile+" status/"+theactfile+"_DATACHECK_"+checkstatus+".html");
			runtalendjob.runjob("cp testfiles/"+theactfile+" status/"+theactfile+"_POSTCHECK_"+checkstatus+".html");
		}
 
                // if directory is created, and watching recursively, then
                // register it and its sub-directories
                if (recursive && (kind == ENTRY_CREATE)) {
                    try {
                        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                            registerAll(child);
                        }
                    } catch (IOException x) {
                        // ignore to keep sample readbale
                    }
                }
            }
 
            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);
 
                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
 
    static void usage() {
        System.err.println("usage: java WatchDir [-r] dir");
        System.exit(-1);
    }

    static Boolean isvalidline(String linetocheck, String filetocheck) throws IOException{
	// load template in arraylist
	Boolean status = false;
	List<String> lines = Files.readAllLines(Paths.get(filetocheck), Charset.forName("UTF-8"));
	for(String checkline : lines){
		// loop through the template array checking if linetocheck is present
		// if linetocheck is not present then return false else true
		if(checkline.equals(linetocheck)){
			status = true;
		}
	};
	//System.out.format("status:"+status+"\n");	
	return status;
    }
 
    public static void main(String[] args) throws IOException {
        // parse arguments
        if (args.length == 0 || args.length > 2)
            usage();
        boolean recursive = false;
        int dirArg = 0;
        if (args[0].equals("-r")) {
            if (args.length < 2)
                usage();
            recursive = true;
            dirArg++;
        }
 
        // register directory and process its events
        Path dir = Paths.get(args[dirArg]);
        new WatchDir(dir, recursive).processEvents();
    }
}

