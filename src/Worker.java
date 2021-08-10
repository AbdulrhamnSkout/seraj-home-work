
public class Worker {
    public int time=0; // the current time for the worker 
    public int[] timeToDoJob; // the time take to  cleaning/refueling  the vehicle
    public boolean empty=true; // if the worker can receive vehicle

    public Worker(int[]timeToDoJob){
        this.timeToDoJob=timeToDoJob;
    }

    // this function calculte the time to cleaning/refueling  the vehicle
    public void doWork(Vehicle v){
        int duration=0;
        if(v.type==CarName.MotorCycle)
        {
            duration=timeToDoJob[0];
        }
        else if(v.type== CarName.Private)
        {
            duration=timeToDoJob[1];
        }
        else{
            duration=timeToDoJob[2];
        }
       
        this.time=this.time+duration;
    
    

    }

}
