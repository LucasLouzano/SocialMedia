package ProjetoSocialMedia.SocialMedia.role;
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
//public enum UserRole {
//    ADMIN("ADMIN"),
//    USER("USER");
//    private String role;
//
//    UserRole(String admin, String user) {
//
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
