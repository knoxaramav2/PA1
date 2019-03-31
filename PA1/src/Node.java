//Woodrow Scott

public class Node {

    public final static int RED = 0;
    public final static int BLACK = 1;

    //NIL node if null
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
    Endpoint emax;

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

    public int getVal() {
    	return val;  
    }
    
    public int setVal(){
    	
    	if (key==null) {
    		val = 0;
    	} else {
    		val = leftChild.setVal() + key.p + rightChild.setVal();
    	}
    	
        return val;
    }

    //TODO --> may be set below
    public int setMaxVal(){
    	
    	if (key==null) {
    		return 0;
    	}
    	
    //	int lmax = leftChild.setMaxVal();
    //	int rmax = rightChild.setMaxVal();
    	maxval = Math.max(Math.max(this.getLeft().maxval, this.getLeft().getVal() + this.getP()),
    			this.getLeft().getVal()+this.getP() + this.getRight().maxval); // maxVal according to the document
    	
    	//return 0;
    	
    	return Math.max(Math.max(this.getLeft().maxval, this.getLeft().getVal() + this.getP()),
    			this.getLeft().getVal()+this.getP() + this.getRight().maxval); // maxVal according to the document, 
    }
    
    public int getMaxVal() {
    	return maxval;/*Math.max(Math.max(this.getLeft().maxval, this.getLeft().getVal() + this.getP()),
    			this.getLeft().getVal()+this.getP() + this.getRight().maxval); // maxVal according to the document*/
    	
    }

    public Endpoint getEndpoint(){
        return key;
    }

    public Endpoint getEmax(){
    	if(emax == null){this.setEmax();} // may not be neede dor wrong
        return emax; 
    }

    public void setEmax(){ //occurs at the endpoint where maxVal would occur, according to post on Piazza
    	int max = Math.max(Math.max(this.getLeft().maxval, this.getLeft().getVal() + this.getP()),
    			this.getLeft().getVal()+this.getP() + this.getRight().maxval);
    	
    	if(max == this.getLeft().maxval){
    		emax = this.getLeft().getEndpoint();
    	}
    	if(max ==  this.getLeft().getVal() + this.getP()){
    		emax = this.getEndpoint();
    	}
    	
    	if(max == this.getLeft().getVal()+this.getP() + this.getRight().maxval){
    		emax = this.getRight().getEndpoint();
    	}
    	/* if max == case 1 => emax = case1.key (or endpoint)
    	 * if max == case 2 => emax = case2.key 
    	 * etc...
    	 */
    }
    
    public int getColor(){
        return color;
    }

    public void setKey(Endpoint key){
        this.key = key;
    }

}
