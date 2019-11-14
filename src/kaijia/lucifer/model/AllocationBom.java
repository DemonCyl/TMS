package kaijia.lucifer.model;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/29  上午 10:41
 */
public class AllocationBom {

    private String material_no;
    private String material_name;
    private String material_spec;
    private String material_unit;
    private double material_count;
    private String out_warehouse;
    private String in_warehouse;
    private String in_warehouse_location;

    public AllocationBom() {
    }

    public AllocationBom(String material_no) {
        this.material_no = material_no;
    }

    @Override
    public String toString() {
        return "AllocationBom{" +
                "material_no='" + material_no + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_spec='" + material_spec + '\'' +
                ", material_unit='" + material_unit + '\'' +
                ", material_count=" + material_count +
                ", out_warehouse='" + out_warehouse + '\'' +
                ", in_warehouse='" + in_warehouse + '\'' +
                ", in_warehouse_location='" + in_warehouse_location + '\'' +
                '}';
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

    public String getMaterial_unit() {
        return material_unit;
    }

    public void setMaterial_unit(String material_unit) {
        this.material_unit = material_unit;
    }

    public double getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(double material_count) {
        this.material_count = material_count;
    }

    public String getOut_warehouse() {
        return out_warehouse;
    }

    public void setOut_warehouse(String out_warehouse) {
        this.out_warehouse = out_warehouse;
    }

    public String getIn_warehouse() {
        return in_warehouse;
    }

    public void setIn_warehouse(String in_warehouse) {
        this.in_warehouse = in_warehouse;
    }

    public String getIn_warehouse_location() {
        return in_warehouse_location;
    }

    public void setIn_warehouse_location(String in_warehouse_location) {
        this.in_warehouse_location = in_warehouse_location;
    }
}
