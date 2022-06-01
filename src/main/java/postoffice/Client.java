package postoffice;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    NumberPostoffice numberPostoffice;

    public Client(int id, String firstName, String lastName,NumberPostoffice numberPostoffice) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPostoffice = numberPostoffice;
    }
    public Client(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NumberPostoffice getNumberPostoffice() {
        return numberPostoffice;
    }

    public void setNumberPostoffice(NumberPostoffice numberPostoffice) {
        this.numberPostoffice = numberPostoffice;
    }

    public void printInformation(){
        System.out.println(getId() + " " + getFirstName() + " " + getLastName() + " " + getNumberPostoffice());
    }
}

