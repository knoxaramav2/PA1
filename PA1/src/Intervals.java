//Woodrow Scott

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Intervals {

    int nextId;
    ArrayList<Interval> intervals;
    ArrayList<Node> nodes;
    RBTree rbTree;

    public Intervals(){
        nextId = 0;
        intervals = new ArrayList<>();
        nodes = new ArrayList<>();
        rbTree = new RBTree();
    }

    //O(logn)
    public void intervalInsert(int a, int b){

    	if (b<a) {
    		int c = b;
    		b = a;
    		a = c;
    	}
    	
        intervals.add(new Interval(a,b,nextId));
        
        Node n1 = new Node();
        Endpoint e1 = new Endpoint();
        e1.value=a;
        e1.Id = nextId;
        e1.p = Endpoint.LEFT;
        n1.key = e1;

        Node n2 = new Node();
        Endpoint e2 = new Endpoint();
        e2.value=b;
        e2.Id = nextId;
        e2.p = Endpoint.RIGHT;     
        n2.key = e2;
        
        rbTree.RBInsert(n1);
        rbTree.RBInsert(n2);
        
        nodes.add(n1);
        nodes.add(n2);
        
        ++nextId;
        //System.out.println("Inserted " + a + " " + b);
    }
    
    //Not required
    public boolean intervalDelete(int intervalID){

        return true;
    }

    //Find endpoint of maximum overlap and return value
    //O(1)
    public int findPOM(){

    	if (rbTree.getSize() == 0) {
    		return 0;
    	}
    	
        return 0;
    }

    //Return RBT
    public RBTree getRBTree(){

        return rbTree;
    }

    class Interval{
        int a, b, id;
        public Interval(int a, int b, int id){
            this.a=a;
            this.b=b;
            this.id=id;
        }
    }

    public static void main(String[] args) {
    	Intervals intervals = new Intervals();
		Random r = new Random();
		
		//intervals.intervalInsert(3, 8);
		//intervals.intervalInsert(0, 5);
		//intervals.intervalInsert(12, 15);
		intervals.intervalInsert(7, 9);
		intervals.intervalInsert(4, 6);
		intervals.intervalInsert(10, 20);
		intervals.intervalInsert(30, 15);
		//intervals.intervalInsert(5, 9);
		
		//JSONObject jsonObject = new JSONObject(intervals.getRBTree());
		//String msg = jsonObject.toString();
		
		intervals.getRBTree().InOrderWalk();
    }
}

