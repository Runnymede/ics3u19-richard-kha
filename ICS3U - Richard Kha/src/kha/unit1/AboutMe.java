package kha.unit1;
/**
 * AboutMe.java
 * This program tells you information related to its author, and includes a 
 * phrase which encourages his school team
 * @author Richard Kha
 */
public class AboutMe {
	/**
	 * This is the entry point to the program
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Richard Kha");
		System.out.println("Christina Kemp");
		System.out.println("Runnymede C.I\n");
		System.out.println("\"Go ravens\"\n\n\n");

		System.out.printf("%-16s%-30s%-15s\n", "Printed:","2019 AUG 30 08:05","Student Timetable");
		System.out.printf("%70s\n", "Runnymede Collegiate Institute");
		System.out.printf("%-20s%-17s%-17s%-17s%-11s%-13s\n", "Name","Student No","OEN","Homeroom","Grade","Track");
		System.out.printf("%-20s%-17s%-17s%-17s%-11s%-13s\n", "KHA,RICHARD","333-599-769","708-778-956","11E","11","Regular");
		System.out.printf("%92s\n\n\n", "Locker No.");

		System.out.printf("%45s%20s%20s\n", "School Year 20192020","Semester 1","Term 1");
		System.out.printf("%-16s%-15s%-15s\n", "Period","Day 1","Day 2");
		System.out.printf("%-16s%-15s%-15s\n", "1","FSF3/4U1-01","FSF3/4U1-01");
		System.out.printf("%-16s%-15s%-15s\n", "08:45","Tenenbaum,R","Tenenbaum,R");
		System.out.printf("%-16s%-15s%-15s\n\n", "10:02","202","202");

		System.out.printf("%-16s%-15s%-15s\n", "2","AMQ3/4M1-01","AMQ3/4M1-01");
		System.out.printf("%-16s%-15s%-15s\n", "10:07","Bylykbashi,J","Bylykbashi,J");
		System.out.printf("%-16s%-15s%-15s\n\n", "11:24","117","117");
		System.out.printf("%-16s\n", "Lunch");
		System.out.printf("%-16s\n", "11:24");
		System.out.printf("%-16s\n\n", "12:26");

		System.out.printf("%-16s%-15s%-15s\n", "3","ICS3U3-02","ENG3U1-03");
		System.out.printf("%-16s%-15s%-15s\n", "12:26","Kemp,C","Lovell,C");
		System.out.printf("%-16s%-15s%-15s\n\n", "13:43","024","214");

		System.out.printf("%-16s%-15s%-15s\n", "4","ENG3U1-03","ICS3U3-02");
		System.out.printf("%-16s%-15s%-15s\n", "13:38","Lovell,C","Kemp,C");
		System.out.printf("%-16s%-15s%-15s\n\n", "15:05","214","024");

		System.out.printf("%-16s\n", "5");
		System.out.printf("%-16s\n", "15:05");
		System.out.printf("%-16s", "16:22");




	}

}
