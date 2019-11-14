package kaijia.lucifer.dao.impl;

import kaijia.lucifer.dao.OrderDao;
import kaijia.lucifer.model.Bom;
import kaijia.lucifer.model.Order;
import kaijia.lucifer.model.Report;
import kaijia.lucifer.tool.ConnectionUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 03:16
 */
public class OrderDaoImpl implements OrderDao {

    protected final String sql_findByOrderNoType = "SELECT t.sfb01,t.sfb87,t.sfb04 FROM sfb_file t WHERE t.sfb01 LIKE ? AND t.sfb87 = ? AND t.sfb04 = ?";

    protected final String sql_findByOrderNo = "SELECT s.sfb01,s.sfb87,s.sfb02,s.sfb04,s.sfb44,s.sfb81,s.sfb39,s.sfb28,s.ta_sfb01,s.sfb05,i.ima02,i.ima021,s.sfb08,i.ima55,s.sfb081,s.sfb09,s.sfb13,s.sfb15,s.sfb25,s.sfb98,g.gem02,s.sfb82,p.pmc03 FROM sfb_file s,ima_file i,gem_file g,pmc_file p WHERE s.sfb05=i.ima01 AND s.sfb98 = g.gem01 AND s.sfb01 = ?";

    protected final String sql_findBomByOrder = "SELECT s.sfa03,i.ima02,i.ima021,s.sfa12,i.ima08,s.sfa16,s.sfa161,s.sfa05,s.sfa06,i.ima53 " +
            "FROM sfa_file s,ima_file i WHERE s.sfa03 = i.ima01 AND s.sfa01 = ?";

    protected final String sql_insertReport = "INSERT INTO tc_pdl_file t (tc_pdl01,tc_pdl02,tc_pdl03,tc_pdlfrim,tc_pdl04,tc_pdl05,tc_pdl06,tc_pdl09,tc_pdl14,tc_pdl17,tc_pdl37,tc_pdl15) VALUES (?,?,to_date(?,'yyyy/MM/dd'),?,?,?,?,?,?,?,? ,?)";

    protected final String sql_selectMax = "SELECT MAX(t.tc_pdl37) FROM tc_pdl_file t WHERE t.tc_pdl03 = to_date(?,'yyyy/MM/dd') AND t.tc_pdl01 = ? AND t.tc_pdl02 = ?";

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    private Logger logger = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public List<Order> findByOrderNoType(Order order) {
        List<Order> orders = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_findByOrderNoType);
            preparedStatement.setString(1, "%" + order.getOrder_no() + "%");
            preparedStatement.setString(2, order.getSign_status());
            preparedStatement.setString(3, order.getOrder_status());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order _order = new Order();
                _order.setOrder_no(resultSet.getString(1));
                _order.setSign_status(resultSet.getString(2));
                _order.setOrder_status(resultSet.getString(3));
                orders.add(_order);
            }
            ConnectionUtil.releaseResultSet(resultSet);
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(connection);
        } catch (Exception e) {
            logger.error(e);
        }
        return orders;
    }

    @Override
    public Order findOrderByNo(Order order) {
        Order _order = new Order();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_findByOrderNo);
            preparedStatement.setString(1, order.getOrder_no());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                _order.setOrder_no(resultSet.getString(1));
                _order.setSign_status(resultSet.getString(2));
                _order.setOrder_type(resultSet.getString(3));
                _order.setOrder_status(resultSet.getString(4));
                _order.setCreator(resultSet.getString(5));
                _order.setCreate_date(resultSet.getString(6));
                _order.setComplete_mode(resultSet.getString(7));
                _order.setComplete_status(resultSet.getString(8));
                _order.setAgain_mode(resultSet.getString(9));
                _order.setMaterial_no(resultSet.getString(10));
                _order.setMaterial_name(resultSet.getString(11));
                _order.setMaterial_spec(resultSet.getString(12));
                _order.setMaterial_count(resultSet.getDouble(13));
                _order.setMaterial_unit(resultSet.getString(14));
                _order.setMaterial_send_count(resultSet.getDouble(15));
                _order.setStorage_real_count(resultSet.getDouble(16));
                _order.setEst_start_date(resultSet.getString(17));
                _order.setEst_end_date(resultSet.getString(18));
                _order.setReal_start_date(resultSet.getString(19));
                _order.setCost_center_no(resultSet.getString(20));
                _order.setCost_center_name(resultSet.getString(21));
                _order.setDept_no(resultSet.getString(22));
                _order.setDeptname(resultSet.getString(23));
                //close
                ConnectionUtil.releaseResultSet(resultSet);
                ConnectionUtil.releasePreparedStatement(preparedStatement);
                preparedStatement = connection.prepareStatement(sql_findBomByOrder);
                preparedStatement.setString(1, _order.getOrder_no());
                resultSet = preparedStatement.executeQuery();
                List<Bom> boms = new ArrayList<>();
                while (resultSet.next()) {
                    Bom _bom = new Bom();
                    _bom.setMaterial_no(resultSet.getString(1));
                    _bom.setMaterial_name(resultSet.getString(2));
                    _bom.setMaterial_spec(resultSet.getString(3));
                    _bom.setMaterial_unit(resultSet.getString(4));
                    _bom.setMaterial_code(resultSet.getString(5));
                    _bom.setMaterial_standard_count(resultSet.getDouble(6));
                    _bom.setMaterial_real_standard_count(resultSet.getDouble(7));
                    _bom.setMaterial_count(resultSet.getDouble(8));
                    _bom.setMaterial_real_count(resultSet.getDouble(9));
                    _bom.setMaterial_single_money(resultSet.getDouble(10));
                    _bom.setMaterial_total_money((resultSet.getDouble(10)) * (resultSet.getDouble(7)));
                    boms.add(_bom);
                }
                _order.setBoms(boms);
            }
            ConnectionUtil.releaseResultSet(resultSet);
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(connection);
        } catch (Exception e) {
            logger.error(e);
        }
        return _order;
    }

    @Override
    public int insertReport(Report report) {
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql_insertReport);
            preparedStatement.setString(1, report.getDept_no());
            preparedStatement.setString(2, report.getShift_type());
            preparedStatement.setString(3, report.getCreate_date());
            preparedStatement.setString(4, report.getSign_status());
            preparedStatement.setString(5, report.getLine_no());
            preparedStatement.setString(6, report.getProcess_type());
            preparedStatement.setString(7, report.getOrder_no());
            preparedStatement.setDouble(8, report.getMaterial_count());
            preparedStatement.setDouble(9, report.getCost_work_time());
            preparedStatement.setDouble(10, report.getCost_labor_num());
            preparedStatement.setInt(11, report.getTimes());
            preparedStatement.setDouble(12, 0);
//            preparedStatement.setDouble(12, report.getRemain_time());  // add by chenyl cancel tc_pdl45
            int i = preparedStatement.executeUpdate();
            ConnectionUtil.releasePreparedStatement(preparedStatement);
            ConnectionUtil.releaseConnection(connection);
            return i;
        } catch (Exception e) {
            logger.error(e);
            return 0;
        }
    }

    @Override
    public int selectMax(Report report) {
        int max = 0;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql_selectMax);
            preparedStatement.setString(1, report.getCreate_date());
            preparedStatement.setString(2, report.getDept_no());
            preparedStatement.setString(3, report.getShift_type());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                max = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return max;
    }
}
