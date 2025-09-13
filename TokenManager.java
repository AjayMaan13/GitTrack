import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TokenManager {
    public String getGitHubToken() {
        String token = System.getenv("GITHUB_TOKEN");
        if (token != null && !token.isEmpty()) {
            return token;
        }

        try (FileInputStream fis = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(fis);
            token = props.getProperty("GITHUB_TOKEN");
            if (token != null && !token.isEmpty()) {
                return token;
            }
        } catch (IOException e) {
            // Ignore, we'll handle null token below
        }

        // No token found
        System.out.println("⚠️ No GitHub token found. Continuing without authentication (limited to 60 requests/hour).");
        return null;
    }
}
