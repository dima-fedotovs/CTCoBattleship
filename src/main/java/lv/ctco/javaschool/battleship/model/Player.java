package lv.ctco.javaschool.battleship.model;

import java.io.Serializable;

public class Player implements Serializable {
    public static final long serialVersionUID = 1;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
