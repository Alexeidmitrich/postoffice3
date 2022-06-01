package postoffice.database;

import postoffice.Address;

import java.util.List;

public interface AddressDAO {

    List<Address> getAllAddress ();

    Address getAddressById(int id);

    void  save (Address address);
}
