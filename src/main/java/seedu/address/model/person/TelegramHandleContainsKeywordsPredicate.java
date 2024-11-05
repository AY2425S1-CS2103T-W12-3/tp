package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code TeleHandle} matches any of the keywords given.
 */
public class TelegramHandleContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public TelegramHandleContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        String telegramHandle = person.getTelegramHandle().value.toLowerCase();
        return keywords.stream()
                .map(String::toLowerCase)
                .anyMatch(telegramHandle::equals)
                .orElse(false);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TelegramHandleContainsKeywordsPredicate)) {
            return false;
        }

        TelegramHandleContainsKeywordsPredicate otherTelegramHandleContainsKeywordsPredicate =
            (TelegramHandleContainsKeywordsPredicate) other;
        return keywords.equals(otherTelegramHandleContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
