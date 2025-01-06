package repository;

import model.GymCard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymCardRepository {
    public List<GymCard> getAll() {
        List<GymCard> gymCards = new ArrayList<GymCard>();
        try {
            PreparedStatement statement = BaseRepository.getConnection()
                    .prepareStatement("SELECT card_id, card_name, card_price FROM gym_cards");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int cardId = resultSet.getInt("card_id");
                String cardName = resultSet.getString("card_name");
                double cardPrice = resultSet.getDouble("card_price");

                gymCards.add(new GymCard(cardId, cardName, cardPrice));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gymCards;
    }

}
