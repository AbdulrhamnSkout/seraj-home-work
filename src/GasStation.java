import java.util.ArrayList;

public class GasStation {
    public Worker refuelWorker; 
    public Worker cleaningWorkers;
    public ArrayList<String> logs = new ArrayList<>(); // in this array we store all the logs
    public ArrayList<Vehicle> vehicles;
    

    public GasStation(Worker refuelWorker, Worker cleanigWorker, ArrayList<Vehicle> vehicles) {
        this.refuelWorker = refuelWorker;
        this.cleaningWorkers = cleanigWorker;
        this.vehicles = vehicles;
    }

    //this function mange the worker 
    public void scheduling() {
        Vehicle v1 = null;
        Vehicle v2 = null;
        while (true) {

            // in this if we check if both worker can  clean and refuel the car's
            if (this.refuelWorker.empty && this.cleaningWorkers.empty) {
                v1 = findVehicle("R");
                v2 = findVehicle("C");
                if (v1 == null && v2 == null)
                    break;

                if (v1 == null)
                    oneCar(v2, this.cleaningWorkers, this.refuelWorker);

                if (v2 == null)
                    oneCar(v1, this.refuelWorker, this.cleaningWorkers);

                else {
                    DoWorkSingle(this.refuelWorker, v1);
                    DoWorkSingle(this.cleaningWorkers, v2);
                    emptyoRNot(v1, v2);
                }

            }
            // for refuel only
            else if (this.refuelWorker.empty && !this.cleaningWorkers.empty) {
                v1 = findVehicle("R");
                if (v1 == null) {
                    this.cleaningWorkers.empty = true;
                    v2.entered = false;
                    this.refuelWorker.time = this.cleaningWorkers.time;
                } else {
                    DoWorkSingle(this.refuelWorker, v1);
                    emptyoRNot(v1, v2);

                }
            }
            // for clean only
            else if (this.cleaningWorkers.empty && !this.refuelWorker.empty) {
                v2 = findVehicle("C");
                if (v2 == null) {
                    this.refuelWorker.empty = true;
                    v1.entered = false;
                    this.cleaningWorkers.time = this.refuelWorker.time;
                } else {
                    DoWorkSingle(this.cleaningWorkers, v2);
                    emptyoRNot(v1, v2);

                }

            }

        }
    }
    // find the vehicle based on  priority and arrangement of arrive 
    private Vehicle findVehicle(String servic) {

        Vehicle v = null;

        for (Vehicle vehicle : vehicles) {

            if (servic.equals("R")) {

                if (vehicle.wantToRefuel && vehicle.entered == false && vehicle.priority == 1) {
                    v = vehicle;
                    v.wantToRefuel = false;
                    v.entered = true;
                    break;
                } else if (vehicle.wantToRefuel && vehicle.entered == false && v == null) {
                    v = vehicle;
                    v.wantToRefuel = false;
                    v.entered = true;
                }
            }

            if (servic.equals("C")) {
                if (vehicle.wantToClean && vehicle.entered == false && vehicle.priority == 1) {
                    v = vehicle;
                    v.wantToClean = false;
                    v.entered = true;
                    break;
                } else if (vehicle.wantToClean && vehicle.entered == false && v == null) {
                    v = vehicle;
                    v.wantToClean = false;
                    v.entered = true;
                }
            }

        }

        return v;

    }

    private void oneCar(Vehicle v, Worker w1, Worker w2) {
        v.priority = 1;
        logs.add("Vehicle " + v.number + " with type " + v.type + " start cleaning in time " + w1.time);
        w1.doWork(v);
        w2.time = w1.time;
        w1.empty = true;
        v.entered = false;
    }

    private void emptyoRNot(Vehicle v1, Vehicle v2) {

        int minTime = Math.min(this.refuelWorker.time, this.cleaningWorkers.time);
        if (this.refuelWorker.time == minTime) {
            v1.entered = false;
            this.refuelWorker.empty = true;
        }
        if (this.cleaningWorkers.time == minTime) {
            v2.entered = false;
            this.cleaningWorkers.empty = true;
        }
    }

    private void DoWorkSingle(Worker w, Vehicle v) {
        v.priority = 1;
        logs.add("Vehicle " + v.number + " with type " + v.type + " start cleaning in time " + w.time);
        w.empty = false;
        w.doWork(v);
    }

}
