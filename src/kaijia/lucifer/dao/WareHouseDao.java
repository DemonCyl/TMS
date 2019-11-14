package kaijia.lucifer.dao;

import kaijia.lucifer.model.WareHouse;

import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/12/15  上午 08:27
 */
public interface WareHouseDao {

    List<WareHouse> listWareHouse(String warehouse_no);  // 查看仓库料件库存明细

    List<WareHouse> listYFMZJPA(String warehouse_no);
}
