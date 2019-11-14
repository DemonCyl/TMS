package kaijia.lucifer.service.impl;

import kaijia.lucifer.dao.AllocationOrderDao;
import kaijia.lucifer.dao.impl.AllocationOrderDaoImpl;
import kaijia.lucifer.model.AllocationOrder;
import kaijia.lucifer.service.AllocationOrderService;
import kaijia.lucifer.tool.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  下午 01:41
 */
public class AllocationOrderServiceImpl implements AllocationOrderService {

    private final String[] orderNoType = {"462", "463", "464"};

    private Map<String, String> ORDER_NO_TYPE_ERROR;                    //{"orderNoTypeError", "傳入的工單編號類型異常"}

    private int i = 0;

    private List<Map<String, String>> errMsg;
    private AllocationOrderDao allocationOrderDao = new AllocationOrderDaoImpl();

    public AllocationOrderServiceImpl() {
        errMsg = new ArrayList<>();
        ORDER_NO_TYPE_ERROR = new HashMap<>();
        ORDER_NO_TYPE_ERROR.put("orderNoTypeError", "傳入的工單編號類型異常");
    }

    @Override
    public String findAllocationOrderByContent(String jsonData) {
        if (jsonData == null || "".equals(jsonData)) {
            return "?";
        }
        Map<String, Object> map = JsonUtil.changeGsonToMaps(jsonData);
        String orderNoType = String.valueOf(map.get("order_no_type"));
        String orderStatus = String.valueOf(map.get("order_status"));
        String signStatus = String.valueOf(map.get("sign_status"));
        checkOrderNoType(orderNoType);
        if (errMsg.isEmpty()) {
            List<AllocationOrder> allocationOrders = allocationOrderDao.findAllocationOrderByContent(orderNoType, orderStatus, signStatus);
            return JsonUtil.createJsonList(allocationOrders);
        } else {
            String err = JsonUtil.createJsonList(errMsg);
            errMsg.clear();
            return err;
        }

    }

    private void checkOrderNoType(String _orderNoType) {
        i = 0;
        for (String type : orderNoType) {
            if (type.equals(_orderNoType)) {
                i = 1;
            }
        }
        if (i == 0) {
            errMsg.add(ORDER_NO_TYPE_ERROR);
        }
    }
}
