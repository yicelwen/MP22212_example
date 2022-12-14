package travel.mix;

import travel.api.Gift;
import travel.api.Tour;

public class TourImpl2 implements Tour {
	public String name() {
		return "3 days tour for Taipei";
	}

	public int price() {
		return 3000;
	}

	public Gift getGift() {
		Gift gift = new Gift();
		gift.setDescription("breakfirst");
		return gift;
	}
}
