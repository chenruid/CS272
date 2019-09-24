
public class IntNode {
		
	/**
	 * One instance variable is for keeping an integer value;
		and the other instance variable is a link pointing to another IntNode instance or pointing to null.
	 */
	  private int data;
	  private IntNode next;
	  
	  //The no-argument constructor which sets the node value to be 0 and the link to be null refernce.
	  public IntNode() {
		  data = 0;
		  next = null;
	  }
	  
	 // A constructor with the given node value and the link.
	  public IntNode(int _data, IntNode _node) {
		  data = _data;
		  next = _node;
	  }
	  
	
	 /**Get and set methods to get the node value and node link.
	  * 
	  * @return data
	  */
	  public int getData() {
		  return data;
	  }
	  public IntNode getNext() {
		  return next;
	  }
	
	  public void setData(int n) {
		  data = n;
		  
	  }
	  public void setNext(IntNode m) {
		  next = m;
	  }
	  
	  /**toString method
	   * String for the linked list starting from the node that activates this method.
	   * @return reStr
	   */
	public String toString() {
          String result = "";
         IntNode current = this;
          while(current != null){
              result += current.getData();
              if(current.getNext() != null){
                   result += "->";
              }
              current = current.getNext();
          }
          return  result;
	}
		     
	  
	  /**create a new node with value new data. 
	   * let the current node’s link point to this new node.
	   * @param newdata
	   */
	  public void addNodeAfterThis(int newdata) {
		  if (this.getNext() != null) {
			  next = new IntNode(newdata,next); 
		  }
	  		
	  }
	  
	  /**
	   * A method to remove the node after the current node.
	   */
	  public void removeNodeAfterThis() {
		  if(this.getNext()!= null) {
			  if(this.getNext().getNext()!=null) {
				  next = this.getNext().getNext();  
			  }
		  }
		  
	  }
	  
	  /**
	   * A method to get the number of nodes in the list starting from a given node head.
	   * @param head
	   * @return length
	   */
	  public static int listLength(IntNode head) {
		  int length = 1;
		  for(IntNode cursor = head; cursor.next!=null; cursor = cursor.next) {
			  	length++;
		  }
		  return length;
	  }
	  
	  /**
	   * A method to search whether a linked list starting with head contains a given value data.
	   *@param head,data
	   *@return true or false
	   */
	  public static boolean search(IntNode head, int data) {
		  for(IntNode cursor = head; cursor != null; cursor = cursor.next) {
			  if (cursor.data == data) {
				return true;
			  } 
		  }
		  return false;
	  }

}//end class