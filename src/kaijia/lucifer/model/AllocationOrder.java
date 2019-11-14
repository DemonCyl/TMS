package kaijia.lucifer.model;

import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  上午 10:41
 */
public class AllocationOrder {

    private String order_no;
    private String order_status;
    private String sign_status;
    private String dept_no;
    private String deptname;
    private String creator;
    private String create_time;

    private List<AllocationBom> allocationBoms;

    @Override
    public String toString() {
        return "AllocationOrder{" +
                "order_no='" + order_no + '\'' +
                ", order_status='" + order_status + '\'' +
                ", sign_status='" + sign_status + '\'' +
                ", dept_no='" + dept_no + '\'' +
                ", deptname='" + deptname + '\'' +
                ", creator='" + creator + '\'' +
                ", create_time='" + create_time + '\'' +
                ", allocationBoms=" + allocationBoms +
                '}';
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getSign_status() {
        return sign_status;
    }

    public void setSign_status(String sign_status) {
        this.sign_status = sign_status;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<AllocationBom> getAllocationBoms() {
        return allocationBoms;
    }

    public void setAllocationBoms(List<AllocationBom> allocationBoms) {
        this.allocationBoms = allocationBoms;
    }
}
