//Woodrow Scott

public class RBTree {

    Node root = null;
    Node nil;
    
    //testing
    int nodes = 0;
    
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
        return nodes;
    }

    public int getHeight(){
        return (int)Math.ceil((Math.log(nodes+1)/Math.log(2))); //TODO
    }
    

    //General RB Stuff

    void RBInsert(Node z) {
    	
    	++nodes;
    	
    	Node y = nil;
    	Node x = root;
    	
    	while (x!=nil) {
    		y=x;
    		if (z.key.value < x.key.value) {
    			x = x.leftChild;
    		} else {
    			x = x.rightChild;
    		}
    	}
    	
    	z.parent = y;
    	if (y==nil) {
    		root = z;
    		//root.parent=nil;
    	} else if (z.key.value < y.key.value) {
    		y.leftChild = z;
    	} else {
    		y.rightChild = z;
    	}
    	
    	z.leftChild = nil;
    	z.rightChild = nil;
    	z.color = Node.RED;
    	
    	RBInsertFixup(z);
    	
    	z.setVal();
    	z.setMaxVal();
    	z.setEmax(); // TODO double check for accuracy
    }
    
    void RBInsertFixup(Node z) {
    	while(z.parent.color == Node.RED) {
    		if (z.parent == z.parent.parent.leftChild) {
    			Node y = z.parent.parent.rightChild;
    			if (y.color == Node.RED) {
    				System.out.println("Fixup: case 1 left on " + z.key.value + " " + z.color);
    				z.parent.color = Node.BLACK;
    				y.color = Node.BLACK;
    				z.parent.parent.color = Node.RED;
    				z = z.parent.parent;
    			} else {
    				if (z==z.parent.rightChild) {
        				System.out.println("Fixup: case 2 left on " + z.key.value + " " + z.color);
        				z = z.parent;
        				LeftRotate(z);
    				}
    				System.out.println("Fixup: case 3 left on " + z.key.value + " " + z.color);
    				z.parent.color = Node.BLACK;
        			z.parent.parent.color = Node.RED;
        			RightRotate(z.parent.parent);
    			}
    		} else {
    			Node y = z.parent.parent.leftChild;
    			if (y.color == Node.RED) {
    				System.out.println("Fixup: case 1 right on " + z.key.value + " " + z.color);
    				z.parent.color = Node.BLACK;
    				y.color = Node.BLACK;
    				z.parent.parent.color = Node.RED;
    				z = z.parent.parent;
    			} else {
    				if (z==z.parent.leftChild) {
        				System.out.println("Fixup: case 2 right on " + z.key.value + " " + z.color);
        				z = z.parent;
        				RightRotate(z);
    				}
    				System.out.println("Fixup: case 3 right on " + z.key.value + " " + z.color);
    				z.parent.color = Node.BLACK;
        			z.parent.parent.color = Node.RED;
        			LeftRotate(z.parent.parent);
    			}
    		}
    	}
    	
    	root.color = Node.BLACK;
    	InOrderWalk();
    }
    
    void InOrderWalk() {
    	InOrderWalkRec(root, 0);
    	System.out.println(nodes);
    }
    
    void InOrderWalkRec(Node x, int tab) {
    	++tab;
    	if (x!=nil) {
    		InOrderWalkRec(x.leftChild, tab);
    		//System.out.println(x.color + " " + x.key.p + " " + x.key.value + " " + x.key.Id + " " + (x.parent==null?" root":""));
    		
    		for(int i=0; i<tab;++i) {
    			System.out.print("  ");
    		}
    		System.out.println(String.format("%2d [%2d %d %s] %2d", 
    				x.leftChild!=nil?x.leftChild.key.value:0,
					x.key.value, x.color, x.parent==nil?"root":"",
					x.rightChild!=nil?x.rightChild.key.value:0));
    		
    		InOrderWalkRec(x.rightChild, tab);
    	}
    }
    
    void RBInsertFix(Node x) {
    	Node p = x.parent;
    	Node g = p.parent != nil? x.parent.parent : null;
    	Node u = null;
    	if (g!=null) {
    		if (p==g.leftChild) {u = g.rightChild;}
    		else {u = g.leftChild;}
    	} else {
    		return;
    	}
    	
    	if (p == g.leftChild && x == p.leftChild) {
    		RightRotate(g);
    		SwapColor(g,p);
    	} else if (p == g.leftChild && x == p.rightChild) {
    		LeftRotate(p);
    		RightRotate(g);
    		SwapColor(x, g);
    	} else if (p == g.rightChild && x == p.rightChild) {
    		LeftRotate(g);
    		SwapColor(g,p);
    	} else if (p == g.rightChild && x == p.leftChild) {
    		RightRotate(p);
    		LeftRotate(g);
    		SwapColor(x, g);
    	} else {
    		System.out.println("Hmm");
    		return;
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
    	
    	if (x.parent == null) {
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
