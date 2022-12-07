public class PasswordInfo {
    private String url;
    private String userId;
    private String password;

    PasswordInfo(String url, String id, String pw) {
        this.url = url;
        userId = id;
        password = pw;
    }

    String getUrl() { return url; }
    String getUserId() { return userId; }
    String getPassword() { return password; }

    void setUrl(String url) {
        this.url = url;
    }

    void setUserId(String id) {
        this.userId = id;
    }

    void setPassword(String pw) {
        this.password = pw;
    }

    public String toString() {
        return "" + url + ", " + userId + ", " + password;
    }
}
