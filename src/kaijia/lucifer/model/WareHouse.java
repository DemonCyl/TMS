package kaijia.lucifer.model;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/12/15  上午 08:24
 */
public class WareHouse {

    private String material_no;
    private String material_name;
    private String material_spec;
    private String material_unit;
    private String material_count;
    private String warehouse_no;
    private String warehouse_location;

    @Override
    public String toString() {
        return "WareHouse{" +
                "material_no='" + material_no + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_spec='" + material_spec + '\'' +
                ", material_unit='" + material_unit + '\'' +
                ", material_count='" + material_count + '\'' +
                ", warehouse_no='" + warehouse_no + '\'' +
                ", warehouse_location='" + warehouse_location + '\'' +
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

    public String getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(String material_count) {
        this.material_count = material_count;
    }

    public String getWarehouse_no() {
        return warehouse_no;
    }

    public void setWarehouse_no(String warehouse_no) {
        this.warehouse_no = warehouse_no;
    }

    public String getWarehouse_location() {
        return warehouse_location;
    }

    public void setWarehouse_location(String warehouse_location) {
        this.warehouse_location = warehouse_location;
    }
}
