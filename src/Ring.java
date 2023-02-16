public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }
    boolean isCheckWeight(){
        return ((f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight ));
    }
    public void run(){
        if(isCheckWeight()) {
            whoFirst();
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("========== YENİ ROUND ==========");
                f2.health = f1.hit(f2);
                if (isWin()) {
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()) {
                    break;
                }
                printScore();
            }
        }
    }
    public void whoFirst(){
        if(f1.dodge()){
            System.out.println("İlk dövüşcü : " + f1.name);
            System.out.println("========== ROUND ==========");
            f2.health = f1.hit(f2);
        }
        else{
            System.out.println("İlk dövüşcü : " + f2.name);
            System.out.println("========== ROUND ==========");
            f1.health = f2.hit(f1);

        }
    }
    boolean isWin(){
        if(f1.health == 0){
            System.out.println("Maçı kazanan : " + f2.name);
            return true;
        }
        if(f2.health == 0){
            System.out.println("Maçı kazanan : " + f1.name);
            return true;
        }
        return false;
    }
    public void printScore(){
        System.out.println("-------------------");
        System.out.println(f1.name + " Kalan Can\t: " + f1.health );
        System.out.println(f2.name + " Kalan Can\t: " + f2.health );
    }
}
