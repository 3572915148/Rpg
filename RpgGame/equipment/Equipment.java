package RpgGame.equipment;

public abstract class Equipment {
    private String name;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract EquipmentAttributes getStatus();
}