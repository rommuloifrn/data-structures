package gtree;

import list.List;

public class GTNode {
	private Object value;
	private List childs;
	
	public GTNode(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public List getChilds() {
		return childs;
	}

	public void setChilds(List childs) {
		this.childs = childs;
	}
}
