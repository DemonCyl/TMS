package kaijia.lucifer.dao;

import kaijia.lucifer.model.AllocationOrder;

import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  上午 10:50
 */
public interface AllocationOrderDao {

    List<AllocationOrder> findAllocationOrderByContent(String order_no, String order_status, String sign_status);  //调拨单明细
}
