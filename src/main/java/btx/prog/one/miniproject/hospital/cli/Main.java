package btx.prog.one.miniproject.hospital.cli;

import btx.prog.one.miniproject.hospital.domain.Patient;
import btx.prog.one.miniproject.hospital.service.Dispomanager;

import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    private static Dispomanager dispomanager = new Dispomanager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean finished = false;

        while (!finished){
            int cmdNo = askUser();

            switch (cmdNo){
                case 0 -> finished = true;
                case 1 -> registerNewPatient();
                case 2 -> listAllPatients();
                case 3 -> searchPatient();
                case 4 -> dischargePatient();
                default -> System.out.println("Ungülltiger Input");
            }
        }
        System.out.println("Auf Wiedersehen");

    }

    private static void dischargePatient() {
        System.out.println("Patienten ID:");
        Long id = scanner.nextLong();
        System.out.println(dispomanager.searchForPatient(id) +", Discharged");
        dispomanager.discharge((Patient) dispomanager.searchForPatient(id),"Patient Discharged");
    }

    private static void searchPatient() {
        System.out.println("Patienten ID:");
        Long id = scanner.nextLong();
        System.out.println(dispomanager.searchForPatient(id));
    }

    private static void listAllPatients() {
        System.out.println(dispomanager.searchAll());
    }

    private static void registerNewPatient() {
        System.out.println("Vorname Eingeben:");
        String firstname = scanner.nextLine();
        System.out.println("Nachname Eingeben:");
        String lastname = scanner.nextLine();
        Main.dispomanager.registerPatient(lastname,firstname);
    }

    private static int askUser() {
        listCommands();
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        return res;
    }

    private static void listCommands() {
        System.out.println("Mögliche Befehle:");
        System.out.println("0, Exit");
        System.out.println("1, Neue/r Patient*in:");
        System.out.println("2, List all patients");
        System.out.println("3, Search for Patient");
        System.out.println("3, Discharge Patient");
    }
}
