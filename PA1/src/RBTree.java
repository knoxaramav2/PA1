//Woodrow Scott

public class RBTree {

    Node root = null;
    Node nil;

    public RBTree(){
        nil = new Node();
        root = nil;
    }

    public Node getRoot(){
        return root;
    }

    public Node getNILNode(){
        return nil;
    }

    public int getSize(){
        return 0;
    }

    public int getHeight(){
        return 0;
    }

    //General RB Stuff
    void RBInsert(Endpoint value){

        Node n = new Node();
        n.key = value;


    }
}
