package postoffice;

import java.sql.Date;
import java.time.LocalDate;

public class PostItem {
    protected int idPostItem;
    protected Date departureDate;
    protected Date arrivalDate;
    protected int weight;
    protected int price;
    protected  int idRecipient;
    protected  int idSender;
    protected int typePostitemId;
    protected NumberPostoffice numberPostoffice;

    public PostItem(int idPostItem, Date departureDate, Date arrivalDate, int weight, int price, int idRecipient, int idSender, int typePostitemId, NumberPostoffice numberPostoffice){
        this.idPostItem = idPostItem;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.price = price;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.typePostitemId = typePostitemId;
        this.numberPostoffice = numberPostoffice;
    }
    public PostItem(Date departureDate, Date arrivalDate, int weight, int price, int idRecipient, int idSender, int typePostitemId){
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.price = price;
        this.idRecipient = idRecipient;
        this.idSender = idSender;
        this.typePostitemId = typePostitemId;
    }

    public int getIdPostItem() {
        return idPostItem;
    }

    public void setIdPostItem(int idPostItem) {
        this.idPostItem = idPostItem;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
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

    public NumberPostoffice getNumberPostoffice() {
        return numberPostoffice;
    }

    public void setNumberPostoffice(NumberPostoffice numberPostoffice) {
        this.numberPostoffice = numberPostoffice;
    }

    public void printItemInformation(){
        System.out.println(getIdPostItem() + " " + getDepartureDate() + " " + getArrivalDate() + " " + getWeight() + " " + getPrice() + " " + getIdRecipient() + " " + getIdSender() + " " + getTypePostitemId() + " " + getNumberPostoffice());
    }
}
