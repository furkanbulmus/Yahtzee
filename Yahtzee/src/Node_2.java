public class Node_2 {  
	private Object data;
	private Object data2;  // Binary node class for saving high score data in binary.
	private Node_2 link;
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData2() {
		return data2;
	}

	public void setData2(Object data2) {
		this.data2 = data2;
	}

	public Node_2 getLink() {
		return link;
	}
	
	public void setLink(Node_2 link) {
		this.link = link;
	}
	
	public Node_2 (Object dataToAdd, Object dataToAdd2) {
		data = dataToAdd;
		data2 = dataToAdd2;
		link = null;
	}

	
}
