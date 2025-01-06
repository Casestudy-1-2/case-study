package service;

import dto.PurchaseDTO;
import model.Purchase;

import java.util.List;

public interface IPurchaseService extends IService<Purchase> {
    List<PurchaseDTO> getAllDTO();

    List<PurchaseDTO> searchByCustomerName(String search);
}
