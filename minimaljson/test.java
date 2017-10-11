import com.eclipsesource.json.*;
import java.io.*;

public class test{
	public static void main(String[] args) throws IOException{
		System.out.println("test minimal json");
		FileReader fr = new FileReader("test.json");

		//JsonObject object = Json.parse(fr).asObject();
		//String name = object.get("order").asString();
		//int order = object.get("order").asInt();
		//System.out.println("order:"+order);

		JsonArray items = Json.parse(fr).asObject().get("items").asArray();
		for (JsonValue item : items) {
  			String name = item.asObject().getString("name", "Unknown Item");
  			int quantity = item.asObject().getInt("quantity", 1);
			System.out.println("name:"+name);
		};		

		

	}
}
