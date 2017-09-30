package hautelook;

public class Discount {

    private final String code;
    private final int percent;

    public Discount(String code, int percent) {
        this.code = code;
        this.percent = percent;
    }

    public String getCode() {
        return code;
    }

    public int getPercent() {
        return percent;
    }
}
