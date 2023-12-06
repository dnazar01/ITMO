package Entities;

import Enums.Feelings;
import Interfaces.*;

public class Provocateur extends Character implements Flyable {
    private int moneyOnWallet = 200;

    public Provocateur() {
        super("Карлсон");
    }

    public void buy(Fruit fruit) {
        if (this.moneyOnWallet - fruit.getPrice() >= 0) {
            System.out.println(super.getName() + " купил фрукт " + fruit.getName());
            this.moneyOnWallet -= fruit.getPrice();
        } else {
            System.out.println("У " + this.getName() + " недостаточно средств");
        }
    }

    public void seemEarnestly() {
        System.out.println(super.getName() + " показалось это убедительно");
        this.setState(Feelings.SOLID);
    }

    public void fly(Place place) {
        super.setLocation(place);
        System.out.println(super.getName() + " прилетел в " + place.getName());
    }

    @Override
    public void seat(Place place) {
        this.setLocation(place);
        if (place.getClass() == Fireplace.class) {
            System.out.println(super.getName() + " сидит у камина в Домике на крыше");
            Boolean flag = Boolean.TRUE;
            if (!place.guests.isEmpty()) {
                for (Character guest : place.guests) {
                    if (guest.getClass() == Housekeeper.class) {
                        this.setState(Feelings.SAD);
                        System.out.println("Потому что рядом есть " + guest.getName());
                        flag = Boolean.FALSE;
                    }
                }
            }
            if (flag){
                this.setState(Feelings.GOOD);
                this.setState(Feelings.COSY);
                this.setState(Feelings.CALM);
                System.out.println("Потому что рядом нет Фрекен Бок");
            }
        } else {
            System.out.println(super.getName() + " сидит в " + place.getName());
        }
    }
}
