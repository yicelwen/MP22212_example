package travel.buyer;

import java.util.List;

import travel.api.Tour;

public class TourBuyer {
	public static void main(String[] args) {
		Tour tour = TourFinder.findTour();
		System.out.println("find tour: " + tour);
		List<Tour> tours = TourFinder.findAllTours();
		System.out.println("find tours: " + tours);
	}
}
