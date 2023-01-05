public class Customer extends General_person_info {
    private String Preferred_device;
    private String Age_group;

    public Customer(String Name, String Surname, int Age, String Preferred_device, String Age_group) {
        super(Name, Surname, Age);
        this.Preferred_device = Preferred_device;
        this.Age_group = Age_group;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" a customer who likes " + Preferred_device + " and belongs to a " + Age_group + " age group");
    }
}