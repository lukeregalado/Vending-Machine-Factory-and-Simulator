import java.util.ArrayList;

/**
 * Abstract superclass for all vending machines.
 */
public abstract class AbstractVendingMachine {
    protected Denomination denomination;
    protected final ArrayList<Slot> productSlots;
    protected Denomination insertedMoney;

    public AbstractVendingMachine() {
        this.productSlots = new ArrayList<>();
        this.denomination = new Denomination();
        this.insertedMoney = new Denomination();
    }

    public void setInsertedMoney(Denomination denomination) {
        this.insertedMoney = denomination;
    }

    public float getTotalInsertedMoney() {
        return this.insertedMoney.getTotalMoney();
    }

    protected void dispenser(int index) {
        productSlots.get(index).setNumProductsSold(1);
        productSlots.get(index).getProducts().remove(0);
    }

    public void addToDenomination(Denomination to, Denomination from) {
        to.setThousandPesoBill(from.getThousandPesoBill());
        to.setFiveHundredPesoBill(from.getFiveHundredPesoBill());
        to.setTwoHundredPesoBill(from.getTwoHundredPesoBill());
        to.setOneHundredPesoBill(from.getOneHundredPesoBill());
        to.setFiftyPesoBill(from.getFiftyPesoBill());
        to.setTwentyPesoBill(from.getTwentyPesoBill());
        to.setTwentyPesoCoin(from.getTwentyPesoCoin());
        to.setTenPesoCoin(from.getTenPesoCoin());
        to.setFivePesoCoin(from.getFivePesoCoin());
        to.setOnePesoCoin(from.getOnePesoCoin());
    }

    public abstract boolean dispenseProduct(int index, int c);
}
