
public class IntNodeTest {
	 public static void main(String[]args) {
		 IntNode node1 = new IntNode();
		  IntNode node2 = new IntNode();
		  IntNode node3 = new IntNode();
		  IntNode node4 = new IntNode();
		  IntNode node5 = new IntNode();
	  
		  //test the set data method
		  node1.setData(10);
		  node2.setData(20);
		  node3.setData(30);
		  node4.setData(90);
		  node5.setData(0);
	 
		  //text the set next method
		  node1.setNext(node2);
		  node2.setNext(node3);
		  node3.setNext(node4);
		  node4.setNext(node5);
		  node5.setNext(null);
	 
		  //text the get method
		  System.out.println( node1.getData());
		  
		  //text the to String method 
		  System.out.println(IntNode.listLength(node1));
	 
		  //text the search method
		  System.out.println(IntNode.search(node2,10));
		  
		  //text the add method
		  node1.addNodeAfterThis(99);
		  System.out.println(node1.toString());
		  
		  //text the remove method 
		  node2.removeNodeAfterThis();
		  System.out.println(node1.toString());
		  
		  
	 }
}
