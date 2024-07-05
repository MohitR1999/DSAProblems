package factory;

import abstracts.Command;
import abstracts.Solution;
import concretes.commands.SolutionCommand;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_26;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_27;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_88;
import concretes.solutions.leetcode.binary_tree_bfs.Leetcode_199;
import concretes.solutions.leetcode.graph_general.Leetcode_200;
import concretes.solutions.leetcode.hashmap.Leetcode_383;
import concretes.solutions.leetcode.intervals.Leetcode_228;
import concretes.solutions.leetcode.matrix.Leetcode_36;
import concretes.solutions.leetcode.sliding_window.Leetcode_209;
import concretes.solutions.leetcode.stack.Leetcode_20;
import concretes.solutions.leetcode.two_pointers.Leetcode_125;
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

        else if (type != null && type.equals("125")) {
            solution = new Leetcode_125();
        }

        else if (type != null && type.equals("209")) {
            solution = new Leetcode_209();
        }

        else if (type != null && type.equals("36")) {
            solution = new Leetcode_36();
        }

        else if (type != null && type.equals("383")) {
            solution = new Leetcode_383();
        }

        else if (type != null && type.equals("228")) {
            solution = new Leetcode_228();
        }

        else if (type != null && type.equals("20")) {
            solution = new Leetcode_20();
        }

        else if (type != null && type.equals("199")) {
            solution = new Leetcode_199();
        }

        else if (type != null && type.equals("200")) {
            solution = new Leetcode_200();
        }
        
        solutionCommand.setSolution(solution);
        return solutionCommand;
    }
}
