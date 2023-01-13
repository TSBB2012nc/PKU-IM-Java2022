package Impl;

import Enitiy.CountryIndex;
import DAO.CountryIndexDAO;
import Util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CountryIndexImpl implements CountryIndexDAO {
    QueryRunner qr = new QueryRunner();
    @Override
    public List<CountryIndex> getAllCountryIndex() {
        List<CountryIndex> list = null;
        String sql = "select * from `java-2022`.`index`" ;
        try {
            list = qr.query(Util.DBUtil.connect(),sql,new BeanListHandler<>(CountryIndex.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int addCountryIndex(CountryIndex ci) {
        int row = 0 ;
        String sql = "INSERT INTO `java-2022`.`index` VALUES (?,?,?,?,?,?,?,?)";
        try {
            row = qr.update(DBUtil.connect(), sql, ci.getCOUNTRY(), ci.getD11(), ci.getD111(), ci.getD112(), ci.getD12(), ci.getD121(),ci.getD122(), ci.getYEAR());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int updateCountryIndex(CountryIndex ci) {
        int row = 0 ;
        String sql = "UPDATE `java-2022`.`index` SET D11 = ? , D111 = ? , D112 = ?, D12 = ?, D121 = ?, D122 = ? WHERE COUNTRY = ? AND `YEAR` = ?";
        try {
            row = qr.update(DBUtil.connect(), sql, ci.getD11(), ci.getD111(), ci.getD112(),ci.getD12(), ci.getD121(), ci.getD122(), ci.getCOUNTRY(), ci.getYEAR());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row ;
    }

    @Override
    public int delCountryIndex(String country, String year) {
        int row = 0;
        String sql = "DELETE FROM `java-2022`.`index` WHERE COUNTRY = ? AND `YEAR` = ?";
        try {
            row = qr.update(DBUtil.connect(), sql, country, year);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
