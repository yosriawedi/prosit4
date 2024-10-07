package tn.esprit.gestionzoo.entities;

public class Zoo {
    private final int nbrCages = 25; // Nombre maximum d'animaux dans le zoo
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount; // Compteur pour le nombre d'animaux ajoutés

    // Constructor
    public Zoo(String name, String city) {
        this.setName(name);
        this.city = city;
        this.animals = new Animal[nbrCages]; // tn.esprit.gestionzoo.entities.Zoo avec un maximum de 25 animaux
        this.animalCount = 0; // Initialiser le compteur d'animaux à 0
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erreur : Le nom du zoo ne peut pas être vide.");
            this.name = "tn.esprit.gestionzoo.entities.Zoo sans nom"; // Default name if the input is invalid
        } else {
            this.name = name;
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Méthode pour ajouter un animal dans le zoo
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Erreur : Le zoo est plein. Impossible d'ajouter plus d'animaux.");
            return false;
        }

        // Vérifier si l'animal existe déjà dans le zoo
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("Erreur : L'animal " + animal.getName() + " existe déjà dans le zoo.");
                return false;
            }
        }

        // Ajouter l'animal s'il est unique et qu'il reste de la place
        animals[animalCount] = animal;
        animalCount++; // Incrémenter le compteur d'animaux
        System.out.println("L'animal " + animal.getName() + " a été ajouté au zoo.");
        return true;
    }

    // Méthode pour supprimer un animal du zoo
    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                // Décaler tous les animaux suivants d'une case vers la gauche
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[animalCount - 1] = null; // Supprimer le dernier animal
                animalCount--; // Décrémenter le compteur d'animaux
                System.out.println("L'animal " + animal.getName() + " a été supprimé du zoo.");
                return true;
            }
        }
        System.out.println("Erreur : L'animal " + animal.getName() + " n'a pas été trouvé dans le zoo.");
        return false;
    }

    // Méthode pour afficher les informations du zoo
    public void displayZoo() {
        System.out.println("tn.esprit.gestionzoo.entities.Zoo Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of Animals: " + animalCount + "/" + nbrCages);
    }

    // Méthode pour afficher les animaux du zoo
    public void displayAnimals() {
        System.out.println("Liste des animaux dans le zoo : ");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i].toString());
        }
    }

    // Méthode pour rechercher un animal par nom dans le zoo
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i; // Retourne l'indice si l'animal est trouvé
            }
        }
        return -1; // Retourne -1 si l'animal n'est pas trouvé
    }

    // Méthode pour vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    // Méthode pour comparer deux zoos et renvoyer celui avec le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.getAnimalCount() > z2.getAnimalCount()) {
            return z1;
        } else if (z2.getAnimalCount() > z1.getAnimalCount()) {
            return z2;
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
            return null; // Les zoos ont le même nombre d'animaux
        }
    }

    // Surcharge de la méthode toString
    @Override
    public String toString() {
        return "tn.esprit.gestionzoo.entities.Zoo Name: " + name + "\nCity: " + city + "\nNumber of Animals: " + animalCount + "/" + nbrCages;
    }
}
