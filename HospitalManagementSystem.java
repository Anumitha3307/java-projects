package minor2;
import java.util.*;

class Patient {
    String name;
    int age;
    String disease;

    public Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return name + " (" + age + " yrs, " + disease + ")";
    }
}

public class HospitalManagementSystem {
    LinkedList<Patient> waitingList = new LinkedList<>(); // FIFO for waiting
    Vector<Patient> dischargedPatients = new Vector<>();  // Discharged records
    Stack<Patient> undoStack = new Stack<>();             // Undo last patient

    // Add new patient
    public void addPatient(String name, int age, String disease) {
        Patient patient = new Patient(name, age, disease);
        waitingList.addLast(patient);
        undoStack.push(patient);
        System.out.println(patient.name + " added to waiting list.");
    }

    // Treat next patient
    public void treatNextPatient() {
        if (!waitingList.isEmpty()) {
            Patient treated = waitingList.removeFirst();
            dischargedPatients.add(treated);
            System.out.println(treated.name + " treated and discharged.");
        } else {
            System.out.println("No patients in waiting list!");
        }
    }

    // Display discharged patients
    public void displayDischargedPatients() {
        System.out.println("\nDischarged Patients:");
        for (Patient p : dischargedPatients) {
            System.out.println(p);
        }
    }

    // Undo last added patient
    public void undoLastAddedPatient() {
        if (!undoStack.isEmpty()) {
            Patient lastAdded = undoStack.pop();
            waitingList.remove(lastAdded);
            System.out.println("Undo successful. Removed: " + lastAdded.name);
        } else {
            System.out.println("No patient to undo.");
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();

        // Adding patients
        hms.addPatient("Alice", 30, "Fever");
        hms.addPatient("Bob", 45, "Fracture");
        hms.addPatient("Charlie", 28, "Cold");

        System.out.println("\nTreating patients:");
        hms.treatNextPatient(); // Alice treated
        hms.treatNextPatient(); // Bob treated

        hms.displayDischargedPatients();

        System.out.println("\nUndo last added patient:");
        hms.undoLastAddedPatient(); // Undo Charlie

        System.out.println("\nRemaining patients in waiting list:");
        for (Patient p : hms.waitingList) {
            System.out.println(p);
        }
    }
}

