package gtree;

import java.util.ArrayList;
import java.util.Iterator;

public class GTNode {
	private Object value;
	private ArrayList<GTNode> childs;
	
	public GTNode(Object value) {
		this.value = value;
		childs = new ArrayList<GTNode>();
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ArrayList<GTNode> getChilds() {
		return childs;
	}
	
	public Iterator<GTNode> getChildsIt() {
		return childs.iterator();
	}

	public void setChilds(ArrayList<GTNode> childs) {
		this.childs = childs;
	}
}
