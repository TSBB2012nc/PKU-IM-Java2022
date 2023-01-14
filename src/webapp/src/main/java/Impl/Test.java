package Impl;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CountryIndexDAO ciDao = new CountryIndexImpl();
        List<CountryIndex> ciList = ciDao.getAllCountryIndex();
        System.out.println(ciList);
    }
}
