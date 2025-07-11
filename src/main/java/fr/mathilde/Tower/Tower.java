package fr.mathilde.Tower;

import fr.mathilde.Aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    };

    public void register(Flyable p_flyable){
        this.observers.add(p_flyable);
    };
    public void unregister(Flyable p_flyable){};
    protected void conditionChange(){
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    };
}
