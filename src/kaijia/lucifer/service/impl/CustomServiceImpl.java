package kaijia.lucifer.service.impl;

import kaijia.lucifer.service.AllocationOrderService;
import kaijia.lucifer.service.CustomService;
import kaijia.lucifer.service.OrderService;
import kaijia.lucifer.service.WareHouseService;
import org.apache.log4j.Logger;

import javax.jws.WebService;

/**
 * @Description: webservice 全部接口
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  下午 02:26
 */
@WebService(endpointInterface = "kaijia.lucifer.service.CustomService")
public class CustomServiceImpl implements CustomService {

    private OrderService orderService = new OrderServiceImpl();
    private AllocationOrderService allocationOrderService = new AllocationOrderServiceImpl();
    private WareHouseService wareHouseService = new WareHouseServiceImpl();

    private Logger logger = Logger.getLogger(CustomServiceImpl.class);

    @Override
    public String findOrderNo(String jsonData) {
        logger.info("接受數據 findOrderNo >>>>>>>>> " + jsonData);
        return orderService.findOrderNo(jsonData);
    }

    @Override
    public String findOrderBom(String jsonData) {
        logger.info("接受數據 findOrderBom >>>>>>>>> " + jsonData);
        return orderService.findOrderBom(jsonData);
    }

    @Override
    public String insertRecord(String jsonData) {
        logger.info("接受數據 insertRecord >>>>>>>>> " + jsonData);
        return orderService.insertRecord(jsonData);
    }

    @Override
    public String findAllocationOrderByContent(String jsonData) {
        logger.info("接受數據 findAllocationOrderByContent >>>>>>>>> " + jsonData);
        return allocationOrderService.findAllocationOrderByContent(jsonData);
    }

    @Override
    public String listWareHouse(String jsonData) {
        logger.info("接受數據 listWareHouse >>>>>>>>> " + jsonData);
        return wareHouseService.listWareHouse(jsonData);
    }
}
