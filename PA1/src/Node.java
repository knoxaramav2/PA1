//Woodrow Scott

public class Node {

    public final static int RED = 0;
    public final static int BLACK = 1;

    public final static int LEFT = 1;
    public final static int RIGHT = -1;

    int p = 0;
    Endpoint key = null;

    public int color = BLACK;//0 red, 1 black
    public Node parent = null;
    public Node leftChild = null;
    public Node rightChild = null;

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
        return p;
    }

    public int getVal(){

        //check if nil node
        if (p==0){
            return 0;
        }

        int lval = leftChild.getVal();
        int rval = rightChild.getVal();

        return lval + p + rval;
    }

    public int getMaxVal(){
        return 0;
    }

    public Endpoint getEndpoint(){
        return key;
    }

    public Endpoint getEmax(){
        return null;
    }

    public int getColor(){
        return color;
    }

    public void setKey(Endpoint key){
        this.key = key;
    }

}
