package RpgGame.equipment;

public class Defense extends Equipment {
    public Integer defensePower;

    public Defense(String name, Integer defensePower) {
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
