package kaijia.lucifer.dao.impl;

import kaijia.lucifer.dao.WareHouseDao;
import kaijia.lucifer.model.WareHouse;
import kaijia.lucifer.tool.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/12/15  上午 08:28
 */
public class WareHouseDaoImpl implements WareHouseDao {

    protected final String sql_listWarHouse = "SELECT a.ima01, a.ima02, a.ima021, g.img09, g.img10, g.img02, g.img03 FROM ima_file a, img_file g WHERE a.ima01 = g.img01 AND g.img02 = ? AND g.img03 = ?";
    protected final String sql_YFMZJPA = "SELECT a.ima01, a.ima02, a.ima021, g.img09, g.img10, g.img02, g.img03 FROM ima_file a, img_file g WHERE a.ima01 = g.img01 AND g.img02 = ?";

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    private Logger logger = Logger.getLogger(WareHouseDaoImpl.class);

    @Override
    public List<WareHouse> listWareHouse(String warehouse_no) {
        List<WareHouse> wareHouses = new ArrayList<>();
        String img03 = null;
        if (warehouse_no.equals("YFPWIP")) {
            img03 = "JAED02";
        } else {
            img03 = "JSAA03";
        }
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_listWarHouse);
            preparedStatement.setString(1, warehouse_no);
            preparedStatement.setString(2,img03);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WareHouse wareHouse = new WareHouse();
                wareHouse.setMaterial_no(resultSet.getString(1));
                wareHouse.setMaterial_name(resultSet.getString(2));
                wareHouse.setMaterial_spec(resultSet.getString(3));
                wareHouse.setMaterial_unit(resultSet.getString(4));
                wareHouse.setMaterial_count(resultSet.getString(5));
                wareHouse.setWarehouse_no(resultSet.getString(6));
                wareHouse.setWarehouse_location(resultSet.getString(7));
                wareHouses.add(wareHouse);
            }
            ConnectionUtil.releaseResultSet(resultSet);
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(connection);
        } catch (Exception e) {
            logger.error(e);
        }
        return wareHouses;
    }

    public List<WareHouse> listYFMZJPA(String warehouse_no) {
        List<WareHouse> wareHouses = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_YFMZJPA);
            preparedStatement.setString(1, warehouse_no);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                WareHouse wareHouse = new WareHouse();
                wareHouse.setMaterial_no(resultSet.getString(1));
                wareHouse.setMaterial_name(resultSet.getString(2));
                wareHouse.setMaterial_spec(resultSet.getString(3));
                wareHouse.setMaterial_unit(resultSet.getString(4));
                wareHouse.setMaterial_count(resultSet.getString(5));
                wareHouse.setWarehouse_no(resultSet.getString(6));
                wareHouse.setWarehouse_location(resultSet.getString(7));
                wareHouses.add(wareHouse);
            }
            ConnectionUtil.releaseResultSet(resultSet);
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(connection);
        } catch (Exception e) {
            logger.error(e);
        }
        return wareHouses;
    }
}
