package outils;

import java.util.Date;

public class HotOrder extends Order {
	private static final int TIME_TO_COOK = 10;
	
	public HotOrder(Receipe receipe) {
		super(receipe);
	}
	
	@Override
	public boolean isHot() {
		return true;
	}
	
	public String getProgressBar() {
		int BAR_SIZE = 10;
		Date now = new Date();
		long completed = (long) ((double) ((now.getTime() - time_start.getTime()) / 1000) / TIME_TO_COOK * BAR_SIZE);
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
}
