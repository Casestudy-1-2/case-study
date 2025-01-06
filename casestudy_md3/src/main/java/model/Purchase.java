package model;

import java.sql.Date;

public class Purchase {
    private int purchaseId;
    private int customerId;
    private int cardId;
    private Date purchaseDate;
    private double totalPrice;
    private Date validUntil;
    public Purchase(int purchaseId, int customerId, int cardId, Date purchaseDate, double totalPrice, Date validUntil) {
        this.purchaseId = purchaseId;
        this.customerId = customerId;
        this.cardId = cardId;
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
        this.validUntil = validUntil;
    }

    public Purchase(int customerId, int carId, String purchaseDate, double totalPrice, String validUntil) {
        this.customerId = customerId;
        this.cardId = carId;
        this.purchaseDate = Date.valueOf(purchaseDate);
        this.totalPrice = totalPrice;
        this.validUntil = Date.valueOf(validUntil);
    }

    public int getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Date getValidUntil() {
        return validUntil;
    }
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

}
