package postoffice.database;

import postoffice.Transport;

import java.util.List;

public interface TransportDAO {
    List<Transport> getAllTransport();
    Transport getTransportById(int id);
    void save(Transport transport);
}
