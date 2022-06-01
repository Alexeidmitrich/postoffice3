package postoffice;

public class NumberPostoffice {
    private int id;
    private String city;

    public NumberPostoffice(int id, String city){
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void printNumberPostoffice(){
        System.out.println(getId() + " " + getCity());
    }
}
