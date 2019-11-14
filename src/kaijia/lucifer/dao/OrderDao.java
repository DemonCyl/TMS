package kaijia.lucifer.dao;

import kaijia.lucifer.model.Order;
import kaijia.lucifer.model.Report;

import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 02:56
 */
public interface OrderDao {

    List<Order> findByOrderNoType(Order order);  //查找工单

    Order findOrderByNo(Order order);  //查找指定工单

    int insertReport(Report report);  //新增日报表

    int selectMax(Report report);
}
