package kaijia.lucifer.service;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 03:27
 */
public interface OrderService {

    String findOrderNo(String jsonData);

    String findOrderBom(String jsonData);

    String insertRecord(String jsonData);
}
