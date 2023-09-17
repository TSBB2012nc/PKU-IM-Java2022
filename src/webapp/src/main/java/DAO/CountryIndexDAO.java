package DAO;

import Enitiy.CountryIndex;

import java.util.List;

public interface CountryIndexDAO {
    // 查询所有国家的指标
    List<CountryIndex> getAllCountryIndex();

    // 添加国家指标
    int addCountryIndex(String COUNTRY, float D11, float D111, float D112, float D12, float D121, float D122, String YEAR);

    // 修改国家指标
    int updateCountryIndex(String COUNTRY, float D11, float D111, float D112, float D12, float D121, float D122, String YEAR);

    // 删除国家指标
    int delCountryIndex(String country, String year);

}
