package factory;

import abstracts.Command;
import abstracts.Solution;
import concretes.commands.SolutionCommand;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_26;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_27;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_88;
import concretes.solutions.recursion.Solution_8_1;
import concretes.solutions.sorting.Solution_10_0_1;
import concretes.solutions.sorting.Solution_10_0_2;
import concretes.solutions.sorting.Solution_10_0_3;
import concretes.solutions.sorting.Solution_10_0_4;
import concretes.solutions.sorting.Solution_10_0_5;

public class CommandFactory {
    public static Command getCommand(String type) {
        SolutionCommand solutionCommand = new SolutionCommand();
        Solution solution = null;
        // else if ladder for command
        if (type != null && type.equals("8.1")) {
            solution = new Solution_8_1();
        }
        
        else if (type != null && type.equals("10.0.1")) {
            solution = new Solution_10_0_1();
        }

        else if (type != null && type.equals("10.0.2")) {
            solution = new Solution_10_0_2();
        }

        else if (type != null && type.equals("10.0.3")) {
            solution = new Solution_10_0_3();
        }

        else if (type != null && type.equals("10.0.4")) {
            solution = new Solution_10_0_4();
        }

        else if (type != null && type.equals("10.0.5")) {
            solution = new Solution_10_0_5();
        }

        else if (type != null && type.equals("88")) {
            solution = new Leetcode_88();
        }

        else if (type != null && type.equals("27")) {
            solution = new Leetcode_27();
        }

        else if (type != null && type.equals("26")) {
            solution = new Leetcode_26();
        }
        
        solutionCommand.setSolution(solution);
        return solutionCommand;
    }
}
