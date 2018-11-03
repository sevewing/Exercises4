public class Commodity {
     String barcode;
     String category;
     String name;
     int limit;
     int number;
     String priceReal;
     String priceDisconut;

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
