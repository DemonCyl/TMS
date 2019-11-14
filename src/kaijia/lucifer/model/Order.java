package kaijia.lucifer.model;

import java.util.List;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 02:54
 */
public class Order {

    private String order_no;
    private String sign_status;
    private String order_type;
    private String order_status;
    private String creator;
    private String create_date;
    private String complete_mode;
    private String complete_status;
    private String again_mode;
    private String material_no;
    private String material_name;
    private String material_spec;
    private double material_count;
    private String material_unit;
    private double material_send_count;
    private double storage_real_count;
    private String est_start_date;
    private String est_end_date;
    private String real_start_date;
    private String cost_center_no;
    private String cost_center_name;
    private String dept_no;
    private String deptname;

    private List<Bom> boms;

    @Override
    public String toString() {
        return "Order{" +
                "order_no='" + order_no + '\'' +
                ", sign_status='" + sign_status + '\'' +
                ", order_type='" + order_type + '\'' +
                ", order_status='" + order_status + '\'' +
                ", creator='" + creator + '\'' +
                ", create_date='" + create_date + '\'' +
                ", complete_mode='" + complete_mode + '\'' +
                ", complete_status='" + complete_status + '\'' +
                ", again_mode='" + again_mode + '\'' +
                ", material_no='" + material_no + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_spec='" + material_spec + '\'' +
                ", material_count=" + material_count +
                ", material_unit='" + material_unit + '\'' +
                ", material_send_count=" + material_send_count +
                ", storage_real_count=" + storage_real_count +
                ", est_start_date='" + est_start_date + '\'' +
                ", est_end_date='" + est_end_date + '\'' +
                ", real_start_date='" + real_start_date + '\'' +
                ", cost_center_no='" + cost_center_no + '\'' +
                ", cost_center_name='" + cost_center_name + '\'' +
                ", dept_no='" + dept_no + '\'' +
                ", deptname='" + deptname + '\'' +
                ", boms=" + boms +
                '}';
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getSign_status() {
        return sign_status;
    }

    public void setSign_status(String sign_status) {
        this.sign_status = sign_status;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getComplete_mode() {
        return complete_mode;
    }

    public void setComplete_mode(String complete_mode) {
        this.complete_mode = complete_mode;
    }

    public String getComplete_status() {
        return complete_status;
    }

    public void setComplete_status(String complete_status) {
        this.complete_status = complete_status;
    }

    public String getAgain_mode() {
        return again_mode;
    }

    public void setAgain_mode(String again_mode) {
        this.again_mode = again_mode;
    }

    public String getMaterial_no() {
        return material_no;
    }

    public void setMaterial_no(String material_no) {
        this.material_no = material_no;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_spec() {
        return material_spec;
    }

    public void setMaterial_spec(String material_spec) {
        this.material_spec = material_spec;
    }

    public double getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(double material_count) {
        this.material_count = material_count;
    }

    public String getMaterial_unit() {
        return material_unit;
    }

    public void setMaterial_unit(String material_unit) {
        this.material_unit = material_unit;
    }

    public double getMaterial_send_count() {
        return material_send_count;
    }

    public void setMaterial_send_count(double material_send_count) {
        this.material_send_count = material_send_count;
    }

    public double getStorage_real_count() {
        return storage_real_count;
    }

    public void setStorage_real_count(double storage_real_count) {
        this.storage_real_count = storage_real_count;
    }

    public String getEst_start_date() {
        return est_start_date;
    }

    public void setEst_start_date(String est_start_date) {
        this.est_start_date = est_start_date;
    }

    public String getEst_end_date() {
        return est_end_date;
    }

    public void setEst_end_date(String est_end_date) {
        this.est_end_date = est_end_date;
    }

    public String getReal_start_date() {
        return real_start_date;
    }

    public void setReal_start_date(String real_start_date) {
        this.real_start_date = real_start_date;
    }

    public String getCost_center_no() {
        return cost_center_no;
    }

    public void setCost_center_no(String cost_center_no) {
        this.cost_center_no = cost_center_no;
    }

    public String getCost_center_name() {
        return cost_center_name;
    }

    public void setCost_center_name(String cost_center_name) {
        this.cost_center_name = cost_center_name;
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

    public List<Bom> getBoms() {
        return boms;
    }

    public void setBoms(List<Bom> boms) {
        this.boms = boms;
    }
}
