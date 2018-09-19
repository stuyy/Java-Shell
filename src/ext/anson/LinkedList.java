package ext.anson;

public class LinkedList {
	
	Node root;
	
	public LinkedList()
	{
		
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void printList()
	{
		Node temp = root;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public StringBuilder buildPath()
	{
		StringBuilder pathName = new StringBuilder();
		Node temp = root;
		while(temp != null)
		{
			pathName.append(temp.data + "//");
			temp = temp.next;
		}
		return pathName;
	}
	public void addNode(String data)
	{
		if(isEmpty())
			root = new Node(data);
		else
		{
			Node temp = root;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.addNode("C:");
		list.addNode("Users");
		list.addNode("Anson");
		list.printList();
		System.out.println(list.buildPath().toString());
	}
}

class Node 
{
	String data;
	Node next;
	Node prev;
	
	public Node()
	{
		
	}
	public Node(String data)
	{
		this.data = new String(data);
		this.next = this.prev = null;
	}
	
}