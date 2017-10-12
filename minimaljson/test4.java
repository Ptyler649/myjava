import com.eclipsesource.json.*;
import com.eclipsesource.json.JsonObject.*;
import java.io.*;

public class test4{
	public static void main(String[] args) throws IOException{
		System.out.println("test minimal json 4");
		FileReader fr = new FileReader("test4.json");

		//JsonObject object = Json.parse(fr).asObject();
		//String name = object.get("order").asString();
		//int order = object.get("order").asInt();
		//System.out.println("order:"+order);
/*

		JsonObject orders = Json.parse(fr).asObject();
		for (Object member : orders) {
			String name = member.toString();
  			//String name = member.getName();
  			//JsonValue value = member.getValue();
 			 // ...
			System.out.println("test:"+name);
		};
*/

		JsonObject orders = Json.parse(fr).asObject();
		for (Member member : orders) {
  			String tr_acl_control_nbr = member.getName();
  			JsonValue value = member.getValue();
			System.out.println("acl_control_nbr:"+tr_acl_control_nbr);
			String tr_act_account_cd = value.asObject().getString("act_account_cd", "unk");
			System.out.println("  act_account_cd:"+tr_act_account_cd);
			String tr_act_branch_cd = value.asObject().getString("act_branch_cd", "unk");
			System.out.println("  act_branch_cd:"+tr_act_branch_cd);
		};	



/*
		for (JsonValue order : orders) {
  			int ord = order.asObject().getInt("order", 9999);
  			//int quantity = item.asArray().asObject().getInt("quantity", 1);
			System.out.println("order:"+ord);
		};		
*/


/*
		JsonArray orders = Json.parse(fr).asArray().asObject();
		for (JsonValue order : orders) {
  			String name = order.asArray().asObject().getString();
			System.out.println("name:"+name);
		};		
*/


	}
}
