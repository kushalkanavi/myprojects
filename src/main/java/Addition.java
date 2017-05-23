/**
 * Created by kushalkanavi on 5/19/17.
 */
public final class Addition<T extends Number> {
    private T a;
    private T b;

    public Addition(T a , T b) {
        this.a = a;
        this.b = b;
    }

    public double sum() {
        return a.doubleValue() + b.doubleValue();
    }
}
