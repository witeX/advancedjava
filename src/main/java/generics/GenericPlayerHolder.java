package generics;

import objects.Player;

public class GenericPlayerHolder<T extends Player> {
    private T player;

    public GenericPlayerHolder(T player) {
        this.player = player;
    }

    public T getPlayer() {
        return player;
    }

    public void setPlayer(T player) {
        this.player = player;
    }

    public void move(String direction) {
        player.move(direction);
    }
}
