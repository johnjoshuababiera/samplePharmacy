package com.tst.pharma.medicine.dao;

import java.util.Date;
import java.util.List;

public interface MedicineDao {
    Medicine add(Medicine medicine);
    Medicine update(Medicine medicine);
    Medicine findByNameAndBrand(String name, String brand);
    Medicine findById(int id);
    List<Medicine> findAll();
    List<Medicine> findEmptyStocks();
}
