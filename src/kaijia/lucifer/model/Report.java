package kaijia.lucifer.model;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/3  下午 03:26
 */
public class Report {

    private String dept_no;
    private String shift_type;
    private String create_date;
    private String sign_status;
    private String line_no;
    private String process_type;
    private String order_no;
    private double material_count;
    private double cost_work_time;
    private double cost_labor_num;
    private int times;
    private double remain_time;

    @Override
    public String toString() {
        return "Report{" +
                "dept_no='" + dept_no + '\'' +
                ", shift_type='" + shift_type + '\'' +
                ", create_date='" + create_date + '\'' +
                ", sign_status='" + sign_status + '\'' +
                ", line_no='" + line_no + '\'' +
                ", process_type='" + process_type + '\'' +
                ", order_no='" + order_no + '\'' +
                ", material_count=" + material_count +
                ", cost_work_time=" + cost_work_time +
                ", cost_labor_num=" + cost_labor_num +
                ", times=" + times +
                ", remain_time=" + remain_time +
                '}';
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getShift_type() {
        return shift_type;
    }

    public void setShift_type(String shift_type) {
        this.shift_type = shift_type;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getSign_status() {
        return sign_status;
    }

    public void setSign_status(String sign_status) {
        this.sign_status = sign_status;
    }

    public String getLine_no() {
        return line_no;
    }

    public void setLine_no(String line_no) {
        this.line_no = line_no;
    }

    public String getProcess_type() {
        return process_type;
    }

    public void setProcess_type(String process_type) {
        this.process_type = process_type;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public double getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(double material_count) {
        this.material_count = material_count;
    }

    public double getCost_work_time() {
        return cost_work_time;
    }

    public void setCost_work_time(double cost_work_time) {
        this.cost_work_time = cost_work_time;
    }

    public double getCost_labor_num() {
        return cost_labor_num;
    }

    public void setCost_labor_num(double cost_labor_num) {
        this.cost_labor_num = cost_labor_num;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getRemain_time() {
        return remain_time;
    }

    public void setRemain_time(double remain_time) {
        this.remain_time = remain_time;
    }
}
