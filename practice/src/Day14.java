import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Day14 {

    public static void task() {
        //streams and limit
        List<Integer> numbers = List.of(1,3,4,5,6,7,8,10,2);
        List<Integer> results = numbers.stream().filter(i -> i%2==0).limit(3).toList();
        System.out.println("Limited to 3 even numbers: " + results);

        //takeWhile

        results = numbers.stream().sorted().takeWhile( n -> n<= 5).toList();
        System.out.println("Numbers less than 5: " + results);

        //In your scratchpad (or a separate repo/branch), implement pure Java method:
        //Input: List<RewardRule> rewardRules, Class<T extends RewardRule> type
        //Output: Optional<T> (the first non-null rule of that type)
        List<RewardRule> rewardRules = List.of(new CouponFixedDiscountRewardRule(new RewardRule.ApplyTo(List.of("rule1"), RewardRule.Selection.CHEAPEST, 1), new RewardRule.ApportionTo(List.of("rule1")), true, BigDecimal.valueOf(100), "couponId1"),
                new FixedRewardRule(new RewardRule.ApplyTo(List.of("rule1"), RewardRule.Selection.CHEAPEST, 1), new RewardRule.ApportionTo(List.of("rule1")), true, BigDecimal.valueOf(100)));

        Optional<FixedRewardRule> fixedRule = RewardRules.findFirstRewardRule(rewardRules, FixedRewardRule.class);
        fixedRule.ifPresent(rule -> System.out.println("Found fixed reward rule: " + rule.getPrice()));

    }

    static void main(String[] args) {
        task();

    }

    final class RewardRules {
        private RewardRules() {}

        public static <T extends RewardRule> Optional<T> findFirstRewardRule(List<RewardRule> rewardRules, Class<T> type) {
            return rewardRules.stream().filter(Objects::nonNull).filter(type::isInstance).map(type::cast).findFirst();
        }

    }
}
