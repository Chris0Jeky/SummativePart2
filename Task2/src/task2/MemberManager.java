package task2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemberManager {

    private static List<Member> members;

    public MemberManager(List<Member> members) {
        this.members = members;
    }

    public static Member selectMember(Scanner scanner) {
        System.out.println("Select a member:");
        int memberChoice = -1;
        do {
            for (int i = 0; i < members.size(); i++) {
                System.out.println((i + 1) + ". " + members.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            memberChoice = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character

            if (memberChoice < 0 || memberChoice >= members.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (memberChoice < 0 || memberChoice >= members.size());

        return members.get(memberChoice);
    }

    public static JuniorMember selectJuniorMember(Scanner scanner) {
        System.out.println("Select a junior member:");
        List<JuniorMember> juniorMembers = members.stream()
                .filter(m -> m instanceof JuniorMember)
                .map(m -> (JuniorMember) m)
                .collect(Collectors.toList());
        int juniorMemberChoice = -1;
        do {
            for (int i = 0; i < juniorMembers.size(); i++) {
                System.out.println((i + 1) + ". " + juniorMembers.get(i).getName());
            }
            System.out.print("Enter your choice: ");
            juniorMemberChoice = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character

            if (juniorMemberChoice < 0 || juniorMemberChoice >= juniorMembers.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (juniorMemberChoice < 0 || juniorMemberChoice >= juniorMembers.size());

        return juniorMembers.get(juniorMemberChoice);
    }
}
