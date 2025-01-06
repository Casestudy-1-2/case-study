package service.impl;

import dto.PurchaseDTO;
import model.Purchase;
import repository.PurchaseRepository;
import service.IPurchaseService;

import java.util.List;

public class PurchaseService implements IPurchaseService {
    private static PurchaseRepository purchaseRepository = new PurchaseRepository();

    @Override
    public List<PurchaseDTO> getAllDTO() {
        return purchaseRepository.getAllDTO();
    }

    @Override
    public List<PurchaseDTO> searchByCustomerName(String customerName) {
        return purchaseRepository.searchByCustomerName(customerName);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    @Override
    public void add(Purchase purchase) {
        purchaseRepository.add(purchase);

    }

    @Override
    public void update(Purchase purchase) {
        purchaseRepository.update(purchase);

    }

    @Override
    public void delete(int id) {
        purchaseRepository.delete(id);

    }

    @Override
    public Purchase getById(int purchaseId) {
        return purchaseRepository.getById(purchaseId);
    }
}
