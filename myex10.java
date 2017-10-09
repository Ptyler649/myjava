import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class myex10{
	public static void main(String[] args){
		Map map = new HashMap < > ();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		TreeMap tmap = new TreeMap(map);
		System.out.println(tmap.ceilingKey("0"));
	}
}
