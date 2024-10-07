package tn.esprit.gestionzoo.entities;

public class Animal {
    private String name;
    private String family;
    private int age;
    private boolean isMammal;

    // Constructor
    public Animal(String name, String family, int age, boolean isMammal) {
        this.name = name;
        this.family = family;
        setAge(age);
        this.isMammal = isMammal;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsMammal() {
        return isMammal;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    // Restrict age to non-negative values
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Erreur : L'âge ne peut pas être négatif.");
            this.age = 0; // Default to 0 if the input is negative
        } else {
            this.age = age;
        }
    }

    public void setIsMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    // Surcharge de la méthode toString
    @Override
    public String toString() {
        return "tn.esprit.gestionzoo.entities.Animal Name: " + name + "\nFamily: " + family + "\nAge: " + age + "\nIs Mammal: " + isMammal;
    }
}

