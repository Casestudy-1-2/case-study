package repository;

import dto.PurchaseDTO;
import model.Purchase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseRepository {
    public List<Purchase> getAll() {
        return null;
    }

    public List<PurchaseDTO> getAllDTO() {
        List<PurchaseDTO> purchases = new ArrayList<>();
        String sql = "SELECT p.purchase_id, c.customer_name, g.card_name, p.purchase_date, p.total_price, p.valid_until " +
                "FROM purchases p " +
                "JOIN customers c ON p.customer_id = c.customer_id " +
                "JOIN gym_cards g ON p.card_id = g.card_id";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int purchase_id = resultSet.getInt("purchase_id");
                String customerName = resultSet.getString("customer_name");
                String cardName = resultSet.getString("card_name");
                String date = resultSet.getString("purchase_date");
                Date purchaseDate = Date.valueOf(date);
                double totalPrice = resultSet.getDouble("total_price");
                String validUntilStr = resultSet.getString("valid_until");
                Date validUntil = Date.valueOf(validUntilStr);
                purchases.add(new PurchaseDTO(purchase_id, customerName, cardName, purchaseDate, totalPrice, validUntil));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchases;
    }

    public void add(Purchase purchase) {
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("INSERT INTO purchases (customer_id, card_id, purchase_date, total_price, valid_until) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, purchase.getCustomerId());
            statement.setInt(2, purchase.getCardId());
            statement.setDate(3, purchase.getPurchaseDate());
            statement.setDouble(4, purchase.getTotalPrice());
            statement.setDate(5, purchase.getValidUntil());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Purchase purchase) {
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("UPDATE purchases SET customer_id = ?, card_id = ?, purchase_date = ?, total_price = ?, valid_until = ? WHERE purchase_id = ?")) {
            statement.setInt(1, purchase.getCustomerId());
            statement.setInt(2, purchase.getCardId());
            statement.setDate(3, purchase.getPurchaseDate());
            statement.setDouble(4, purchase.getTotalPrice());
            statement.setDate(5, purchase.getValidUntil());
            statement.setInt(6, purchase.getPurchaseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Purchase getById(int purchaseId) {
        Purchase purchase = null;
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("SELECT p.purchase_id, p.customer_id, p.card_id, p.purchase_date, p.total_price, p.valid_until " +
                        "FROM purchases p WHERE p.purchase_id = ?")) {
            statement.setInt(1, purchaseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int cardId = resultSet.getInt("card_id");
                Date purchaseDate = resultSet.getDate("purchase_date");
                double totalPrice = resultSet.getDouble("total_price");
                Date validUntil = resultSet.getDate("valid_until");
                purchase = new Purchase(purchaseId, customerId, cardId, purchaseDate, totalPrice, validUntil);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchase;
    }

    public void delete(int id) {
        try (PreparedStatement statement = BaseRepository.getConnection().
                prepareStatement("delete from purchases where purchase_id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<PurchaseDTO> searchByCustomerName(String searchName) {
        List<PurchaseDTO> purchases = new ArrayList<>();
        String query = "SELECT p.purchase_id, p.customer_id, p.card_id, p.purchase_date, p.total_price, p.valid_until, c.customer_name, g.card_name " +
                "FROM purchases p " +
                "JOIN customers c ON p.customer_id = c.customer_id " +
                "JOIN gym_cards g ON p.card_id = g.card_id " +
                "WHERE c.customer_name LIKE ?";
        try (PreparedStatement statement = BaseRepository.getConnection().prepareStatement(query)) {
            statement.setString(1, "%" + searchName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int purchaseId = resultSet.getInt("purchase_id");
                String customerName = resultSet.getString("customer_name");
                String cardName = resultSet.getString("card_name");
                String date = resultSet.getString("purchase_date");
                Date purchaseDate = Date.valueOf(date);
                double totalPrice = resultSet.getDouble("total_price");
                String validUntilStr = resultSet.getString("valid_until");
                Date validUntil = Date.valueOf(validUntilStr);
                purchases.add(new PurchaseDTO(purchaseId, customerName, cardName, purchaseDate, totalPrice, validUntil));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return purchases;
    }

}
