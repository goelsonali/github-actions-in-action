import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class RewardRule {

        private final ApplyTo applyTo;
        private final ApportionTo apportionTo;
        private final boolean addToTillRewards;

        protected RewardRule(ApplyTo applyTo, ApportionTo apportionTo, boolean addToTillRewards) {
            this.applyTo = Objects.requireNonNull(applyTo, "applyTo must not be null");
            this.apportionTo = apportionTo; // optional
            this.addToTillRewards = addToTillRewards;
        }

        public ApplyTo getApplyTo() {
            return applyTo;
        }

        public ApportionTo getApportionTo() {
            return apportionTo;
        }

        public boolean isAddToTillRewards() {
            return addToTillRewards;
        }

        /**
         * Schemes that this reward rule is associated with (e.g., Clubcard).
         * Default: none.
         */
        public Set<String> findSchemes() {
            return Collections.emptySet();
        }

        public static final class ApplyTo {
            private final List<String> conditionIds;
            private final Selection selection;
            private final Integer maxApplications;

            public ApplyTo(List<String> conditionIds, Selection selection, Integer maxApplications) {
                this.conditionIds = Collections.unmodifiableList(Objects.requireNonNull(conditionIds, "conditionIds must not be null"));
                this.selection = Objects.requireNonNull(selection, "selection must not be null");
                this.maxApplications = maxApplications;
            }

            public List<String> getConditionIds() {
                return conditionIds;
            }

            public Selection getSelection() {
                return selection;
            }

            public Integer getMaxApplications() {
                return maxApplications;
            }
        }

        public static final class ApportionTo {
            private final List<String> conditionIds;

            public ApportionTo(List<String> conditionIds) {
                this.conditionIds = Collections.unmodifiableList(Objects.requireNonNull(conditionIds, "conditionIds must not be null"));
            }

            public List<String> getConditionIds() {
                return conditionIds;
            }
        }

        public enum Selection {
            CHEAPEST,
            DEAREST
        }
}
