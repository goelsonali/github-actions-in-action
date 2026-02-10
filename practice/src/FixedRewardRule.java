import java.math.BigDecimal;

public final class FixedRewardRule extends RewardRule {

    private BigDecimal price;


    public FixedRewardRule(ApplyTo applyTo, ApportionTo apportionTo, boolean addToTillRewards,BigDecimal price) {
        super(applyTo, apportionTo, addToTillRewards);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
