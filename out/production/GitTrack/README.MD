# GitTrack

A simple Java CLI tool that fetches and displays recent GitHub user activity directly in your terminal.

## 🚀 Features
- Fetches recent public events of any GitHub user.
- Displays activity such as commits, issues, stars, etc.
- Handles invalid usernames and API errors gracefully.
- Runs entirely in the terminal — no external libraries required for HTTP.

## 🛠️ Usage
```bash
# Compile
javac Main.java

# Run
java Main <github-username>

# Example
java Main torvalds
```

## 📡 API Reference
This project uses the [GitHub Events API](https://docs.github.com/en/rest/activity/events?apiVersion=2022-11-28)  
Endpoint used:
```
https://api.github.com/users/<username>/events
```

## 📌 Future Improvements
- Add filtering by event type (commits, issues, stars, etc.)
- Display results in a table format for better readability.
- Cache results to avoid hitting rate limits.

## ⚠️ Notes
- GitHub API is rate-limited (60 requests/hour without authentication).
- Works only for public activity.
