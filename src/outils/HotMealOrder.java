package outils;

import java.util.Date;

public class HotMealOrder extends MealOrder {
	private static final int TIME_TO_COOK = 10;
	private Date time_start_cook;
	
	public HotMealOrder(Recipe receipe) {
		super(receipe);
	}
	
	@Override
	public boolean isHot() {
		return true;
	}
	
	public String getProgressBar() {
		int BAR_SIZE = 10;
		Date now = new Date();
		long completed = (long) ((double) ((now.getTime() - time_start_cook.getTime()) / 1000) / TIME_TO_COOK * BAR_SIZE);
		if (completed > BAR_SIZE) {
			completed = BAR_SIZE;
		}
		StringBuilder res = new StringBuilder();
		res.append("[");
		
		for (int i = 0; i < completed; i++) {
			res.append("■");
		}
		
		for (int i = 0; i < BAR_SIZE - completed; i++) {
			res.append(" ");
		}
		
		res.append("]");
		return res.toString();
	}
	
	public void startCook() {
		time_start_cook = new Date();
	}
	
	public boolean isCooking() {
		return time_start_cook != null && !isCooked();
	}
	
	public boolean isCooked() {
		if (time_start_cook == null) {
			return false;
		}
		Date now = new Date();
		return (now.getTime() - time_start_cook.getTime()) / 1000 >= TIME_TO_COOK;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(super.toString());
		if (isCooked()) {
			res.append(" Pret!");
		} else if (isCooking()) {
			res.append(" En cours...");
		}
		return res.toString();
	}
}
