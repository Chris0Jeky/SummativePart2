package task2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static task2.ApplicationRunner.readIntInRange;

public class MemberManager {

    private static List<Member> members;

    public MemberManager(List<Member> members) {
        this.members = members;
    }

    public static Member selectMember(Scanner scanner) {
        int memberChoice;
        do {
            System.out.println("Select a member for the booking:");
            for (int i = 0; i < members.size(); i++) {
                System.out.println((i + 1) + ". " + members.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            memberChoice = readIntInRange(scanner, 1, members.size()) - 1; // Read the user's choice
            scanner.nextLine(); // Consume the newline character

            if (memberChoice < 0 || memberChoice >= members.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (memberChoice < 0 || memberChoice >= members.size());

        return members.get(memberChoice);
    }

    public static JuniorMember selectJuniorMember(Scanner scanner) {
        int juniorMemberChoice;
        List<JuniorMember> juniorMembers;
        do {
            System.out.println("Select a junior member:");
            juniorMembers = members.stream()
                    .filter(m -> m instanceof JuniorMember)
                    .map(m -> (JuniorMember) m)
                    .collect(Collectors.toList());
            for (int i = 0; i < juniorMembers.size(); i++) {
                System.out.println((i + 1) + ". " + juniorMembers.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            juniorMemberChoice = readIntInRange(scanner, 1, juniorMembers.size()) - 1; // Read the user's choice
            scanner.nextLine(); // Consume the newline character

            if (juniorMemberChoice < 0 || juniorMemberChoice >= juniorMembers.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (juniorMemberChoice < 0 || juniorMemberChoice >= juniorMembers.size());

        return juniorMembers.get(juniorMemberChoice);
    }
}
