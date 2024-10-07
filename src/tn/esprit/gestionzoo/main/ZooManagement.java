package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        Animal lion = new Animal("Lion", "Felidae", -2, true);
        Animal tiger = new Animal("Tiger", "Felidae", 3, true);
        Animal elephant = new Animal("Elephant", "Elephantidae", 5, true);
        Animal zebra = new Animal("Zebra", "Equidae", 4, true);


        Zoo myZoo1 = new Zoo(" ", "Tunis");
        Zoo myZoo2 = new Zoo("Wild Park", "Sousse");


        myZoo1.addAnimal(lion);
        myZoo1.addAnimal(tiger);
        myZoo2.addAnimal(elephant);
        myZoo2.addAnimal(zebra);


        System.out.println("\nAnimaux dans le zoo 1 :");
        myZoo1.displayAnimals();

        System.out.println("\nAnimaux dans le zoo 2 :");
        myZoo2.displayAnimals();


        myZoo1.removeAnimal(lion);


        Zoo largerZoo = Zoo.comparerZoo(myZoo1, myZoo2);
        if (largerZoo != null) {
            System.out.println("\nLe zoo avec le plus d'animaux est : " + largerZoo.getName());
        }


        System.out.println("\nInformations sur le zoo 1 :");
        myZoo1.displayZoo();

        System.out.println("\nInformations sur le zoo 2 :");
        myZoo2.displayZoo();
    }
}
