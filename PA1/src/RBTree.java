//Woodrow Scott

public class RBTree {

    Node root = null;
    Node nil;
    
    int blackHeight;

    public RBTree(){
        nil = new Node();
        root = nil;
        
        blackHeight = 0;
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
    void RBInsert(Node z){
    	
    	z.color = Node.RED;
        
        Node y = nil;
        Node x = root;

    	while (x!=nil) {
    		y=x;
    		x = x.key.getValue() < x.key.getValue() ?
    				x.leftChild: x.rightChild;
    		z.parent = y;
    		if (y==nil) {
    			root = z;
    		} else if (z.key.getValue() < y.key.getValue()) {
    			y.leftChild = z;
    		} else {
    			y.rightChild = z;
    		}
    	}
    	
    	RBInsertFix(z);
    }
    
    void RBInsertFix(Node z){
    	if (z==root) {
    		z.color=Node.BLACK;
    		++blackHeight;
    		return;
    	}
    	
    	if (z.parent.color == Node.RED) {
    		return;
    	}
    	
    	Node uncle = GetUncle(z);
    	
    	if (uncle.color == Node.RED) {
    		z.parent.color = Node.BLACK;
    		uncle.color = Node.BLACK;
    		z.parent.parent.color = Node.RED;
    	} else {
    		
    		boolean parentIsLeft = z.parent == z.parent.parent.leftChild;
    		boolean zIsLeft = z == z.parent.leftChild;
    		
    		if (parentIsLeft && zIsLeft) {
	    		//Uncle Black Left Left
	    		RightRotate(z.parent.parent);
	    		SwapColor(z.parent, z.parent.parent);
    		} else if (parentIsLeft && !zIsLeft) {
				//Uncle Black Left Right
	    		LeftRotate(z.parent);
	    		RightRotate(z.parent.parent);
	    		SwapColor(z.parent, z.parent.parent);	
    		} else if (!parentIsLeft && !zIsLeft) {
        		//Uncle Black Right Right
        		LeftRotate(z.parent.parent);
        		SwapColor(z.parent, z.parent.parent);
    		} else {
        		//Uncle Black Right Left
        		RightRotate(z.parent);
        		LeftRotate(z.parent.parent);
        		SwapColor(z.parent, z.parent.parent);
    		}
    	}
    }
    
    public void SwapColor(Node x, Node y) {
    	int c = x.color;
    	x.color = y.color;
    	y.color = c;
    }
    
    public void LeftRotate(Node x) {
    	Node y = x.rightChild;
    	x.rightChild = y.leftChild;
    	if (y.leftChild != nil) {
    		y.leftChild.parent = x;
    	}
    	y.parent = x.parent;
    	
    	if (x.parent == nil) {
    		root = y;
    	} else if (x == x.parent.leftChild) {
    		x.parent.leftChild = y;
    	} else {
    		x.parent.rightChild = y;
    	}
    	
    	y.leftChild = x;
    	x.parent = y;
    	
    }
    
    public void RightRotate(Node x) {
    	Node y = x.leftChild;
    	x.leftChild = y.rightChild;
    	if (y.rightChild != nil) {
    		y.rightChild.parent = x;
    	}
    	y.parent = x.parent;
    	
    	if (x.parent == nil) {
    		root = y;
    	} else if (x == x.parent.rightChild) {
    		x.parent.rightChild = y;
    	} else {
    		x.parent.leftChild = y;
    	}
    	
    	y.rightChild = x;
    	x.parent = y;
    }
    
    Node GetUncle(Node z) {
    	if (z.parent == null || z.parent.parent== null ) {
    		return null;
    	}
    	
    	Node gp = z.parent.parent;
    	
    	if (z.parent == gp.leftChild) {
    		return gp.rightChild;
    	} else {
    		return gp.leftChild;
    	}
    }
}
