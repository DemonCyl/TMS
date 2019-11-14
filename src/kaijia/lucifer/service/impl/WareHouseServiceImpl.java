package kaijia.lucifer.service.impl;

import kaijia.lucifer.dao.WareHouseDao;
import kaijia.lucifer.dao.impl.WareHouseDaoImpl;
import kaijia.lucifer.model.WareHouse;
import kaijia.lucifer.service.WareHouseService;
import kaijia.lucifer.tool.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/12/15  上午 08:41
 */
public class WareHouseServiceImpl implements WareHouseService {

    private final String[] wareHouseType = {"YFWIP", "YFPWIP", "YFMZJYA", "YCNCWIP", "YCNCJD", "YMJZWIP", "YFMZJPA"};

    private Map<String, String> WARE_HOUSE_TYPE_ERROR;

    private int i = 0;
    private List<Map<String, String>> errMsg;

    private WareHouseDao wareHouseDao = new WareHouseDaoImpl();

    public WareHouseServiceImpl() {
        errMsg = new ArrayList<>();
        WARE_HOUSE_TYPE_ERROR = new HashMap<>();
        WARE_HOUSE_TYPE_ERROR.put("wareHouseTypeError", "傳入的倉庫類型錯誤");
    }

    @Override
    public String listWareHouse(String jsonData) {
        if ("".equals(jsonData) || jsonData == null) {
            return "?";
        }
        Map<String, String> map = JsonUtil.changeGsonToMaps(jsonData);
        String wareHouseNo = map.get("wareHouseNo");
        WareHouse wareHouse = new WareHouse();
        wareHouse.setWarehouse_no(wareHouseNo);
        checkWareHouseType(wareHouse);
        if (errMsg.isEmpty()) {
            List<WareHouse> wareHouses = new ArrayList<>();
            if (wareHouseNo.equals("YFMZJPA")) {
                wareHouses = wareHouseDao.listYFMZJPA(wareHouseNo);
            }else{
                wareHouses = wareHouseDao.listWareHouse(wareHouseNo);
            }
            return JsonUtil.createJsonList(wareHouses);
        } else {
            String err = JsonUtil.createJsonList(errMsg);
            errMsg.clear();
            return err;
        }
    }

    private void checkWareHouseType(WareHouse wareHouse) {
        i = 0;
        for (String type : wareHouseType) {
            if (type.equals(wareHouse.getWarehouse_no())) {
                i = 1;
            }
        }
        if (i == 0) {
            errMsg.add(WARE_HOUSE_TYPE_ERROR);
        }
    }
}
