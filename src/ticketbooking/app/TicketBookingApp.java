package ticketbooking.app;

import ticketbooking.io.FileIO;

public class TicketBookingApp {

	public static void main(String[] args) {
		int dataLines = FileIO.countDataLines("events.csv");
		for (int index = 0; index <(dataLines-1); index++) {
			System.out.println(FileIO.loadEvents("events.csv")[index].toString());

		}
	}
}
