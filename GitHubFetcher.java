import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubFetcher {
    public static String getRequest(String username)  {
        try {
            HttpClient client = HttpClient.newHttpClient();

            if (client == null)  {return null;}

            String token = TokenManager.getGitHubToken();

            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/repos/" + username + "/REPO/issues/events"))
                    .header("Accept", "application/vnd.github+json")
                    .header("User-Agent", "mycliapp");

            if (token != null && !token.isEmpty()) {
                builder.header("Authorization", "Bearer " + token);
            }

            HttpRequest request = builder.GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}