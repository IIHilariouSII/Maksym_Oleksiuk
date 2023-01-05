public class General_person_info {
    private int Age;
    private String Name;
    private String Surname;
    public General_person_info(String Name, String Surname, int Age){
        this.Name = Name;
        this.Surname = Surname;
        this.Age = Age;
    }
    public void display(){
        System.out.print(Name + " " + Surname + " age " + Age + ": ");
    }

}