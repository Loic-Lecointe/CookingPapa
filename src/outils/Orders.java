package outils;

public class Orders {
	private final static int MAX_ORDERS = 5;
	private Plat[] orders = new Plat[MAX_ORDERS];
	private int nbOrders = 0;
	
	public Plat get(int index) {
		return orders[index];
	}
	
	public boolean add(Plat order) {
		if (MAX_ORDERS == nbOrders) {
			return false;
		}
		orders[nbOrders++] = order;
		return true;
	}
	
	public void remove(int index) {
		for (int i = index; i < orders.length - 1; i++) {
			orders[i] =  orders[i + 1];
		}
		nbOrders--;
		orders[orders.length - 1] = null;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < MAX_ORDERS; i++) {
			res.append(i+1 + ": ");
			if (orders[i] != null) {
				res.append(orders[i].getName() + " (" + (i + 1) + ")");
			} else {
				res.append("_________");
			}
			res.append("\n");
		}
		return res.toString();
	}
}
