package service;

import dto.CustomerDTO;
import model.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    List<CustomerDTO> getAllDTO();
}
