/*Observe the following Tester class and outputs to design both the Patient class and InPatient class with appropriate elements. */

public class PatientTester { // Driver code
    public static void main(String[] args) {
        Patient p1 = new Patient("Robert", "Dr. Thomas");
        System.out.println(p1);
        System.out.println("1.................");
        Patient.details();
        System.out.println("2.................");
        InPatient p2 = new InPatient("Christina", "Dr. Alex", "Oncology");
        System.out.println(p2);
        System.out.println("3.................");
        InPatient.details();
        System.out.println("4.................");
        Patient p3 = new InPatient("Sofia", "Dr. Brawn", "Pediatrics");
        Patient p4 = new Patient("Patrick", "Dr. Alex");
        Patient.details();
        System.out.println("5.................");
        Patient[] allPatients = { p1, p2, p3, p4 };
        Patient.details(allPatients);
    }
}

// Class starts here

class Patient { // Parent class
    public String name;
    public String doc;
    public int id;

    public static int id_count;
    public static int total_patients;
    public static int total_inpatients;

    public Patient(String name, String doc) {
        this.name = name;
        this.doc = doc;
        total_patients++;
        id_count++;
        id = id_count;

    }

    public String toString() {
        return "Patient ID: P0" + id + ", Name: " + name + "\nDoctor: " + doc;
    }

    public static void details() {
        System.out.println("Total patients: " + total_patients);
    }

    public static void details(Patient[] patients) {
        System.out.println("Details of " + patients.length + " selected patients: ");
        for (int i = 0; i < patients.length; i++) {
            System.out.println("== == == == ==");
            System.out.println(patients[i]);
        }
    }

}

class InPatient extends Patient { // Child class
    public String department;
    public static int total_inpatients;

    public InPatient(String name, String doc, String dept) {
        super(name, doc);
        this.department = dept;
        total_inpatients++;
        System.out.println("New patient admitted in " + dept);
    }

    public String toString() {
        return super.toString() + "\nDepartment: " + department;
    }

    public static void details() {
        System.out.println("Total Patients: " + total_patients);
        System.out.println("Admitted In-Patients: " + total_inpatients);
        System.out.println("Out_Patients: " + (total_patients - total_inpatients));
    }
}
