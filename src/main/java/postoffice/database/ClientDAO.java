package postoffice.database;

import postoffice.Client;

import java.util.List;

public interface ClientDAO {

    List<Client> getAllClient();


    Client getClientById(int id);

    Client getClientName(String firstname, String lastname);

    void save(Client client, int postofficeId);
}
