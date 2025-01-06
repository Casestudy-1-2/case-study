package model;

public class GymCard {
    private int cardId;
    private String cardName;
    private double cardPrice;

    public GymCard(int cardId, String cardName, double cardPrice) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardPrice = cardPrice;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public double getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(double cardPrice) {
        this.cardPrice = cardPrice;
    }
}
