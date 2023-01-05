public class Seller extends General_person_info{
    private String Device;

    public Seller(String Name, String Surname, int Age, String Device) {
        super(Name, Surname, Age);
        this.Device = Device;
    }

    
    public void display() {
        super.display();
        System.out.println(" a seller of " + Device);
    }
}