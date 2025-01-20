
public class ArrayIterator implements Iterator {
	
	
	private Array array;
	private int idx;
	
	
	
	public ArrayIterator(Array array) {
		this.array = array;
		this.idx = -1;
	}

	@Override
	public boolean next() {
		return ++idx < array.getCount();
	}

	@Override
	public Object current() {
		return array.getItem(idx);
	}

}
