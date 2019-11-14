package kaijia.lucifer.service.impl;

import kaijia.lucifer.dao.OrderDao;
import kaijia.lucifer.dao.impl.OrderDaoImpl;
import kaijia.lucifer.model.Order;
import kaijia.lucifer.model.Report;
import kaijia.lucifer.service.OrderService;
import kaijia.lucifer.tool.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 03:30
 */
public class OrderServiceImpl implements OrderService {

    private final String[] orderNoType = {"81A", "81B", "81C", "81F", "81G", "81H", "8B1", "8B2"};
    private final String[] orderStatus = {"2", "4","7"};
    private final String[] signStatus = {"Y"};

    private Map<String, String> ORDER_NO_TYPE_ERROR;// = {"orderNoTypeError", "傳入的工單編號類型異常"};
    private Map<String, String> SIGN_STATUS_ERROR;// = {"signStatusError", "傳入的審核狀態類型異常"};
    private Map<String, String> ORDER_STATUS_ERROR;// = {"orderStatusError", "傳入的工單狀態類型異常"};

    private int i = 0;

    private List<Map<String, String>> errMsg;
    private OrderDao orderDao = new OrderDaoImpl();

    public OrderServiceImpl() {
        errMsg = new ArrayList<>();
        ORDER_NO_TYPE_ERROR = new HashMap<>();
        SIGN_STATUS_ERROR = new HashMap<>();
        ORDER_STATUS_ERROR = new HashMap<>();
        ORDER_NO_TYPE_ERROR.put("orderNoTypeError", "傳入的工單編號類型異常");
        SIGN_STATUS_ERROR.put("signStatusError", "傳入的審核狀態類型異常");
        ORDER_STATUS_ERROR.put("orderStatusError", "傳入的工單狀態類型異常");
    }

    @Override
    public String findOrderNo(String jsonData) {
        if (("").equals(jsonData) || jsonData == null) {
            return "?";
        }
        Order order = JsonUtil.changeJsonToObject(jsonData, Order.class);
        checkOrderNoType(order);
        checkOrderStatus(order);
        checkSignStatus(order);
        if (errMsg.isEmpty()) {
            List<Order> orders = orderDao.findByOrderNoType(order);
            return JsonUtil.createJsonList(orders);
        } else {
            String err = JsonUtil.createJsonList(errMsg);
            errMsg.clear();
            return err;
        }
    }

    @Override
    public String findOrderBom(String jsonData) {
        if (("").equals(jsonData) || jsonData == null) {
            return "?";
        }
        Order order = JsonUtil.changeJsonToObject(jsonData, Order.class);
        Order order1 = new Order();
        order1.setOrder_no(order.getOrder_no().substring(0, 3));
        checkOrderNoType(order1);
        if (errMsg.isEmpty()) {
            Order _order = orderDao.findOrderByNo(order);
            return JsonUtil.createJsonString(_order);
        } else {
            String err = JsonUtil.createJsonList(errMsg);
            errMsg.clear();
            return err;
        }
    }

    @Override
    public String insertRecord(String jsonData) {
        if (("").equals(jsonData) || jsonData == null) {
            return "?";
        }
        Report report = JsonUtil.changeJsonToObject(jsonData, Report.class);
        report.setTimes(orderDao.selectMax(report) + 1);
        int i = orderDao.insertReport(report);
        if (i > 0) {
            return "{\"errCode\":\"000\",\"errMsg\":\"成功\"}";
        }
        return "{\"errCode\":\"001\",\"errMsg\":\"失敗\"}";
    }

    private void checkOrderNoType(Order order) {
        i = 0;
        for (String type : orderNoType) {
            if (type.equals(order.getOrder_no())) {
                i = 1;
            }
        }
        if (i == 0) {
            errMsg.add(ORDER_NO_TYPE_ERROR);
        }
    }

    private void checkSignStatus(Order order) {
        i = 0;
        for (String sign : signStatus) {
            if (sign.equals(order.getSign_status())) {
                i = 1;
            }
        }
        if (i == 0) {
            errMsg.add(SIGN_STATUS_ERROR);
        }
    }

    private void checkOrderStatus(Order order) {
        i = 0;
        for (String no : orderStatus) {
            if (no.equals(order.getOrder_status())) {
                i = 1;
            }
        }
        if (i == 0) {
            errMsg.add(ORDER_STATUS_ERROR);
        }
    }
}
