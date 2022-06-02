package postoffice;

public class TypePostItem {

    private int id;
    private String typeName;

    public TypePostItem(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }
    public TypePostItem(String typeName){
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }
}
