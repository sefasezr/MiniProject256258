package MiniBookStore;

public class Pencil extends Product {

    private String penTip;
    private String color;

    public Pencil(int id, String name, String price, int stock, String penTip, String color) {
        super(id,name,price,stock);
        this.penTip = penTip;
        this.color = color;
    }

    public String getPenTip() {
        return penTip;
    }
    public void setPenTip(String penTip) {
        this.penTip = penTip;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }


}
