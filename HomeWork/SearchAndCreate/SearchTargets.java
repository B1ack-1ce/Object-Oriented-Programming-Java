package HomeWork.SearchAndCreate;

import java.util.ArrayList;

import HomeWork.Unit.Countryman;
import HomeWork.Unit.Status;
import HomeWork.Unit.Unit;
import HomeWork.Unit.Shooter.Shooter;

public class SearchTargets {
    //Поиск союзного, живого и свободного крестьянина
    public static Countryman findFrendlyCM(ArrayList<Unit> allUnits, Unit unit){
        for (Unit target : allUnits) {
            if(target instanceof Countryman && target.getStatus() == Status.Stand && target.team == unit.team){
                return (Countryman) target;
            }
        }
        return null;
    }

    //Поиск союзного дальняка с пустым запасом
    public static Shooter findNotFullShooter(ArrayList<Unit> allUnits, Unit unit){
        for (Unit target : allUnits) {
            if(target instanceof Shooter && target.getStatus() != Status.Dead && target.team == unit.team){
                var tmp = (Shooter)target;
                if(!tmp.isWaitCountry && tmp.isEmptyStock()){
                    return tmp;
                }
                continue;
            }
        }
        return null;
    }

    //Поиск союзного юнита с неполным здоровьем
    public static Unit findFrendlyUnitWithNotFullHp(ArrayList<Unit> allUnits, Unit unit){
        for (Unit target : allUnits) {
            if(target.getStatus() != Status.Dead && target.team == unit.team && target.getHp() < target.getMaxHp()){
                return target;
            }
        }
        return null;
    }
}
