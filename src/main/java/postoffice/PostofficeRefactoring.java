package postoffice;

import postoffice.database.*;

import java.sql.Date;

public class PostofficeRefactoring {

    private DBManager dbManager = new DBManager();
    private  ClientDAO clientDAO = new ClientDAOImpl();
    private PostitemDAO postitemDAO = new PostitemDAOImpl();
    private  TransportDAO transportDAO = new TransportDAOImpl();
    private NumberPostofficeDAO numberPostofficeDAO = new NumberPostofficeDAOImpl();
    private  AddressDAO addressDAO = new AddressDAOImpl();

    public  void addClient(String firstName, String lastName, int postOfficeid){
        Client client = new Client(firstName, lastName);
        clientDAO.save(client, postOfficeid);
    }
    public void addTransport(int id, String type, int idPostitem){
        Transport transport = new Transport(id, type, idPostitem);
        transportDAO.save(transport);
    }
    public void  addPostitem(Date departureDate, Date arrivalDate, int weight, int price, int idRecipient, int idSender, int typePostitemId, int postOfficeid){
        PostItem postItem = new PostItem(departureDate, arrivalDate, weight, price, idRecipient, idSender, typePostitemId);
        postitemDAO.save(postItem,postOfficeid);
    }
    public void addNumberPostoffice(int id, String city){
        NumberPostoffice numberPostoffice = new NumberPostoffice(id, city);
        numberPostofficeDAO.save(numberPostoffice);
    }
    public void addAddress(int idAddress, String city, String street, String house, String bilding, String flat, String phone, int idClient){
        Address address = new Address(idAddress, city, street, house, bilding, flat, phone, idClient);
        addressDAO.save(address);
    }


}
