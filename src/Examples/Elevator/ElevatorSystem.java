package Examples.Elevator;

import Examples.Elevator.exceptions.ElevatorNotAvailableNowException;
import Examples.Elevator.location.InsideLocation;
import Examples.Elevator.location.LocationType;

import java.util.*;

public class ElevatorSystem {

    private List<Elevator> elevators;
    private List<Request> requests;


    private Comparator<Request> elevatorStrategy;

    public ElevatorSystem(int elevators, Comparator<Request> elevatorStrategy) {
        this.elevators = new ArrayList<>();
        this.elevatorStrategy = elevatorStrategy;
        for(int i = 0; i < elevators; i++){
            this.elevators.add(new Elevator(i, this.elevatorStrategy));
        }

        requests = new ArrayList<>();
    }

    public void addRequest(Request request){
        requests.add(request);
    }

    public void run(){
        Set<Elevator> allElevators = new HashSet<>();

        for(Request request : requests){
            if(!request.isScheduled && request.location.getLocationType() == LocationType.INSIDE_ELEVATOR){
                InsideLocation insideLocation = (InsideLocation) request.location;
                elevators.get(insideLocation.getElevator()).addRequest(request);
                allElevators.add(elevators.get(insideLocation.getElevator()));
                request.schedule(elevators.get(insideLocation.getElevator()));
            }
        }

        for(Request request : requests){
            if(!request.isScheduled && request.location.getLocationType() == LocationType.OUTSIDE_ELEVATOR){
                try {
                    Elevator elevator = assignRequestToCorrectElevator(request);
                    elevator.addRequest(request);
                    allElevators.add(elevator);
                    request.schedule(elevator);
                }catch (ElevatorNotAvailableNowException ex){
                    System.out.println("all elevators occupied. Trying in some time...");
                }
            }
        }

        for(Elevator elevator : allElevators){
            if(elevator != null) elevator.run();
        }

        long count = requests.stream().filter(request -> !request.isScheduled).count();
        if(count > 0) run();
    }

    private Elevator assignRequestToCorrectElevator(Request request) throws ElevatorNotAvailableNowException{
        for(Elevator elevator : this.elevators){
            if(elevator.getDirection() == request.direction) return elevator;
        }

        for(Elevator elevator : this.elevators){
            if(elevator.getDirection() == Direction.IDLE && elevator.getRequestCount() == 0)
                return elevator;
        }

        throw new ElevatorNotAvailableNowException();
    }
}
