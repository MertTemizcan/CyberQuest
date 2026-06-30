public class Character {

    private String name;
    private int health;
    private double cyberMoney;
    private String[] inventory;
    private int attackPower;
    private boolean isWeaponEquipped;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.cyberMoney = 50.0;
        this.inventory = new String[]{"Empty", "Empty", "Empty"};
        this.attackPower = 15;
        this.isWeaponEquipped = false;
    }

    public void displayStatus() {
        System.out.println("\n====================================");
        System.out.println(" 👤 PLAYER STATUS OVERVIEW ");
        System.out.println("====================================");
        System.out.println(" • Name         : " + this.name);
        System.out.println(" • Health       : " + this.health);
        System.out.println(" • Attack Power : " + this.attackPower);
        System.out.println(" • Cyber Money  : " + this.cyberMoney + " $");
        System.out.print(" • Inventory    : [ ");
        for (String item : inventory) {
            System.out.print(item + " ");
        }
        System.out.println("]");
        System.out.println("====================================\n");
    }

    public void addItem(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equals("Empty")) {
                inventory[i] = item;
                System.out.println(item + "has been added to your inventory");
                return;
            }
        }
        System.out.println("Your inventory is full");
    }


    public boolean isWeaponEquipped() {
        return this.isWeaponEquipped;
    }

    public void setWeaponEquipped(boolean weaponEquipped) {
        this.isWeaponEquipped = weaponEquipped;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
        } else {
            this.health = 0;
        }
    }

    public double getCyberMoney() {
        return this.cyberMoney;
    }

    public void setCyberMoney(double cyberMoney) {
        if (cyberMoney >= 0) {
            this.cyberMoney = cyberMoney;
        }
    }

    public String[] getInventory() {
        return this.inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }
}