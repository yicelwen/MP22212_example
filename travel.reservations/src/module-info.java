// Service Locator
module travel.reservations {
	requires travel.api;
	exports travel.reservations;
	
	uses travel.api.Tour;
}