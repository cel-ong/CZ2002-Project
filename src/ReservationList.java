import javax.swing.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import static java.util.concurrent.TimeUnit.*;
import java.time.temporal.ChronoUnit;

public class ReservationList {

	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();

	public ReservationList() {

	}

	public void createReservation(Reservation reservation) {
		reservationList.add(reservation);
	}

	/////////////Moved to another class to check//////////////////////////

	public void removeExpired() {		//if they miss their reservation for more than 1 hr
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).isExpired()){
				reservationList.remove(i);
			}
		}
	}

	public int checkCurrentReserved(int[] tableArray) {
		for (int i = 0; i < tableArray.length; i++){
			for (int j = 0; j < reservationList.size(); j++) {
				if (reservationList.get(j).getTableNum() == tableArray[i]) {
					if (reservationList.get(j).getDate().toEpochMilli() - Instant.now().toEpochMilli() > 3600000){
						return tableArray[i];
					}
				}
			}
		}
		return -1;
	}

	public int checkUpcomingReserved(int[] tableArray, Reservation newReserve) {
		int i = 0;
		while (i < tableArray.length) {
			for (int j = 0; j < reservationList.size(); i++) {
				if (reservationList.get(i).getTableNum() == tableArray[i] && reservationList.get(i).getDate().toEpochMilli() - newReserve.getDate().toEpochMilli() >  3600000 ) {
					return tableArray[i];
				}
			}
			i++;
		}
		return -1;
	}

	public void removeReservation(int phoneNum) {
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getPhoneNum() == phoneNum) {
				reservationList.remove(i);
				System.out.println("Reservation removed");
				return;
			}
		}

		System.out.println("Reservation not found");
	}

	public void checkReservation(int phoneNum) {
		for (int i = 0; i < reservationList.size(); i++) {
			if (reservationList.get(i).getPhoneNum() == phoneNum) {
				System.out.println("Reservation Found " + reservationList.get(i).getDate());
				return;
			}
		}

		System.out.println("Not found");
		return;
	}

	public void printReservation() {
		for (int i = 0; i < reservationList.size(); i++) {
			System.out.println(reservationList.get(i).getPhoneNum() + " " +
					reservationList.get(i).getDate() + " " +
					reservationList.get(i).getPax());
		}
	}

	public void arrivedForReservation() {
		// TODO - when customer shows up on time for reservation, remove booking from arraylist?
	}

}