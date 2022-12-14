// Consumer 2
// Combine travel.buyer (Consumer 1) & travel.reservations (Service Locator)
module travel.buyer2 {
	requires travel.api;
	
	uses travel.api.Tour;
}