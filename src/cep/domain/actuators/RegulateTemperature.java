package cep.domain.actuators;

public class RegulateTemperature {

    private Double ambient;
    private Double target;

    public RegulateTemperature(Double ambient, Double target) {
        this.ambient = ambient;
        this.target = target;
    }

    public void execute() {
        if (target > ambient)
            System.out.println("TemperatureRegulation decrease target = " + target + "to  ambient = " + ambient + "]");
        else if (target < ambient)
            System.out.println("TemperatureRegulation increase target = " + target + "to  ambient = " + ambient + "]");
        target = ambient;
    }
}
