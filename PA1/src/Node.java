//Woodrow Scott

public class Node {

    public final static int RED = 0;
    public final static int BLACK = 1;

    Endpoint key = null;

    public int color = BLACK;//0 red, 1 black
    public Node parent = null;
    public Node leftChild = null;
    public Node rightChild = null;
    
    //sum of p values of child nodes
    //val=s(lv,rv)
    int val;	
    //maximum value obtained by s(lv, i) for lv <= i <= rv
    int maxval;
    //reference to endpoint em, where m is the value of i that 
    //maximizes s(lv,i) over all i such that lv <= i <= rv
    int emax;

    public Node getParent(){
        return parent;
    }

    public Node getLeft(){
        return leftChild;
    }

    public Node getRight(){
        return rightChild;
    }

    public int getKey(){
        return key.getValue();
    }

    public int getP(){
        return key.p;
    }

    public int getVal(){
        int lval = leftChild.getVal();
        int rval = rightChild.getVal();

        return lval + getP() + rval;
    }

    public int getMaxVal(){
        return 0; //TODO
    }

    public Endpoint getEndpoint(){
        return key;
    }

    public Endpoint getEmax(){
        return null; //TODO
    }

    public int getColor(){
        return color;
    }

    public void setKey(Endpoint key){
        this.key = key;
    }

}
