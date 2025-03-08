public class VendingMachine extends AbstractVendingMachine {

    public VendingMachine() {
        super();
        vmCreation();
    }

    private void vmCreation() {
        String[] products = {"Vanilla", "Chocolate", "Matcha", "Choco Chips", "Cereals",
                "Mixed Fruit Bits", "Raspberry", "Strawberry","Mango"};

        for (int i = 0; i < products.length; i++) {
            if (i < 3 || i > 5) {
                productSlots.add(i, new Slot(products[i], 100, 90, 15));
            } else {
                productSlots.add(i, new Slot(products[i], 45, 40, 15));
            }
        }
    }

    @Override
    public boolean dispenseProduct(int index, int c) {
        if (!(isSlotEmpty(index))) {
            if (productSlots.get(index).getBaseProductPrice() <= getTotalInsertedMoney()) {
                float change = getTotalInsertedMoney() - productSlots.get(index).getBaseProductPrice();
                addToDenomination(denomination, insertedMoney);
                System.out.println("Transaction successful.");
                dispenser(index);
                return true;
            } else {
                System.out.println("Insufficient balance. Unsuccessful transaction.");
            }
        } else {
            System.out.println("Sorry! Item is out of stock.");
        }
        return false;
    }
}
