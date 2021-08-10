public class Vehicle {
    public CarName type; // Vehicle type
    public int number; // Vehicle
    public int priority = 0;// 0 mean noraml and 1 mean hight
    public boolean wantToRefuel = false; // if the Vehicle want to fuel
    public boolean wantToClean = false;  // if the Vehicle want to clean
    public boolean entered=false;

    public Vehicle(CarName type, int number, String service) {
        this.type = type;
        this.number = number;
        this.setService(service);
    }

    // based on the string "service"  currcet the varible want to Refule and want to Clean
    private void setService(String service) {
        for (int i = 0; i < service.length(); i++) {
            if (service.charAt(i) == 'R') {
                this.wantToRefuel = true;
            }
            if (service.charAt(i) == 'C') {
                this.wantToClean = true;
            }

        }
    }

}
