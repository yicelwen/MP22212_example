package travel.mix;

import java.util.OptionalInt;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

import travel.api.Tour;

public class TourPriceCheck {
	public static void main(String[] args) {
		OptionalInt max = 
				ServiceLoader.load(Tour.class)
					.stream()
					.map(Provider::get)
					.mapToInt(Tour::price)
					.max();
		max.ifPresent(System.out::println);
		
		OptionalInt min = 
				ServiceLoader.load(Tour.class)
					.stream()
					.map(Provider::get)
					.mapToInt(Tour::price)
					.min();
		min.ifPresent(System.out::println);
	}
}
