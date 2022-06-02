package postoffice;

public class Address {
    protected int idAddress;
    protected String city;
    protected String street;
    protected String house;
    protected String bilding;
    protected String flat;
    protected String phone;
    protected int idClient;

    public  Address(int idAddress, String city, String street, String house, String bilding, String flat, String phone, int idClient){
        this.idAddress = idAddress;
        this.city = city;
        this.street = street;
        this.house = house;
        this.bilding = bilding;
        this.flat = flat;
        this.phone = phone;
        this.idClient = idClient;
    }
    public Address(String city, String street, String house, String bilding, String flat, String phone, int idClient){
        this.city = city;
        this.street = street;
        this.house = house;
        this.bilding = bilding;
        this.flat = flat;
        this.phone = phone;
        this.idClient = idClient;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBilding() {
        return bilding;
    }

    public void setBilding(String bilding) {
        this.bilding = bilding;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public void printInformationAddress(){
        System.out.println(getIdAddress() + " " + getCity() + " " + getStreet() + " " + getHouse() + " " + getBilding() + " " + getFlat() + " " + getPhone() + " " + getIdClient());
    }
}
