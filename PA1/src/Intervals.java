//Woodrow Scott

import java.util.ArrayList;
import java.util.List;

public class Intervals {

    int nextId;
    ArrayList<Interval> intervals;
    RBTree rbTree;

    public Intervals(){
        nextId = 0;
        intervals = new ArrayList<>();
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
        ++nextId;
        
        Node n1 = new Node();
        Endpoint e1 = new Endpoint();
        e1.value=a;
        e1.p = Endpoint.LEFT;
        n1.key = e1;

        Node n2 = new Node();
        Endpoint e2 = new Endpoint();
        e2.value=b;
        e2.p = Endpoint.RIGHT;     
        n2.key = e2;
        
        rbTree.RBInsert(n1);
        rbTree.RBInsert(n2);
        
        //System.out.println("Inserted " + a + " " + b);
    }
    
    //Not required
    public boolean intervalDelete(int intervalID){

        return true;
    }

    //Find endpoint of maximum overlap and return value
    //O(1)
    public int findPOM(){

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
}

