/*
    Rosa Swierstra RandomCollection
    Implements a weighted random class generator for usage in games and stuff

    methods:
    
    add(whatever, value); adds a type of value
    roll(); retrieve a value from the table
    getTotal(); returns the total value currently in it
    getRarity(); when fed a class, gives you where exactly that class is inside of the map (idk if this works)
*/

package cardLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCollection<E> {
    private List<E> data = new ArrayList<E>();
    private List<Double> lut = new ArrayList<Double>();
    private final Random random;
    private double t = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public RandomCollection<E> add(E item, double weight) {
        if (weight <= 0) return this;
        t += weight;
        lut.add(t);
        data.add(item);
        return this;
    }

    public E roll() {
        double n = random.nextDouble() * t;
        int i = 0;
        while(lut.get(i) < n) i++;
        return data.get(i);
    }

    public double getTotal(){
        return t;
    }

    public double getRarity(E item){
        for(E c : data){
            if(c.equals(item)){
                int i = data.indexOf(c);
                return (lut.get(i) - (i > 0 ? lut.get(i - 1) : 0)) / t;
            }
        }
        return 0.0;
    }
}