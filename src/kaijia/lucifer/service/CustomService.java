package kaijia.lucifer.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  下午 02:24
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CustomService {

    @WebMethod
    String findOrderNo(@WebParam(name = "jsonData") String jsonData);

    @WebMethod
    String findOrderBom(@WebParam(name = "jsonData") String jsonData);

    @WebMethod
    String insertRecord(@WebParam(name = "jsonData") String jsonData);

    @WebMethod
    String findAllocationOrderByContent(@WebParam(name = "jsonData") String jsonData);

    @WebMethod
    String listWareHouse(@WebParam(name = "jsonData") String jsonData);
}
