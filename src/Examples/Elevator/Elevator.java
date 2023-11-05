package Examples.Elevator;

import Examples.Elevator.location.Location;
import Examples.Elevator.location.LocationType;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {

    private int id;

    private int currentFloor;

    private Direction direction;

    private PriorityQueue<Request> upRequests;
    private PriorityQueue<Request> downRequests;

    public Elevator(int id, Comparator<Request> elevatorStrategy) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.upRequests = new PriorityQueue<>(elevatorStrategy);
        this.downRequests = new PriorityQueue<>(elevatorStrategy);
    }

    public int getRequestCount(){
        return this.upRequests.size() + this.downRequests.size();
    }

    public void run() {
        while (!upRequests.isEmpty() || !downRequests.isEmpty()) {
            processRequests();
        }

        System.out.println("Finished all requests.");
        this.direction = Direction.IDLE;
    }

    private void processRequests() {
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    private void processUpRequest() {
        while (!upRequests.isEmpty()) {
            Request upRequest = upRequests.poll();
            // Communicate with hardware
            this.currentFloor = upRequest.desiredFloor;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ". for elevator " + this.id);
        }
        if (!downRequests.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequest() {
        while (!downRequests.isEmpty()) {
            Request downRequest = downRequests.poll();
            // Communicate with hardware
            this.currentFloor = downRequest.desiredFloor;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ". for elevator " + this.id);
        }
        if (!upRequests.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    public void addRequest(Request request){
        // If the request is sent from out side of the elevator,
        // we need to stop at the current floor of the requester
        // to pick him up, and then go the the desired floor.
        if(request.direction == Direction.UP) {
            if (request.location.getLocationType() == LocationType.OUTSIDE_ELEVATOR) {
                // Go pick up the requester who is outside of the elevator
                upRequests.offer(new Request(request.getFromFloor(),
                        request.getFromFloor(),
                        Direction.UP,
                        request.location));

                System.out.println("Append up request going to floor " + request.getFromFloor() + ". for elevator " + this.id);
            }

            // Go to the desired floor
            upRequests.offer(request);

            System.out.println("Append up request going to floor " + request.desiredFloor + ". for elevator " + this.id);
        }else{
            if (request.location.getLocationType() == LocationType.OUTSIDE_ELEVATOR) {
                // Go pick up the requester who is outside of the elevator
                downRequests.offer(new Request(request.getFromFloor(),
                        request.getFromFloor(),
                        Direction.DOWN,
                        request.location));

                System.out.println("Append down request going to floor " + request.getFromFloor() + ". for elevator " + this.id);
            }

            // Go to the desired floor
            downRequests.offer(request);

            System.out.println("Append down request going to floor " + request.desiredFloor + ". for elevator " + this.id);
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }
}
