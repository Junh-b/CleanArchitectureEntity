package net.junhabaek.cleanarchitectureentity.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.math.BigInteger;

@Embeddable
public class Quantity {
    @Transient
    public final static Quantity ZERO = Quantity.of(0L);

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

    protected Quantity(){
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