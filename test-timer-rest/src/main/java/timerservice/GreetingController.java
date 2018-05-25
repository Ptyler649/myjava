package timerservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Timer Status %s";
    private final AtomicLong counter = new AtomicLong();

	
	// http://localhost:8080/timer?name=ldkjfadklsjfdklj
	// http://localhost:8080/timer
	
    @RequestMapping("/timer")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Timer Status:") String name) {
		
		//check timer status here
		// check pattern is valid lxv**** as a guard clause
		// class to return translation false = stopped, true = running
		Boolean timer_status = CheckTimerStatus(false);
		name = name + " is:"+timer_status;
		
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	
	private static Boolean CheckTimerStatus(Boolean state){
		Boolean return_time_state = false;
		
		// go and check controller folder for the status file as per spec
		if(state){
			return_time_state = false;
		}
		else{
			return_time_state = true;
		};
		return return_time_state;
	}
	
}
