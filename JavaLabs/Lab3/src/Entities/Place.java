package Entities;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Place {
    private String name;
    private int chaosPoints;
    public ArrayList<Character> guests = new ArrayList<>();

    public Place(String name, int chaosPoints) {
        this.name = name;
        this.chaosPoints = chaosPoints;
    }

    public void addGuest(Character c){
        this.guests.add(c);
    }

    public void removeGuest(Character c){
        this.guests.remove(c);
    }

    public Boolean isCharacterHere(Character c){
        return this.guests.contains(c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(place.name, this.name);
    }
    public String getName() {
        return this.name;
    }

    public void removeChaosPoints(int cleanPoints){
        this.chaosPoints -= cleanPoints;
        System.out.println("Теперь "+this.getName()+" чище на " + cleanPoints + "очков");
        if (this.chaosPoints <= 0){
            System.out.println("Теперь "+ this.name+ "полностью чистое");
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
