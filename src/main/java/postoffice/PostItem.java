package postoffice;

import java.time.LocalDate;

public class PostItem {
    private  String typePostitem;
    protected int idPostItem;
    protected LocalDate departureDate;
    protected LocalDate arrivalDate;
    protected int weight;
    protected int price;
    protected  int idRecipient;
    protected  int idSender;
    protected int typePostitemId;
    protected int postOfficeId;
    protected Client client;

    public PostItem(int idPostItem, LocalDate departureDate, LocalDate arrivalDate, int weight, int price, int idRecipient, int idSender, int typePostitemId, int postOfficeId){
        this.idPostItem = idPostItem;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.price = price;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.typePostitemId = typePostitemId;
        this.postOfficeId = postOfficeId;
    }
    public PostItem(LocalDate departureDate, LocalDate arrivalDate, int weight, int price, int idRecipient, int idSender, String typePostitem){
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.price = price;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.typePostitem = typePostitem;
    }


    public int getIdPostItem() {
        return idPostItem;
    }

    public void setIdPostItem(int idPostItem) {
        this.idPostItem = idPostItem;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getTypePostitemId() {
        return typePostitemId;
    }

    public void setTypePostitemId(int typePostitemId) {
        this.typePostitemId = typePostitemId;
    }

    public int getPostOfficeId() {
        return postOfficeId;
    }

    public void setPostOfficeId(int postOfficeId) {
        this.postOfficeId = postOfficeId;
    }

    public void printItemInformation(){
        System.out.println(getIdPostItem() + " " + getDepartureDate() + " " + getArrivalDate() + " " + getWeight() + " " + getPrice() + " " + getIdRecipient() + " " + getIdSender() + " " + getTypePostitemId() + " " + getPostOfficeId());
    }


    public String getTypePostitem() {
        return typePostitem;
    }

    public void setTypePostitem(String typePostitem) {
        this.typePostitem = typePostitem;
    }
}
