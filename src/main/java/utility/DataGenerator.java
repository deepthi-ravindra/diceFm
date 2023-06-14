package utility;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private final int FIRSTNAME_MAX = 12;
    private final int LASTNAME_MAX = 17;
    private final int COMPANY_MAX = 32;
    private final int CONTACT_MAX = 30;
    private final int ADDRESSONE_MAX = 32;
    private final int ADDRESSTWO_MAX = 32;
    private final int TOWN_MAX = 22;
    private Faker faker;
    private Locale locale;


    public DataGenerator(Locale locale) {
        this.locale = locale;
        faker = new Faker(locale);
    }

    public DataGenerator() {
        this(new Locale("en-GB"));


    }

    /**
     * Get a random number
     *
     * @param min minimum number
     * @param max maximum number
     * @return actual number
     */
    public static int getRandomNumber(int min, int max) {
        return ((int) (Math.random() * (max - min))) + min;
    }

    public static long getLongRandomNumber(long min, long max) {
        return Math.abs(Float.valueOf(new Random().nextFloat() * (max - min)).longValue());
    }

    public static String getRandomNumberString(int min, int max) {
        String valueNumber;
        int number;
        number = (int) (Math.random() * max + 1);
        if (String.valueOf(number).length() == 1)
            valueNumber = "0" + number;
        else
            return String.valueOf(number);
        return valueNumber;
    }

    /**
     * Get a random string
     *
     * @param len number or chars
     * @return string
     */
    public static String getRandomString(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, '?');
        String stringToRandomise = new String(chars);
        return new Faker().letterify(stringToRandomise);
    }

    /**
     * Gets a persons first line of address
     *
     * @return - a persons first line of address
     */
    public String getStreetAddress() {

        String address;
        do {
            address = faker.address().streetAddress();
        } while (address.length() > ADDRESSONE_MAX);
        return address;
    }

    /**
     * Gets a persons second line of address
     *
     * @return - a persons second line of address
     */
    public String getSecondaryAddress() {

        String addressTwo;
        do {
            addressTwo = faker.address().secondaryAddress();
        } while (addressTwo.length() > ADDRESSTWO_MAX);
        return addressTwo;
    }

    /**
     * Gets a company
     *
     * @return - a company
     */
    public String getCompany() {

        String company;
        do {
            company = faker.company().name();
        } while (company.length() > COMPANY_MAX);
        return company;
    }

    /**
     * Gets company Id
     *
     * @return - company idenity code
     */
    public String getCompanyId() {
        return faker.finance().bic();
    }

    /**
     * Gets a persons full name
     *
     * @return - a persons full name
     */
    public String getContactName() {
        String contact;
        do {
            contact = faker.name().name();
        } while (contact.length() > CONTACT_MAX);
        return contact;
    }

    /**
     * Gets a persons email address
     *
     * @return - a persons email address
     */
    public String getEmail(String baseStore) {
        return "auto-" + baseStore.toLowerCase() + "-test" + Utilities.getTimeStamp() + "@od.com";
    }

    /**
     * Gets employee count
     *
     * @return - employee count of a company
     */
    public int getEmployeeCount() {

        return faker.number().numberBetween(1, 500);
    }

    /**
     * Gets a persons First Name
     *
     * @return - a persons first name
     */
    public String getFirstName() {
        String firstName;
        do {
            firstName = faker.name().firstName();
        } while (firstName.length() > FIRSTNAME_MAX);
        return firstName;
    }

    /**
     * Gets a persons last name
     *
     * @return - a persons last name
     */
    public String getLastName() {
        String lastName;
        do {
            lastName = faker.name().lastName();
        } while (lastName.length() > LASTNAME_MAX);
        return lastName;
    }

    /**
     * Gets a persons phone number
     *
     * @return - a persons phone number
     */
    public String getPhoneNumber() {
        return faker.numerify("0#########");
    }

    /**
     * Gets a postcode
     *
     * @return - a postcode
     */
    public String getPostCode() {
        if (locale.equals(Locale.UK))
            return "MK9 1AQ";
        else if (locale.equals(Locale.ENGLISH))
            return "A56 F4E2";
        else if (locale.getCountry().equals("NL")) {
            return "1000 NL";
        } else if ((locale.getCountry().equals("BE")) || (locale.getCountry().equals("LU"))) {
            return "7899";
        } else
            return faker.address().zipCode();
    }

    /**
     * Gets a Town
     *
     * @return - a town
     */
    public String getCity() {
        String town;
        do {
            town = faker.address().cityName();
        } while (town.length() > TOWN_MAX);
        return town;
    }
}
