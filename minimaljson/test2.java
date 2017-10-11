import com.eclipsesource.json.*;
import java.io.*;

public class test2{
	public static void main(String[] args) throws IOException{
		System.out.println("test minimal json");
		FileReader fr = new FileReader("test2.json");

		//JsonObject object = Json.parse(fr).asObject();
		//String name = object.get("order").asString();
		//int order = object.get("order").asInt();
		//System.out.println("order:"+order);


		JsonArray orders = Json.parse(fr).asArray();
		for (JsonValue order : orders) {
  			int ord = order.asObject().getInt("order", 9999);
  			//int quantity = item.asArray().asObject().getInt("quantity", 1);
			System.out.println("order:"+ord);
		};		



/*
		JsonArray orders = Json.parse(fr).asArray().asObject();
		for (JsonValue order : orders) {
  			String name = order.asArray().asObject().getString();
			System.out.println("name:"+name);
		};		
*/


	}
}
