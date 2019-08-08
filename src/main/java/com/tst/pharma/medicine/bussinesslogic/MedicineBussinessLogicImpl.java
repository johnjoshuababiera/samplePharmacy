package com.tst.pharma.medicine.bussinesslogic;

import com.tst.pharma.medicine.dao.Medicine;
import com.tst.pharma.medicine.dao.MedicineDao;
import com.tst.pharma.medicine.dao.MedicineDaoImpl;

import java.util.Date;
import java.util.List;

public class MedicineBussinessLogicImpl implements MedicineBussinessLogic {

    private MedicineDao medicineDao;

    public MedicineBussinessLogicImpl() {
        this.medicineDao = new MedicineDaoImpl();
    }

    @Override
    public Medicine create(Medicine medicine) throws Exception {
        if(hasDuplicate(medicine.getName(), medicine.getBrand())){
            throw new Exception("Medicine already exists!");
        }
        return medicineDao.add(medicine);
    }

    public Medicine addToStocks(int id, int amount) {
        Medicine medicine = medicineDao.findById(id);
        medicine.setStocks(medicine.getStocks() + amount);
        return medicineDao.update(medicine);
    }


    @Override
    public List<Medicine> findAll() {
        return medicineDao.findAll();
    }

    @Override
    public List<Medicine> findEmptyStocks() {
        return medicineDao.findEmptyStocks();
    }


    private boolean hasDuplicate(String name, String brand) {
        Medicine medicine = medicineDao.findByNameAndBrand(name, brand);
        return medicine !=null;
    }
}
