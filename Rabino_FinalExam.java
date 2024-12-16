import java.util.Stack; // Importing the Stack class from the Java utility package

// Class representing a creature with a name and power level
class Creature {
    String name; // Name of the creature
    int powerLevel; // Power level of the creature

    // Constructor to initialize a creature with a name and power level
    public Creature(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }
}

public class Rabino_FinalExam {
    public static void main(String[] args) {
        // Creating an array of Creature objects with different names and power levels
        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        // Sort creatures in descending order by power level using bubble sort
        descendingOrder(creatures);
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        displayCreatures(creatures); // Display the sorted creatures
        System.out.print("\n");

        // Sort creatures in ascending order by power level using selection sort
        ascendingOrder(creatures);
        System.out.println("*** Selection Sort: Ascending Order by Power Level ***");
        displayCreatures(creatures); // Display the sorted creatures
        System.out.print("\n");

        // Create a stack to hold the creatures
        Stack<Creature> creatureStack = new Stack<>();
        // Push all creatures onto the stack after sorting them in ascending order
        ascendingOrder(creatures);
        for (Creature creature : creatures) {
            creatureStack.push(creature); // Push each creature onto the stack
        }

        // Display the creatures as they are popped from the stack
        System.out.println("*** Stack Implementation: Popping Creatures ***");
        while (!creatureStack.isEmpty()) { // While the stack is not empty
            Creature creature = creatureStack.pop(); // Pop the top creature from the stack
            System.out.println("Popped: " + creature.name + " - " + creature.powerLevel); // Display the popped creature
        }
    }

    // Method to sort creatures in descending order using bubble sort
    public static void descendingOrder(Creature[] creatures) {
        int d = creatures.length; // Get the number of creatures
        for (int i = 0; i < d - 1; i++) { // Outer loop for bubble sort
            for (int j = 0; j < d - 1; j++) { // Inner loop for comparing adjacent elements
                // If the current creature's power level is less than the next, swap them
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    Creature adInterim = creatures[j]; // Temporary variable for swapping
                    creatures[j] = creatures[j + 1]; // Swap the creatures
                    creatures[j + 1] = adInterim; // Complete the swap
                }
            }
        }
    }

    // Method to sort creatures in ascending order using selection sort
    public static void ascendingOrder(Creature[] creatures) {
        int d = creatures.length; // Get the number of creatures
        for (int i = 0; i < d - 1; i++) { // Outer loop for selection sort
            int minIndex = i; // Assume the first unsorted element is the minimum
            for (int j = i + 1; j < d; j++) { // Inner loop to find the minimum element
                // If a smaller power level is found, update minIndex
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j; // Update the index of the minimum element
                }
            }
            // Swap the found minimum element with the first unsorted element
            Creature adInterim = creatures[minIndex]; // Temporary variable for swapping
            creatures[minIndex] = creatures[i]; // Swap the minimum with the first unsorted
            creatures[i] = adInterim; // Complete the swap
        }
    }

    // Method to display the details of all creatures
    public static void displayCreatures(Creature[] creatures) {
        for (Creature creature : creatures) { // Loop through each creature
            System.out.println(creature.name + " - " + creature.powerLevel); // Print the name and power level
        }
    }
}