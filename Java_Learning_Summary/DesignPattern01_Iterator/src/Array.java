
public class Array implements Aggregator {
	
	private Item[] items;

	
	public Array(Item[] items) {
		this.items = items; 
	}
	
	//Iterator 구현 클래스인 ArrayIterator에서 사용된다.
	public Item getItem(int idx) {
		return items[idx];
	}
	
	public int getCount() {
		return items.length;
	}
	
	@Override
	public Iterator iterator() {
		return new ArrayIterator(this);
	}
}
