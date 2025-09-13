import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubFetcher {
    public String getRequest(String username) {

        HttpClient client = HttpClient.newHttpClient();

        String token = TokenManager.getGitHubToken();

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/OWNER/REPO/issues/events"))
                .header("Accept", "application/vnd.github+json")
                .header("User-Agent", "mycliapp")
                .header("X-GitHub-Api-Version", "2022-11-28");

        if (token != null && !token.isEmpty()) {
            builder.header("Authorization", "Bearer " + token);
        }

        HttpRequest request = builder.GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

    }
}