package kaijia.lucifer.dao.impl;

import kaijia.lucifer.dao.AllocationOrderDao;
import kaijia.lucifer.model.AllocationBom;
import kaijia.lucifer.model.AllocationOrder;
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
 * @CreateTime: 2017/11/29  上午 11:06
 */
public class AllocationOrderDaoImpl implements AllocationOrderDao {

    private final String sql_findAllocationOrderByContent = "SELECT m.imm01, m.immconf, m.imm03, m.imm14, g.gem02, m.imm16, m.imm02 FROM imm_file m, gem_file g WHERE  m.imm14 = g.gem01 AND (m.imm14 = 'JAAM03' Or m.imm14 = 'JSAA03') AND m.imm01 LIKE ? AND m.immconf = ? AND m.imm03 = ?";

    private final String sql_findAllocationBomByOrderNo = "SELECT n.imn02, a.ima02, a.ima021, n.imn09,n.imn10, n.imn04, n.imn15, n.imn16 FROM imn_file n, imm_file m, ima_file a WHERE m.imm01 = n.imn01 AND n.imn03 = a.ima01 AND n.imn01 = ?";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private Logger logger = Logger.getLogger(AllocationOrderDaoImpl.class);

    @Override
    public List<AllocationOrder> findAllocationOrderByContent(String order_no, String order_status, String sign_status) {
        List<AllocationOrder> allocationOrders = new ArrayList<>();
        Connection _connection = ConnectionUtil.getConnection();
        PreparedStatement _preparedStatement = null;
        ResultSet _resultSet = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_findAllocationOrderByContent);
            preparedStatement.setString(1, order_no + "%");
            preparedStatement.setString(2, order_status);
            preparedStatement.setString(3, sign_status);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<AllocationBom> allocationBoms = new ArrayList<>();
                AllocationOrder allocationOrder = new AllocationOrder();
                allocationOrder.setOrder_no(resultSet.getString(1));
                allocationOrder.setOrder_status(resultSet.getString(2));
                allocationOrder.setSign_status(resultSet.getString(3));
                allocationOrder.setDept_no(resultSet.getString(4));
                allocationOrder.setDeptname(resultSet.getString(5));
                allocationOrder.setCreator(resultSet.getString(6));
                allocationOrder.setCreate_time(resultSet.getString(7));
                //Bom list
                _preparedStatement = _connection.prepareStatement(sql_findAllocationBomByOrderNo);
                _preparedStatement.setString(1, resultSet.getString(1));
                _resultSet = _preparedStatement.executeQuery();
                while (_resultSet.next()) {
                    AllocationBom allocationBom = new AllocationBom();
                    allocationBom.setMaterial_no(_resultSet.getString(1));
                    allocationBom.setMaterial_name(_resultSet.getString(2));
                    allocationBom.setMaterial_spec(_resultSet.getString(3));
                    allocationBom.setMaterial_unit(_resultSet.getString(4));
                    allocationBom.setMaterial_count(_resultSet.getDouble(5));
                    allocationBom.setOut_warehouse(_resultSet.getString(6));
                    allocationBom.setIn_warehouse(_resultSet.getString(7));
                    allocationBom.setIn_warehouse_location(_resultSet.getString(8));
                    allocationBoms.add(allocationBom);
                }
                ConnectionUtil.releaseResultSet(_resultSet);
                ConnectionUtil.releasePreparedStatement(_preparedStatement);
                allocationOrder.setAllocationBoms(allocationBoms);
                allocationOrders.add(allocationOrder);
            }
            ConnectionUtil.releaseResultSet(resultSet);
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(_connection);
            ConnectionUtil.releaseConnection(connection);
        } catch (Exception e) {
            logger.error(e);
        }
        return allocationOrders;
    }
}
