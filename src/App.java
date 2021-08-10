import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
       // initializing the evniroment
        ArrayList <Vehicle> v=new ArrayList<>();
        v.add(new Vehicle(CarName.MotorCycle, 0, "RC"));
        v.add( new Vehicle(CarName.Trailer, 1, "R"));
        v.add(new Vehicle(CarName.MotorCycle, 2, "RC"));
        v.add(new Vehicle(CarName.Private, 3, "C"));
        v.add(new Vehicle(CarName.Private ,4, "C"));
        v.add(new Vehicle(CarName.Private, 5, "R"));
        v.add(new Vehicle(CarName.Private, 6, "R"));
        v.add(new Vehicle(CarName.MotorCycle, 7, "R"));
        v.add(new Vehicle(CarName.MotorCycle, 8, "R"));
        v.add(new Vehicle(CarName.Private, 9, "RC"));
        v.add( new Vehicle(CarName.Trailer, 10, "C"));
        v.add( new Vehicle(CarName.MotorCycle, 11, "R"));
        v.add(new Vehicle(CarName.Private, 12, "R"));
        v.add( new Vehicle(CarName.Trailer, 13, "RC"));
        v.add(new Vehicle(CarName.Private, 14, "R"));



        Worker refuelingWorker=new Worker(new int[]{1,3,5});
        Worker cleanWorker=new Worker(new int[]{2,4,6});
        GasStation gaz=new GasStation(refuelingWorker, cleanWorker, v);
        gaz.scheduling();
     
        // printing all the logs
        for ( String msg:gaz.logs){
            System.out.println(msg);
        }
        
        

    }
}
