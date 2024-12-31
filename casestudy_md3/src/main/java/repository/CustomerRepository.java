package repository;

import dto.CustomerDTO;
import entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("select * from customers" );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int idClass = resultSet.getInt("class_id");
//                customers.add(new Customer(id, name, age, phone, email, idClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public List<CustomerDTO> getAllDTO(){
        List<CustomerDTO> customers = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("SELECT c.customer_id, c.customer_name, c.age, c.phone, c.email, g.class_name " +
                    "FROM customers c " +
                    "LEFT JOIN enrollments e ON c.customer_id = e.customer_id " +
                    "LEFT JOIN gym_classes g ON e.class_id = g.class_id" );
                ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String className = resultSet.getString("class_name");
                customers.add(new CustomerDTO(id, name, age, phone, email, className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void add(Customer customer) {
        String sql = "INSERT INTO customers (customer_name, age, phone, email, class_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql)) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getEmail());
            statement.setInt(5, customer.getIdClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Customer customer) {
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("update customers set customer_name = ?, age = ?, phone = ?, email = ? where customer_id = ?")) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getEmail());
            statement.setInt(5, customer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("delete from customers where customer_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getById(int id) {
        Customer customer = null;
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("select * from customers where customer_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("customer_name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int idClass = resultSet.getInt("class_id");
                return new Customer(id, name, age, phone, email, idClass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
