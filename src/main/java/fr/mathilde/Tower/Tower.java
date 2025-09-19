package fr.mathilde.Tower;

import fr.mathilde.Aircraft.Flyable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable){
        this.observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
    }

    public void getTower() {
        for (Flyable p_flyable : this.observers)
        {
            System.out.println("Tower says: " + p_flyable.getClass().getSimpleName()
                    + "#" + p_flyable.getName() + "("
                    + Long.toString(p_flyable.getId()) + ")"
                    + " registered to weather tower.");
        }
    }

    protected void conditionChange(){
        List<Flyable> removed = new ArrayList<>();
        for (Flyable observer : observers) {
            try {
                observer.updateConditions();
            }
            catch (Exception InvalidLessHeight) {
                System.out.println(InvalidLessHeight.getMessage());
                removed.add(observer);
            }
        }
        for (Flyable remove : removed) {
            this.unregister(remove);
        }
    }
}
