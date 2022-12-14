package travel.buyer;

import java.util.*;
import travel.api.*;

public class TourFinder {
	public static Tour findTour() {
		ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
		for (Tour tour : loader) {
			return tour;
		}
		return null;
	}

	public static List<Tour> findAllTours() {
		List<Tour> tours = new ArrayList<>();
		ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
		for (Tour tour : loader) {
			tours.add(tour);
		}
		return tours;
	}
}
