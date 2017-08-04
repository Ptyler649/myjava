import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class fileq {
	    public static void main(String[] args) {
	        Queue<String> myQueue = new LinkedList<String>();
	        
	        // check if file has a dependency, if it has a matching dataset id then it is dependency
	        // if dependency then load list of dependencies from dependency file 
	        // then check if dependency is available in q
	        // then load
	        
	        myQueue.offer("PARADD");
	        myQueue.offer("ACTBMK");
	        myQueue.offer("ENTPRF");
	        myQueue.offer("ACCTID");
	        myQueue.offer("ENTADD");
	        
	        // - also return true/false on entry
	        boolean flag = myQueue.offer("ENTPRM");
	        System.out.println("ENTPRM inserted successfully? "+flag);
	        
	        // add more elements using add() - throws IllegalStateException
	        try {
	            myQueue.add("ACCTPRM");
	            myQueue.add("ENTPRM");
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Pick the head of the queue: " + myQueue.peek());
	        String head = null;
	        try {
	            // remove head - remove()
	            head = (String) myQueue.remove();
	            System.out.print("1) Push out " + head + " from the queue ");
	            System.out.println("and the new head is now: "+myQueue.element());
	        } catch (NoSuchElementException e) {
	            e.printStackTrace();
	        }
	        // remove the head - poll()
	        head = (String) myQueue.poll();
	        System.out.print("2) Push out " + head + " from the queue");
	        System.out.println("and the new head is now: "+myQueue.peek());
	        
	        // find out if the queue contains an object
	        System.out.println("Does the queue contain 'ACCTPRM'? " + myQueue.contains("ACCTPRM"));
	        System.out.println("Does the queue contain 'ENTPRF'? " + myQueue.contains("ENTPRF"));
	    }
	}

