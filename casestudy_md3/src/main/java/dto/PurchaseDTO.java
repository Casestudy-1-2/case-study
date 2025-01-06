package dto;

import java.sql.Date;

public class PurchaseDTO {
    private int purchaseId;
    private String customerName;
    private String cardName;
    private Date purchaseDate;
    private double totalPrice;
    private Date validUntil;
    public PurchaseDTO() {

    }
    public PurchaseDTO(int purchaseId, String customerName, String cardName, Date purchaseDate, double totalPrice, Date validUntil) {
        this.purchaseId = purchaseId;
        this.customerName = customerName;
        this.cardName = cardName;
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;
        this.validUntil = validUntil;
    }
    public int getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
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
