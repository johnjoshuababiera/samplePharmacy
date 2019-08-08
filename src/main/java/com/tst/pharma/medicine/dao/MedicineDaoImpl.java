package com.tst.pharma.medicine.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

    private static List<Medicine> medicines = new ArrayList<>();

    public Medicine add(Medicine medicine) {
        medicine.setId(medicines.size()+1);
        medicines.add(medicine);
        return medicine;
    }

    @Override
    public Medicine update(Medicine medicine) {
        for (Medicine savedMedicine : medicines) {
            if(medicine.getId() == medicine.getId()){
                savedMedicine = medicine;
                return savedMedicine;
            }
        }
        return null;
    }

    @Override
    public Medicine findByNameAndBrand(String name, String brand) {
        for (Medicine medicine : medicines) {
            if(medicine.getName().equalsIgnoreCase(name)
                    && medicine.getBrand().equalsIgnoreCase(brand)){
                return medicine;
            }
        }
        return null;
    }

    @Override
    public Medicine findById(int id) {
        for (Medicine medicine : medicines) {
            if(medicine.getId() == id){
                return medicine;
            }
        }
        return null;
    }

    public List<Medicine> findAll() {
        return medicines;
    }

    public List<Medicine> findEmptyStocks() {
        List<Medicine> emptyStocks = new ArrayList<>();
        for (Medicine medicine : medicines) {
            if(medicine.getStocks() == 0){
                emptyStocks.add(medicine);
            }
        }
        return emptyStocks;
    }
}
