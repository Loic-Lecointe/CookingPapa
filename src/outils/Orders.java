package outils;

public class Orders {
	private final static int MAX_ORDERS = 7;
	private Order[] orders = new Order[MAX_ORDERS];
	private int nbOrders = 0;
	
	public Order get(int index) {
		return orders[index];
	}
	
	public int getNbOrders() {
		return nbOrders;
	}
	
	public boolean add(Order order) {
		int i = 0; 
		while (i < orders.length && orders[i] != null) i++;
		
		if (i < orders.length) {
			orders[i] = order;
			nbOrders++;
			return true;
		}
		return false;
	}
	
	public void remove(int index) {
		if (orders[index] != null) {
			orders[index] = null;
			nbOrders--;
		}
	}
	
	public int removeDelayedOrders(Furnaces furnaces) {
		int nbSuppr = 0;
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null && orders[i].isDelayed()) {
				furnaces.remove(orders[i]);
				remove(i);
				nbSuppr++;
			} else {
				i++;
			}
		}
		return nbSuppr;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < MAX_ORDERS; i++) {
			res.append(i+1 + ": ");
			if (orders[i] != null) {
				res.append(orders[i]);
			} else {
				res.append("_________");
			}
			res.append("\n");
		}
		return res.toString();
	}
}
