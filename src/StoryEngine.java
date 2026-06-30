import java.util.Scanner;

public class StoryEngine {

    private final Scanner tara = new Scanner(System.in);

    public void startCombat(Character character, Enemy enemy) {
        System.out.println("COMBAT STARTED: " + character.getName() + " VS " + enemy.getName());
        System.out.println("------------------------------------------------");

        while (character.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("IT'S YOUR TURN Choose your action:");
            System.out.println("1 -> Attack (" + character.getAttackPower() + " Damage)");
            System.out.println("2 -> Defend (Reduce incoming damage by 50%)");
            System.out.println("3 -> Check Inventory and Equip Weapons");
            System.out.print("Your action: ");

            int action = tara.nextInt();
            int currentEnemyDamage = enemy.getDamage();

            if (action == 1) {
                enemy.setHealth(enemy.getHealth() - character.getAttackPower());
                System.out.println("You strike " + enemy.getName() + " and deal " + character.getAttackPower() + " damage");

            } else if (action == 2) {
                currentEnemyDamage = enemy.getDamage() / 2;
                System.out.println("You brace yourself for impact. Incoming damage is halved");

            } else if (action == 3) {
                System.out.print("Inventory items: ");
                boolean hasWeapon = false;
                for (String item : character.getInventory()) {
                    System.out.print("[" + item + "] ");
                    if (item.contains("Pistol") || item.contains("Laser")) {
                        hasWeapon = true;
                    }
                }
                System.out.println();

                if (hasWeapon) {
                    if (!character.isWeaponEquipped()) {
                        System.out.println("You equipped your laser weapon. Damage increased by +15");
                        character.setAttackPower(character.getAttackPower() + 15);
                        character.setWeaponEquipped(true);
                    } else {
                        System.out.println("Your laser weapon is already active. Current damage is maximized.");
                    }
                } else {
                    System.out.println("No bonus weapon effects found.");
                }

                continue;

            } else {
                System.out.println("Invalid input! You lose your focus and stand still.");
            }

            if (enemy.getHealth() > 0) {
                character.setHealth(character.getHealth() - currentEnemyDamage);
                System.out.println(enemy.getName() + " attacks you for " + currentEnemyDamage + " damage");
            }

            // TUR SONU DURUM RAPORU
            System.out.println("------------------------------------------------");
            System.out.println("📊 STATUS -> Your Health: " + character.getHealth() + " | " + enemy.getName() + " Health: " + enemy.getHealth());
            System.out.println("------------------------------------------------");
        }

        if (character.getHealth() <= 0) {
            System.out.println("Critical failure. You have been terminated. GAME OVER.");
        } else if (enemy.getHealth() <= 0) {
            System.out.println("SUCCESS: " + enemy.getName() + " has been vaporized. You survived.");
        }
    }

    public void startGame(Character character) {
        System.out.println("====================================================");
        System.out.println("      WELCOME TO ISTANBUL 2081, " + character.getName().toUpperCase() + "!");
        System.out.println("====================================================");
        System.out.println("The streets are dark, filled with neon lights and acid rain.");

        character.displayStatus();

        System.out.println("Suddenly, a rogue corporate drone descends from the sky and targets you!");
        System.out.println("What is your tactical decision?");
        System.out.println("1 -> Standard Protocol: Engage the drone in combat");
        System.out.println("2 -> Tactical Retreat: Slip into the old tech shop nearby");
        System.out.print("\nEnter your choice (1 or 2): ");

        int choice = tara.nextInt();

        if (choice == 1) {
            Enemy drone = new Enemy("Rogue Tech-Drone", 60, 16);
            startCombat(character, drone);

            if (character.getHealth() > 0) {
                character.displayStatus();
            }

        } else if (choice == 2) {
            System.out.println("\nYou slide under the closing steel shutter of the old tech shop");
            System.out.println("On a workbench, an abandoned Heavy Laser Pistol catches your eye");

            character.addItem("Heavy Laser Pistol");
            character.displayStatus();

            System.out.println("The Rogue Drone tracks your signature and smashes through the window");
            System.out.println("It's time to test your new weapon");

            Enemy drone = new Enemy("Rogue Tech-Drone", 60, 16);
            startCombat(character, drone);

            if (character.getHealth() > 0) {
                character.displayStatus();
            }
        }
    }
}