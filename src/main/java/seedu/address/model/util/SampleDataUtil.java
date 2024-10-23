package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.ContactType;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.TelegramHandle;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new ContactType("WORK"), new Name("Alex Yeoh"), new Phone("87438807"),
                    new Email("alexyeoh@example.com"), new TelegramHandle("@Alexyeoh"),
                getTagSet("friends"), new Remark("")),
            new Person(new ContactType("WORK"), new Name("Bernice Yu"), new Phone("99272758"),
                    new Email("berniceyu@example.com"), new TelegramHandle("@Berner"),
                getTagSet("colleagues", "friends"), new Remark("")),
            new Person(new ContactType("WORK"), new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new Email("charlotte@example.com"), new TelegramHandle("@Charlotte"),
                getTagSet("neighbours"), new Remark("")),
            new Person(new ContactType("WORK"), new Name("David Li"), new Phone("91031282"),
                    new Email("lidavid@example.com"), new TelegramHandle("@David2"),
                getTagSet("family"), new Remark("")),
            new Person(new ContactType("WORK"), new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new Email("irfan@example.com"), new TelegramHandle("@Irfan2"),
                getTagSet("classmates"), new Remark("")),
            new Person(new ContactType("WORK"), new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new Email("royb@example.com"), new TelegramHandle("@RoyBala"),
                getTagSet("colleagues"), new Remark(""))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
