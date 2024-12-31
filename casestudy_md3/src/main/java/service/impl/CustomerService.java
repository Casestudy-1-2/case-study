package service.impl;

import dto.CustomerDTO;
import entity.Customer;
import repository.CustomerRepository;
import service.ICustomerService;

import java.util.List;


public class CustomerService implements ICustomerService {
    private static CustomerRepository customerRepository = new CustomerRepository();


    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);

    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);

    }

    @Override
    public Customer getById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<CustomerDTO> getAllDTO() {
        return customerRepository.getAllDTO();
    }
}