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

    public void intervalInsert(int a, int b){

        intervals.add(new Interval(a,b,nextId));
        Endpoint e1 = new Endpoint();
        Endpoint e2 = new Endpoint();

        e1.value=a;
        e2.value=b;

        Node n1 = new Node();
        Node n2 = new Node();

        n1.p = Node.LEFT;


        n2.p = Node.RIGHT;

        ++nextId;
    }

    //Not required
    public boolean intervalDelete(int intervalID){

        return true;
    }

    public int findPOM(){

        return 0;
    }

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

