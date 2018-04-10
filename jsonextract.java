package local_dev;

import java.io.FileReader;
import java.io.IOException;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.eclipsesource.json.JsonObject.Member;

public class jcleaner {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("test json input from a json file and outputs string values");
		
		//FileReader fr = new FileReader("C:\\Users\\ptyle\\Desktop\\test4.json");
		// note also validate for json and handle error
		//FileReader fr = new FileReader("C:\\Users\\ptyle\\Desktop\\sandeep2.json");
		FileReader fr = new FileReader("C:\\Users\\ptyle\\Desktop\\sandeep.json");
		
		
		// below is sandeep.json with array
		// json structute is array:object:object:object
		JsonArray jsonArray = Json.parse(fr).asArray();
		
		for( JsonValue xvalue : jsonArray ){
			System.out.println("starter array:"+xvalue);
			String myjson = ""+xvalue;
		
			JsonObject orders = Json.parse(myjson).asObject();
			
			for (Member member : orders) {
	  			String tr_acl_control_nbr = member.getName();
	  			JsonValue value = member.getValue();
	  			System.out.println("acl_control_nbr:"+tr_acl_control_nbr);
	  			
	  			//iterate over mid-level;
	  			JsonObject ano_orders = orders.get( tr_acl_control_nbr ).asObject();
	  			for(Member ano_member : ano_orders){
	  				String ano_tr_acl_control_nbr = ano_member.getName();
	  				System.out.println("ano_acl_control_nbr:"+ano_tr_acl_control_nbr);
	  				
	  				// iterate over the lowest level
	  				//boolean x_orders = ano_orders.get(ano_tr_acl_control_nbr).isObject();
	  				JsonObject x_orders = ano_orders.get(ano_tr_acl_control_nbr).asObject();
	  				for(Member ano_ano_member : x_orders){
	  					String x_tr_acl_control_nbr = ano_ano_member.getName();
	  					JsonValue y_tr_acl_control_nbr = ano_ano_member.getValue();
	  					System.out.println( x_tr_acl_control_nbr+":"+y_tr_acl_control_nbr);
	  				}
	  				
	  				
	  			}  			
			};

		}
		
		
		
/*		
  
 		
		// object : object : element, below is sandeep2.json without array
		
		// iterate over high level
		JsonObject orders = Json.parse(fr).asObject();
		for (Member member : orders) {
  			String tr_acl_control_nbr = member.getName();
  			JsonValue value = member.getValue();
  			System.out.println("acl_control_nbr:"+tr_acl_control_nbr);
  			
  			//iterate over mid-level;
  			JsonObject ano_orders = orders.get( tr_acl_control_nbr ).asObject();
  			for(Member ano_member : ano_orders){
  				String ano_tr_acl_control_nbr = ano_member.getName();
  				System.out.println("ano_acl_control_nbr:"+ano_tr_acl_control_nbr);
  				
  				// iterate over the lowest level
  				//boolean x_orders = ano_orders.get(ano_tr_acl_control_nbr).isObject();
  				JsonObject x_orders = ano_orders.get(ano_tr_acl_control_nbr).asObject();
  				for(Member ano_ano_member : x_orders){
  					String x_tr_acl_control_nbr = ano_ano_member.getName();
  					JsonValue y_tr_acl_control_nbr = ano_ano_member.getValue();
  					System.out.println( x_tr_acl_control_nbr+":"+y_tr_acl_control_nbr);
  				}
  				
  				
  			}  			
		};
		
*/			
			
	}


}
