package postoffice;

public class Transport {

    private int id;
    private String type;
    private int idPostitem;
    public Transport(int id, String type, int idPostitem){
        this.id = id;
        this.type = type;
        this.idPostitem = idPostitem;
    }
    public Transport(String type, int idPostitem){
        this.type = type;
        this.idPostitem = idPostitem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdPostitem() {
        return idPostitem;
    }

    public void setIdPostitem(int idPostitem) {
        this.idPostitem = idPostitem;
    }

    public void printInformationTransport(){
        System.out.println(getId() + " " + getType() + " " + getIdPostitem());
    }
}
