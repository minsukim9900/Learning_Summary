
public class Item {
	private String name;
	private int cost;
	
	public Item() {
	}

	public Item(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", cost=" + cost + "]";
	}
	
}
