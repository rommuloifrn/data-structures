package alist;

public class Position {
	Object value;
	
	public Position() {
	}
	
	public Position(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public String toString() {
		return String.format("%s", value);
	}
	
}

