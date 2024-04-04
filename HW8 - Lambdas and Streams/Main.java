import java.time.Year;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        SchulMember[] schulMembers = {
                new SchulMember("Smith", "Levi", 1999, "Keren", "Smith", new String[]{"Rivka", "Margo"}, 2),
                new SchulMember("Lazar", "Rachel", 1983, "Yakov", "Lazar", new String[]{"Ariel", "David"}, 12),
                new SchulMember("Black", "Yitzchok", 1984, "Miriam", "Black", new String[]{"Chana", "Chaya", "Dovi"}, 1),
                new SchulMember("Fisher", "Liza", 1981, "Chaim", "Fisher", new String[]{"Leah", "Jason"}, 11),
        };

        // printing the number of families in the schul
        Consumer<SchulMember[]> printFamiliesCount = members -> System.out.println("Number of families in the schul: " +
                Arrays.stream(members)
                        .map(member -> member.getLastNameOfMember())
                        .distinct()
                        .count());

        // printing the length of membership for each family, sorted
        Consumer<SchulMember[]> printMembershipLength = members -> {
            Arrays.stream(members)
                    .sorted(Comparator.comparingInt(SchulMember::getYearsOfMembership))
                    .forEach(member -> System.out.println(member.getLastNameOfMember() + ": " + member.getYearsOfMembership() + " years"));
        };

        // printing the ages of members
        Consumer<SchulMember[]> printAges = members -> {
            int currentYear = Year.now().getValue();
            Arrays.stream(members)
                    .sorted(Comparator.comparingInt(member -> currentYear - member.getBirthDateOfMember()))
                    .forEach(member -> System.out.println(member.getFirstNameOfMember() + " " + member.getLastNameOfMember() + ": " +
                            (currentYear - member.getBirthDateOfMember()) + " years old"));
        };

        // sorting the names of spouses of all members
        Function<SchulMember[], String[]> sortSpouseNames = members -> {
            return Arrays.stream(members)
                    .map(member -> member.getSpouseFirstName() + " " + member.getSpouseLastName())
                    .sorted()
                    .toArray(String[]::new);
        };

        // printing families with more than three children
        Consumer<SchulMember[]> printFamiliesWithMoreThanThreeChildren = members -> {
            Arrays.stream(members)
                    .filter(member -> member.getChildrenNames().length > 3)
                    .map(member -> member.getLastNameOfMember() + " family")
                    .forEach(System.out::println);
        };

        // printing children names larger than 'c' and their families
        Consumer<SchulMember[]> printChildrenNames = members -> {
            Arrays.stream(members)
                    .flatMap(member -> Arrays.stream(member.getChildrenNames())
                            .filter(name -> name.compareToIgnoreCase("c") > 0)
                            .map(name -> name + " is from the " + member.getLastNameOfMember() + " family"))
                    .forEach(System.out::println);
        };

        // executing the consumers with the schulMembers array
        printFamiliesCount.accept(schulMembers);
        printMembershipLength.accept(schulMembers);
        printAges.accept(schulMembers);
        printFamiliesWithMoreThanThreeChildren.accept(schulMembers);
        printChildrenNames.accept(schulMembers);
    }
}

