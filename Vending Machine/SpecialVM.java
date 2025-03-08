public class SpecialVM extends VendingMachine {
    int specialsSold = 0;

    private String[] sauce = {"Chocolate Sauce", "Strawberry Sauce", "Caramel Sauce"};
    private String[] toppings = {"Rainbow Sprinkle"};
    private float[] specialPrices = {150,150,150,150,150,150,150,150,150};

    public SpecialVM() {
        super();
        for (int i = 9; i < 13; i++) {
            if (i < 12) {
                productSlots.add(new Slot(sauce[i - 9], 15, 15));
            } else {
                productSlots.add(new Slot(toppings[i - 12], 10, 15));
            }
        }
    }

    @Override
    public boolean dispenseProduct(int index, int c) {
        if (c == 1) {
            return super.dispenseProduct(index, c);
        } else if (c == 2) {
            if (customProductChecker(index)) {
                transaction(specialPrices[index], "Custom Special");
                return true;
            } else {
                System.out.println("Sorry! Ingredients needed are out of stock.");
            }
        }
        return false;
    }
}
