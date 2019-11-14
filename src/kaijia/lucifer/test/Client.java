package kaijia.lucifer.test;

import kaijia.lucifer.dao.AllocationOrderDao;
import kaijia.lucifer.dao.OrderDao;
import kaijia.lucifer.dao.impl.AllocationOrderDaoImpl;
import kaijia.lucifer.dao.impl.OrderDaoImpl;
import kaijia.lucifer.model.*;
import kaijia.lucifer.service.AllocationOrderService;
import kaijia.lucifer.service.OrderService;
import kaijia.lucifer.service.WareHouseService;
import kaijia.lucifer.service.impl.AllocationOrderServiceImpl;
import kaijia.lucifer.service.impl.CustomServiceImpl;
import kaijia.lucifer.service.impl.OrderServiceImpl;
import kaijia.lucifer.service.impl.WareHouseServiceImpl;
import kaijia.lucifer.tool.JsonUtil;
import org.apache.log4j.Logger;

import javax.xml.ws.Endpoint;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/3  上午 10:20
 */
public class Client {

    public static void main(String[] args) {

/*        Logger logger = Logger.getLogger(Client.class);
        logger.info("qwertyuiop");*/
/*        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        String[] strings1 = new String[strings.size()];
        System.out.println(strings.toArray(strings1));*/
/*        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String fff = dateTime.format(dateTimeFormatter);
        System.out.println(fff);*/


/*        try {
            CustomServiceImplService orderService = new CustomServiceImplServiceLocator();
            CustomServiceImplPortBindingStub serviceImplPortBindingStub = (CustomServiceImplPortBindingStub) orderService.getCustomServiceImplPort();
            //"{\"order_no\":\"81A\",\"sign_status\":\"Y\",\"order_status\":\"2\"}"
            //"{\"order_no\":\"814-161200001\"}"
            String response = serviceImplPortBindingStub.findAllocationOrderByContent("");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*        WareHouseService wareHouseService = new WareHouseServiceImpl();
        String result = wareHouseService.listWareHouse("{\"wareHouseNo\":\"YFPWIP\"}");
        System.out.println(result);*/

        Endpoint.publish("http://10.162.244.108:80/TMS_TIPTOP/findOrderDetail", new CustomServiceImpl());
        System.out.println("OK");
        System.out.println("http://10.131.120.72:80/TMS_TIPTOP/findOrderDetail?wsdl");  // webservice 接口发布到服务器上

/*        Report report = new Report();
        report.setOrder_no("order_no");
        report.setCost_labor_num(1l);
        report.setCost_work_time(2l);
        report.setCreate_date("2016/10/27");
        report.setDept_no("JAAB02");
        report.setLine_no("line_no");
        report.setMaterial_count(10l);
        report.setProcess_type("process_type");
        report.setShift_type("N");
        report.setSign_status("sign_status");*/
/*        System.out.println(JsonUtil.createJsonString(report));*/

/*        OrderService orderService = new OrderServiceImpl();
        String i = orderService.insertRecord("{\"dept_no\":\"JGBA03\",\"shift_type\":\"N\",\"create_date\":\"2017-10-10\",\"sign_status\":\"1\",\"line_no\":\"line_no\",\"process_type\":\"1\",\"order_no\":\"order_no\",\"material_count\":10.0,\"cost_work_time\":2.0,\"cost_labor_num\":1.0}");
        System.out.println(i);*/

//        OrderService orderService = new OrderServiceImpl();
//        System.out.println(orderService.findOrderBom("{\"order_no\":\"81A-180100002\"}"));


/*        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.selectMax(report));*/

        //{"order_no":"B1","sign_status":"1","order_status":"Y","material_count":0.0,"material_send_count":0.0,"storage_real_count":0.0}

/*        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.findOrderBom("{\"order_no\":\"81A-170600004\"}"));*/

        //AllocationOrderService allocationOrderService = new AllocationOrderServiceImpl();
        //AllocationOrderDao allocationOrderDao = new AllocationOrderDaoImpl();
        //System.out.println(allocationOrderService.findAllocationOrderByContent("{\"order_no_type\":\"4ww62\",\"order_status\":\"Y\",\"sign_status\":\"N\"}"));
/*        List<AllocationOrder> orders = allocationOrderDao.findAllocationOrderByContent("462", "Y", "N");
        for (AllocationOrder order : orders) {
            System.out.println(order);
        }*/


    }
}
