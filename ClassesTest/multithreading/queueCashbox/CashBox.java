package multithreading.queueCashbox;

public class CashBox {
    private static int staticId = 0;
    private int id;

    public CashBox() {
        synchronized (CashBox.class) {
            staticId++;
        }
        this.id = staticId;
    }

    @Override
    public String toString() {
        return "CashBox{" +
                "id=" + id +
                '}';
    }
}
