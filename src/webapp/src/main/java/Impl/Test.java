package Impl;

import DAO.CountryIndexDAO;
import Enitiy.CountryIndex;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String Country = "埃及";
        String YEAR = "1999";
        float D11 = 0;
        float D111 = 0;
        float D112 = 0;
        float D12 = 0;
        float D121 = 0;
        float D122 = 0;
        CountryIndexDAO ciDao = new CountryIndexImpl();
        ciDao.addCountryIndex(Country,  D11, D111, D112, D12, D121, D122, YEAR);
    }
}
