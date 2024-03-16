package matura_2022_02.zad_23;

public class Item implements Comparable<Item>{
    private final String description;
    private final double price;

    public Item(String description, double price) {
        try {
            if (description.isBlank() || price < 0) {
                throw new IllegalArgumentException("Invalid data");
            }
            this.description = description;
            this.price = price;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid data");
        }
    }
    @Override
    public String toString(){
        return String.format("%s (%.2f)", description, price);
    }

    @Override
    public int compareTo(Item i) {
        int strCompare = this.description.compareTo(i.description);
        if(strCompare != 0){
            return strCompare;
        }
        else{
            int priceCompare = Double.compare(this.price, i.price);
            return priceCompare;
        }
    }
}
//description (описание; символен низ) и price (цена; реално число).
