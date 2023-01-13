package DAO;

import Enitiy.CountryIndex;

import java.util.List;

public interface CountryIndexDAO {
    // 查询所有国家的指标
    List<CountryIndex> getAllCountryIndex();

    // 添加国家指标
    int addCountryIndex(CountryIndex ci);

    // 修改国家指标
    int updateCountryIndex(CountryIndex ci);

    // 删除国家指标
    int delCountryIndex(String country, String year);
}
