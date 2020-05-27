package cep.domain.actuators;

public class BuildingAlarm {

    private String room;
    private String message;

    public BuildingAlarm(String room, String message) {
        this.room = room;
        this.message = message;
    }


    public void execute() {
        System.out.println("BuildingAlarm[room = " + room + ", msg = " + message + "]");
    }
}
