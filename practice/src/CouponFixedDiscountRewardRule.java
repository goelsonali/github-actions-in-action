import java.math.BigDecimal;
import java.util.Objects;

public final class CouponFixedDiscountRewardRule extends RewardRule  {
    private final BigDecimal discount;
    private final String couponId;

    public CouponFixedDiscountRewardRule(
            RewardRule.ApplyTo applyTo,
            RewardRule.ApportionTo apportionTo,
            boolean addToTillRewards,
            BigDecimal discount,
            String couponId
    ) {
        super(applyTo, apportionTo, addToTillRewards);
        this.discount = Objects.requireNonNull(discount, "discount must not be null");
        this.couponId = Objects.requireNonNull(couponId, "couponId must not be null");
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getCouponId() {
        return couponId;
    }
}
