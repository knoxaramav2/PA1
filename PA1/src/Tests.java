import static org.junit.jupiter.api.Assertions.*;

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
		
		for (int i = 0; i < 5; ++i) {
			int min = r.nextInt() % 6;
			int max = r.nextInt() % 10 + min;
			intervals.intervalInsert(min, max);
		}
		
		//JSONObject jsonObject = new JSONObject(intervals.getRBTree());
		//String msg = jsonObject.toString();
			
		System.out.println("Done");
		//fail("Not yet implemented");
	}

}
