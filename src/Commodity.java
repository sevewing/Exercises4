public class Commodity {
    public String barcode;
    public String category;
    public String name;
    public int limit;
    public int number;
    public String priceReal;
    public String priceDisconut;

    public Commodity(String barcode, String category, String name, String priceReal) {
        this.barcode = barcode;
        this.category = category;
        this.name = name;
        this.priceReal = priceReal;
        this.number = 0;
        this.limit = -1;
    }
    public void addNumber(int i) {
        number += i;
    }

    public String getCategory() {
        return category;
    }
}
