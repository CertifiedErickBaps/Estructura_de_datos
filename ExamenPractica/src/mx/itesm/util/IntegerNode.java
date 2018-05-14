package mx.itesm.util;

public class IntegerNode {
	public int value;
	public IntegerNode next;
	public IntegerNode prev;
	public IntegerNode(){
		value=-1;
		next= this;
		prev= this;
	}
	public IntegerNode(int value){
		this.value= value;
		next=this;
		prev=this;
		
	}
	public static String toString(IntegerNode node){
		IntegerNode header= node;
		if (node.next == header){
			return "[]";
		}
		String returnValue = "["+ header.next.value;
		while(header.next != node){
			returnValue= ","+header.value;
			header=header.next;
			
		}
		returnValue += "]";
		return returnValue;
	}
}
