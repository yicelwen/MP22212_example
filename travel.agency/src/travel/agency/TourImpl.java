package travel.agency;

import travel.api.Gift;
import travel.api.Tour;

public class TourImpl implements Tour {
	public String name() {
		return "One week tour for Taipei";
	}

	public int price() {
		return 7000;
	}

	public Gift getGift() {
		Gift gift = new Gift();
		gift.setDescription("T-shirt");
		return gift;
	}
	
}
