import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

class CashRegister {
    private final int SIZE = 38;    //print position, total with of 38 characters
    Map<String, Commodity> commMap; //(key: barcode, value: Commodity with attributes)
    Map<String, List<Commodity>> groupByCategoryMap;   //(key: Category, value: ArrayList<Commodity>)
    float subTotal = 0; //Total price without rebat
    float rabatTotal = 0;   //Total rabat

    /**
     *
     * @param priceFilename
     * @param discountsFilename
     */
    CashRegister(String priceFilename, String discountsFilename) {
        try {
            List<String> pricesList = null;
            List<String> discountsList = null;
            pricesList = Files.readAllLines(Paths.get(priceFilename));
            discountsList = Files.readAllLines(Paths.get(discountsFilename));
            commMap = listToMap(pricesList, discountsList);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * combine prices and discounts in to a map
     * @param pricesList
     * @param discountsList
     * @return map(key: barcode, value: Commodity with attributes)
     */
    Map<String, Commodity> listToMap(List pricesList, List discountsList) {
        Map<String, Commodity> map = new HashMap<String, Commodity>();
        for (Object obj : pricesList) {
            String[] s = ((String) obj).split(",");
            map.put(s[0], new Commodity(s[0], s[1], s[2], s[3] + "." + s[4]));
        }
        for (Object obj : discountsList) {
            String[] s = ((String) obj).split(",");
            Commodity item = map.get(s[0]);
            if (item != null) {
                item.limit = Integer.parseInt(s[1]);
                item.priceDisconut = s[2] + "." + s[3];
            }
        }
        return map;
    }

    /**
     * all the barcodes from the barcode file, and prints the final receipt
     * @param barcodeFilename
     */
    void printReceipt(String barcodeFilename) {
        List<String> bar = null;
        try {
            bar = Files.readAllLines(Paths.get(barcodeFilename));
            orderDataStructure(bar);
            printBody();
            printBottom();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * get item from commMap, Sort by name and category
     * @param bar initOrderData
     */
    public void orderDataStructure(List<String> bar) {
        //use List for stream()
        List<Commodity> orderlist = new ArrayList<Commodity>();
        for (Object s : bar) {
            ((Commodity) commMap.get(s)).addNumber(1);
            orderlist.add((Commodity) commMap.get(s));
        }
        //delete duplication
        orderlist = (List<Commodity>) orderlist.stream().distinct().collect(Collectors.toList());
        //sort name in Obj
        orderlist.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = ((Commodity) o1).name;
                String s2 = ((Commodity) o2).name;
                return s1.compareTo(s2);    //alphabetically
            }
        });
        //groupby Category
        Map<String, List<Commodity>> orderMap = (HashMap<String, List<Commodity>>) orderlist.stream()
                .collect(Collectors.groupingBy(Commodity::getCategory));
        // TreeMap for order key:Category
        groupByCategoryMap = new TreeMap<String, List<Commodity>>(orderMap);
    }

    /**
     * print Categories and Commodities
     */
    public void printBody() {
        System.out.println();
        for (Object key : groupByCategoryMap.keySet()) {
            System.out.println(PositionUtils.center("* " + key + " *", SIZE));
            for (Object o : (ArrayList) groupByCategoryMap.get(key)) {
                Commodity item = (Commodity) o;
                float p = item.number * Float.parseFloat(item.priceReal); //3*10.00
                subTotal += p;
                String ps = String.format("%.2f", p).replace(".", ",");
                if (item.number != 1) {    //print 2 lines
                    System.out.println(PositionUtils.Position(item.name, true, SIZE, 0));
                    System.out.println(PositionUtils.Position(item.number + " x " + item.priceReal.replace(".", ","), ps, SIZE, 2, 1));
                } else {    //print 1 line
                    System.out.println(PositionUtils.Position(item.name, item.priceReal.replace(".", ","), SIZE, 0, 1));
                }
                if (item.limit != -1 && item.number >= item.limit) { //print rabat
                    float pd = item.number * (Float.parseFloat(item.priceReal) - Float.parseFloat(item.priceDisconut));
                    rabatTotal += pd;
                    String pds = String.format("%.2f", pd).replace(".", ",") + "-";
                    System.out.println(PositionUtils.Position("RABAT", pds, SIZE, 0, 0));
                }
            }
            System.out.println();
        }
    }

    /**
     * print summary
     */
    public void printBottom() {
        String pdSums = String.format("%.2f", rabatTotal).replace(".", ",");
        String pSums = String.format("%.2f", subTotal).replace(".", ",");
        String totals = String.format("%.2f", subTotal - rabatTotal).replace(".", ",");
        String makers = (int) (subTotal - rabatTotal) / 50 + "";
        String faxs = String.format("%.2f", (subTotal - rabatTotal) * 0.2).replace(".", ",");
        System.out.println("-------------------------------------"+ "\n");
        System.out.println(PositionUtils.Position("SUBTOT", pSums, SIZE, 0, 1, ' ') + "\n");
        if (rabatTotal != 0) {
            System.out.println(PositionUtils.Position("RABAT", pdSums, SIZE, 0, 1, ' ')+ "\n");
        }
        System.out.println(PositionUtils.Position("TOTAL", totals, SIZE, 0, 1, ' ')+ "\n");
        System.out.println(PositionUtils.Position("KØBET HAR UDLØST " + makers + " MÆRKER", true, SIZE, 0, ' ')+ "\n");
        System.out.println(PositionUtils.Position("MOMS UDGØR", faxs, SIZE, 0, 1, ' ')+ "\n");
    }

    public static void main(String[] arg){
        CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
        cashRegister.printReceipt("bar0.txt");
    }
}


