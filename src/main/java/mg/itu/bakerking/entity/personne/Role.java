package mg.itu.bakerking.entity.personne;

public enum Role {
    ADMIN("Admin"),
    USER("Utilisateur");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}