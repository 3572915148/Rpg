package RpgGame.interfaces;

public interface Fight_I<T> {
    public void attack(Fight_I<T> hurtCharacter);

    public void getHurt(Integer damage);

}
