package postoffice;

import postoffice.database.*;

import java.sql.Date;
import java.time.LocalDate;

public class PostofficeRefactoring {

    private DBManager dbManager = new DBManager();
    private  ClientDAO clientDAO = new ClientDAOImpl();
    private PostitemDAO postitemDAO = new PostitemDAOImpl();
    private  TransportDAO transportDAO = new TransportDAOImpl();
    private NumberPostofficeDAO numberPostofficeDAO = new NumberPostofficeDAOImpl();
    private  AddressDAO addressDAO = new AddressDAOImpl();
    private TypePostItemDAO typePostItemDAO = new TypePostItemDAOImpl();

    public  void addClient(String firstName, String lastName, int postOfficeid){
        Client client = new Client(firstName, lastName);
        clientDAO.save(client, postOfficeid);
    }
    public void addTransport(String type, int idPostitem){
        Transport transport = new Transport(type, idPostitem);
        transportDAO.save(transport);
    }
    public void addTypePostitem(String typeName){
        TypePostItem typePostItem = new TypePostItem(typeName);
        typePostItemDAO.save(typePostItem);
    }
    public void  addPostitem(LocalDate departureDate, LocalDate arrivalDate, int weight, int price, int idRecipient, int idSender, String typeName, int postOfficeid){
        TypePostItem typePostItem = typePostItemDAO.getTypeByName(typeName);
        PostItem postItem = new PostItem(departureDate, arrivalDate, weight, price, idRecipient, idSender, typePostItem.getId());
        postitemDAO.save(postItem,postOfficeid);
    }
    public void addNumberPostoffice(String city){
        NumberPostoffice numberPostoffice = new NumberPostoffice(city);
        numberPostofficeDAO.save(numberPostoffice);
    }
    public void addAddress(String city, String street, String house, String bilding, String flat, String phone, int idClient){
        Address address = new Address(city, street, house, bilding, flat, phone, idClient);
        addressDAO.save(address);
    }


}
