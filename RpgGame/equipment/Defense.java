package RpgGame.equipment;

public class Defense extends Equipment {
    public int defensePower;

    public Defense(String name, int defensePower) {
        super(name);
        this.defensePower = defensePower;
    }

    public Integer getDefense() {
        return defensePower;
    }

    public EquipmentAttributes getStatus() {
        return new EquipmentAttributes(0, 0, this.defensePower);
    }
}
