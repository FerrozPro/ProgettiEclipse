package it.ferroz.pitagora;

public interface Numeric {

    boolean isLessThan(double v);
    boolean isGreaterThan(double v);

    <T extends Numeric> T multiply(T x);
}
