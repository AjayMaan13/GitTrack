import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Github Username: ");
        String gid = sc.nextLine();
        System.out.println("Github Username: " + gid);

        try {
            String response = GitHubFetcher.getRequest(gid);
            System.out.println("Github Response: " + response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}