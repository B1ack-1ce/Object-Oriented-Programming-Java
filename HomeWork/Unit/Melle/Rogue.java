package HomeWork.Unit.Melle;

import java.util.ArrayList;

import HomeWork.Unit.Unit;

public class Rogue extends Melee{
    private int numberOfAttack = 2;
    
    public Rogue(String name, int x, int y) {
        super(name, x, y, 70, 3, 10, 60, 70);
    }

    //Имеет двойной ход и возможность при атаке снимать 1 броню
    @Override
    public void step(ArrayList<Unit> targets) {
        if(!isAlive()) return;
        
        Unit target = getCoords().findNearestEnemy(targets, this);
        for (int i = 0; i < numberOfAttack; i++) {
             boolean flag = attack(target);
             if(flag) target.setArmor(-1);
        }
    }

    @Override
    public String getInfo() {
        return String.format("Rogue|HP:%d/%d|Броня:%d|x:%d y:%d|%s", 
                            hp, getMaxHp(), armor, coords.getX(), coords.getY(), getStatus());
    }

    @Override
    public String toString() {
        return "R";
    }
}
