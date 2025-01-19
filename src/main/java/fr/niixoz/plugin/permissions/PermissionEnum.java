package fr.niixoz.plugin.permissions;

public enum PermissionEnum {

    PERMISSION_ALL("better_beacon.*"),
    ;

    private String permission;

    PermissionEnum(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
