import java.util.LinkedList;

public class Input_tool {
    public static void main(String [] args){
        LinkedList<General_person_info> person = new LinkedList<>();
        person.add(new Customer("Dmytro", "Yavchenko", 16, "gaming console", "young"));
        person.add(new Customer("Zahar", "Olchin", 25, "laptop", "mature"));
        person.add(new Customer("Volodymir", "Oliv", 63, "phone", "old"));
        person.add(new Seller("Oleh", "Petriuk", 35, "phones"));
        for (General_person_info person_info : person){
            person_info.display();
        }
    }
}