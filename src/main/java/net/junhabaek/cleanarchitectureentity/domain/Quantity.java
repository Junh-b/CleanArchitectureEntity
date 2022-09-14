package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

public class Quantity {
    public static Quantity ZERO = Quantity.of(0L);

    @Getter
    private BigInteger quantity;

    public Quantity plus(Quantity other){
        return new Quantity(this.quantity.add(other.quantity));
    }
    public Quantity minus(Quantity other) {
        return new Quantity(this.quantity.subtract(other.quantity));
    }
    public Quantity multiply(Long times) {
        return new Quantity(this.quantity.multiply(BigInteger.valueOf(times)));
    }

    private Quantity(){
        this.quantity = BigInteger.ZERO;
    }

    public Quantity(BigInteger amount) {
        if(amount == null || amount.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalStateException("Quantity can not have minus value.");
        }

        this.quantity = amount;
    }

    public static Quantity of(Long value){
        return new Quantity(BigInteger.valueOf(value));
    }
}
