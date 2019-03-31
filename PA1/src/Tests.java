/*import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;
import java.sql.Time;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void test() {
		
		Intervals intervals = new Intervals();
		Random r = new Random();
		
		//intervals.intervalInsert(3, 8);
		intervals.intervalInsert(0, 5);
		intervals.intervalInsert(12, 15);
		//intervals.intervalInsert(7, 9);
		//intervals.intervalInsert(4, 6);
		//intervals.intervalInsert(10, 20);
		//intervals.intervalInsert(30, 15);
		//intervals.intervalInsert(5, 9);
		
		//JSONObject jsonObject = new JSONObject(intervals.getRBTree());
		//String msg = jsonObject.toString();
		
		intervals.getRBTree().InOrderWalk();
		
		System.out.println("Done");
		//fail("Not yet implemented");
	}

}
*/