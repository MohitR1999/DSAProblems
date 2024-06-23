package concretes.commands;

import abstracts.Command;
import abstracts.Solution;

public class SolutionCommand implements Command {

    private Solution solution;
    
    public SolutionCommand(Solution solution) {
        this.solution = solution;
    }

    public SolutionCommand() {
        this.solution = null;
    }

    @Override
    public void execute() {
        if (this.solution != null) {
            this.solution.solve();        
        } else {
            System.out.println("Solution not implemented!!!");
        }
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
    
}
