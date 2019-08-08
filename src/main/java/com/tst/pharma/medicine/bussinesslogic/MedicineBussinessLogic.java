package com.tst.pharma.medicine.bussinesslogic;

import com.tst.pharma.medicine.dao.Medicine;

import java.util.Date;
import java.util.List;

public interface MedicineBussinessLogic {
    Medicine create(Medicine medicine) throws Exception;
    Medicine addToStocks(int id, int amount);
    List<Medicine> findAll();
    List<Medicine> findEmptyStocks();

}
