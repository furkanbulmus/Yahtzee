public class SingleLinkedList {
	private Node head;
	private Node_2 head2;
	
	public void add(Object data) {
		Node newNode = new Node(data);
		
		if(head == null) 
			head = newNode;
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
		}
	}
	
	public void doubleAdd(Object data, Object data2) {  // To add binary data.
		Node_2 newNode = new Node_2(data, data2);
		
		if(head2 == null) 
			head2 = newNode;
		else {
			Node_2 temp = head2;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
		}
	}
	
	public int size() {
		if(head == null) 
			return 0;
		else {
			int count = 0;
			Node temp = head;
			while(temp != null) {
				temp = temp.getLink();
				count ++;
			}
			return count;
		}
	}
	
	public void display(){  
		if(head == null)
			System.out.println("List is empty.");
		else {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
	}
	
	public void displayHighScore() {  // To print the high score table.
		if(head2 == null)
			System.out.println("List is empty.");
		else {
			Node_2 temp = head2;
			while(temp != null) {
				System.out.println(temp.getData() + " " + temp.getData2());
				temp = temp.getLink();
			}
		}
	}
	
	public void delete(Object data) {  // With this function, we delete the number written in it from the list once.
		boolean flag = true;
		if(head == null)
			System.out.println("List is empty.");
		else {
			while((Integer) head.getData() == (Integer)data && flag == true) {
				head = head.getLink();
				flag = false;
			}
	
			Node previous = null;
			Node temp = head;
			
			while(temp != null && flag == true) {
				if((Integer) temp.getData() == (Integer)data) {
					previous.setLink(temp.getLink());
					temp = previous;
					flag = false;
				}
				previous = temp;
				temp = temp.getLink();
			}
		}
	}
	
	public void deleteTheLast() {  // To delete the last element of the list.
		if (head2 == null)
			System.out.println("List is empty.");
		else {
			Node_2 temp = head2;
			while (temp != null) {
				if (temp.getLink() == null)
					temp = null;
			}
		}
	}
	
	public boolean search(Object data) {
		if(head == null) {
			System.out.println("List is empty.");
			return false;
		}
		else {
			Node temp = head;
			while(temp != null) {
				if((Integer)temp.getData() == (Integer)data)
					return true;
				temp = temp.getLink();
			}
			return false;
		}
	}
	
	public void highScoreSorting(Object name, Object score) {  
		Node_2 newNode; 
		Node_2 temp;
		Node_2 previous = null;
		boolean flag = true;
		// Here we list the elements added to the list.
		if (head2 == null)
			doubleAdd(name, score);
		else {
			temp = head2;
			while (temp != null && flag == true) {
				if ((int)temp.getData2() < (int)score) {
					newNode = new Node_2(name, score);
					if (temp == head2) {
						head2 = newNode;
						head2.setLink(temp);
					}
					else {
						previous.setLink(newNode);
						newNode.setLink(temp);
					}
					flag = false;
				}
				previous = temp;
				temp = temp.getLink();
			}
			if (flag == true) 
				doubleAdd(name, score);
		}
	}
	
	public void Search4SameNumbers() {
		Node temp;  
		int number;
		if (head == null) 
			System.out.println("List is empty.");
		else {  // With this function, we check the case of 4 same numbers.
			for (int i = 1; i < 7; i++) {
				temp = head;
				number = 0;
				while (temp != null) {
					if ((int)temp.getData() == i)
						number++;
					temp = temp.getLink();
				}
				if (number >= 4) {
					for (int j = 1; j < 5; j++)
						delete(i);
				}
			}
		}
	}
	
	public void Search6ConsecutiveNumbers() {
		boolean flag = true;
		// With this function, we check the case of 6 consecutive numbers.
		if (head == null)
			System.out.println("List is empty.");
		else {
			for (int i = 1; i < 7; i++) {
				if (search(i) == false) {
					flag = false;
					break;
				}
			} 
			
			if (flag == true) {
				for (int i = 1; i < 7; i++) 
					delete(i);
			}
		}
		
	}
}