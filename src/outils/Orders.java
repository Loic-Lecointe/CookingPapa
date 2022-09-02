package outils;

public class Orders {
	private final static int MAX_ORDERS = 5;
	private Plat[] orders = new Plat[MAX_ORDERS];
	private int nbOrders = 0;
	
	public Plat get(int index) {
		return orders[index];
	}
	
	public int getNbOrders() {
		return nbOrders;
	}
	
	public boolean add(Plat order) {
		if (MAX_ORDERS == nbOrders) {
			return false;
		}
		orders[nbOrders++] = order;
		return true;
	}
	
	public void remove(int index) {
		for (int i = index; i < MAX_ORDERS - 1; i++) {
			orders[i] =  orders[i + 1];
		}
		orders[orders.length - 1] = null;
		nbOrders--;
	}
	
	public void removeDelayedOrders() {
		int i = 0;
		while (i < nbOrders) {
			if (orders[i].isDelayed()) {
				remove(i);
			} else {
				i++;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < MAX_ORDERS; i++) {
			res.append(i+1 + ": ");
			if (orders[i] != null) {
				res.append(orders[i].getName() + " (" + (i + 1) + ") " + orders[i].getTimeBeforeLeaving());
			} else {
				res.append("_________");
			}
			res.append("\n");
		}
		return res.toString();
	}
}
