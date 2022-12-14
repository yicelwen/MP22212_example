module travel.mix {
	requires travel.api;

	uses travel.api.Tour;

	provides travel.api.Tour with travel.mix.TourImpl2;
}