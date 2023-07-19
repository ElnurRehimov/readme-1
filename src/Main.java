public class Main {
    static {
        System.out.println("Loading Main class...");
    }

    {
        System.out.println("Creating a new object of Main...");
    }

    public static void main(String[] args) {
        Human mother = new Human("Xanim", "Memmedova", 30, 120);
        Human father = new Human("Osman", "Memmedov", 35, 130);
        Family family = new Family(mother, father);

        Human child1 = new Human("Murad", "Memmedov", 10, 110);
        Human child2 = new Human("Samir", "Memmedov", 8, 115);

        family.addChild(child1);
        family.addChild(child2);

        Pet pet = new Pet("Alabash", 3);
        family.setPet(pet);

        System.out.println(family);

        family.deleteChild(child1);

        System.out.println(family);

        System.out.println("Family members: " + family.countFamily());
    }
}