package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import logic.compute.ProcessUnit;

public class CalculationTask extends Task implements Computable, Modifiable {


    public CalculationTask(String name, double workload) {
        super(name, workload);
    }

    @Override
    public double compute(ProcessUnit processUnit) {
        return processUnit.compute(this);
    }

    @Override
    public void modify(int modifyValue) {
        changeWorkload(modifyValue);
    }

    @Override
    public String fullTaskName() {
        return "Calculation Task";
    }

    public void changeWorkload(int workload) {
        this.setWorkload(getWorkload() + workload);
    }
}
