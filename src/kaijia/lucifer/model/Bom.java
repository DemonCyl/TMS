package kaijia.lucifer.model;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/11/2  下午 03:05
 */
public class Bom {

    private String material_no;
    private String material_name;
    private String material_spec;
    private String material_unit;
    private String material_code;
    private double material_standard_count;
    private double material_real_standard_count;
    private double material_count;
    private double material_real_count;
    private double material_single_money;
    private double material_total_money;

    @Override
    public String toString() {
        return "Bom{" +
                "material_no='" + material_no + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_spec='" + material_spec + '\'' +
                ", material_unit='" + material_unit + '\'' +
                ", material_code='" + material_code + '\'' +
                ", material_standard_count=" + material_standard_count +
                ", material_real_standard_count=" + material_real_standard_count +
                ", material_count=" + material_count +
                ", material_real_count=" + material_real_count +
                ", material_single_money=" + material_single_money +
                ", material_total_money=" + material_total_money +
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

    public String getMaterial_code() {
        return material_code;
    }

    public void setMaterial_code(String material_code) {
        this.material_code = material_code;
    }

    public double getMaterial_standard_count() {
        return material_standard_count;
    }

    public void setMaterial_standard_count(double material_standard_count) {
        this.material_standard_count = material_standard_count;
    }

    public double getMaterial_real_standard_count() {
        return material_real_standard_count;
    }

    public void setMaterial_real_standard_count(double material_real_standard_count) {
        this.material_real_standard_count = material_real_standard_count;
    }

    public double getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(double material_count) {
        this.material_count = material_count;
    }

    public double getMaterial_real_count() {
        return material_real_count;
    }

    public void setMaterial_real_count(double material_real_count) {
        this.material_real_count = material_real_count;
    }

    public double getMaterial_single_money() {
        return material_single_money;
    }

    public void setMaterial_single_money(double material_single_money) {
        this.material_single_money = material_single_money;
    }

    public double getMaterial_total_money() {
        return material_total_money;
    }

    public void setMaterial_total_money(double material_total_money) {
        this.material_total_money = material_total_money;
    }
}
