package com.tst;

import com.tst.pharma.medicine.bussinesslogic.MedicineBussinessLogic;
import com.tst.pharma.medicine.bussinesslogic.MedicineBussinessLogicImpl;
import com.tst.pharma.medicine.dao.Medicine;

import java.util.List;

public class PharmaMain {
    public static void main(String[] args) {
        MedicineBussinessLogic medicineBussinessLogic = new MedicineBussinessLogicImpl();

        Medicine medicine = new Medicine();
        medicine.setName("Test");
        medicine.setBrand("Test");
        medicine.setStocks(5);
        try {
            medicineBussinessLogic.create(medicine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Medicine medicine2 = new Medicine();
        medicine2.setName("A");
        medicine2.setBrand("A");
        try {
            medicineBussinessLogic.create(medicine2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Medicine medicine3 = new Medicine();
        medicine3.setName("A");
        medicine3.setBrand("A");
        try {
            medicineBussinessLogic.create(medicine3); // throw exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        List<Medicine> medicineList = medicineBussinessLogic.findAll(); //2
        List<Medicine> emptyStocks = medicineBussinessLogic.findEmptyStocks(); //1

        medicineBussinessLogic.addToStocks(emptyStocks.get(0).getId(), 5);

        medicineList = medicineBussinessLogic.findAll(); //2

    }
}
