public class FootballTester {
    public static void main(String[] args) { // Driver code
        Striker ronaldo = new Striker("Ronaldo", 39, 90, 901, 1000);
        Defender ramos = new Defender("Ramos", 38, 85, 1000, 100);

        System.out.println("1========");
        ronaldo.display();
        System.out.println("2========");
        ronaldo.calculatePerformance();
        System.out.println("3========");
        ramos.display();
        System.out.println("4========");
        ramos.calculatePerformance();
    }
}

// class starts here

class Football { // Parent code
    public String name;
    public int age;
    public int stamina;

    public Football(String name, int age, int stamina) {
        this.name = name;
        this.age = age;
        this.stamina = stamina;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Stamina: " + stamina);
    }

    public void calculatePerformance() {
        System.out.println("Performance is not defined yet");
    }
}

class Striker extends Football { // Child class
    public int goals;
    public int shot_on_target;
    public double performance;

    public Striker(String name, int age, int stamina, int goals, int shots) {
        super(name, age, stamina);
        this.goals = goals;
        this.shot_on_target = shots;
    }

    public void calculatePerformance() {
        performance = (double) goals / shot_on_target;
        System.out.println("Performance: " + performance);
    }

    public void display() {
        super.display();
        System.out.println("Goals: " + goals);
        System.out.println("Shots on target: " + shot_on_target);
    }
}

class Defender extends Football { // Child class
    public int tackles;
    public int interceptions;
    public double performance;

    public Defender(String name, int age, int stamina, int tackles, int interceptions) {
        super(name, age, stamina);
        this.tackles = tackles;
        this.interceptions = interceptions;
    }

    public void calculatePerformance() {
        performance = (double) interceptions / tackles;
        System.out.println("Performance: " + performance);
    }

    public void display() {
        super.display();
        System.out.println("Tackles: " + tackles);
        System.out.println("Interceptions: " + interceptions);
    }

}