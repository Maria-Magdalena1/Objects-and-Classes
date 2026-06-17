package EntryLevel.TeamworkProjects;

import javax.security.auth.login.CredentialException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTeams = Integer.parseInt(scanner.nextLine());

        List<Team> teams = new ArrayList<>();
        Set<String> creators = new HashSet<>();

        for (int i = 1; i <= countOfTeams; i++) {
            String[] data = scanner.nextLine().split("-");
            String creator = data[0];
            String teamName = data[1];

            boolean teamExists = teams.stream()
                    .anyMatch(t -> t.getName().equals(teamName));

            if (teamExists) {
                System.out.printf("Team %s was already created!%n", teamName);
                continue;
            }

            if (creators.contains(creator)) {
                System.out.println(creator + " cannot create another team!");
                continue;
            }

            Team team = new Team(creator, teamName);
            teams.add(team);

            creators.add(creator);

            System.out.printf("Team %s has been created by %s!%n", teamName, creator);
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            String user = data[0];
            String teamName = data[1];
            Team team = teams.stream()
                    .filter(t -> t.getName().equals(teamName.trim()))
                    .findFirst()
                    .orElse(null);

            if (team == null) {
                System.out.println("Team " + teamName + " does not exist!");
                input = scanner.nextLine();
                continue;
            }

            boolean isMember = teams.stream()
                    .anyMatch(t -> t.getCreator().equals(user) || t.getMembers().contains(user));
            if (isMember) {
                System.out.println("Member " + user + " cannot join team " + teamName + "!");
                input = scanner.nextLine();
                continue;
            }

            team.addMember(user);

            input = scanner.nextLine();
        }

        List<Team> validTeams = teams.stream()
                .filter(t -> !t.getMembers().isEmpty())
                .sorted(Comparator.comparingInt(Team::getSize).reversed()
                        .thenComparing(Team::getName))
                .collect(Collectors.toList());

        List<Team> disbanded = teams.stream()
                .filter(t -> t.getMembers().isEmpty())
                .sorted(Comparator.comparing(Team::getName))
                .collect(Collectors.toList());

        for (Team t : validTeams) {
            System.out.println(t.getName());
            System.out.println("- " + t.getCreator());
            t.getMembers().stream().sorted()
                    .forEach(m -> System.out.println("-- " + m));
        }

        System.out.println("Teams to disband:");
        for (Team t : disbanded) {
            System.out.println(t.getName());
        }
    }
}
