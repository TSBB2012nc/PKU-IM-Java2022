package Impl;

import DAO.CountryIndexDAO;

public class Test {
    public static void main(String[] args) {
        CountryIndexDAO ciDao = new CountryIndexImpl();
        System.out.println(ciDao.getAllCountryIndex());
    }
}
