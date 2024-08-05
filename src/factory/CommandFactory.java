package factory;

import abstracts.Command;
import abstracts.Solution;
import concretes.commands.SolutionCommand;
import concretes.leetcode.backtracking.Leetcode_17;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_26;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_27;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_80;
import concretes.solutions.leetcode.arrays_and_strings.Leetcode_88;
import concretes.solutions.leetcode.binary_search.Leetcode_35;
import concretes.solutions.leetcode.binary_tree_bfs.Leetcode_199;
import concretes.solutions.leetcode.binary_tree_bfs.Leetcode_637;
import concretes.solutions.leetcode.bit_manipulation.Leetcode_67;
import concretes.solutions.leetcode.graph_bfs.Leetcode_909;
import concretes.solutions.leetcode.graph_general.Leetcode_130;
import concretes.solutions.leetcode.graph_general.Leetcode_200;
import concretes.solutions.leetcode.hashmap.Leetcode_205;
import concretes.solutions.leetcode.hashmap.Leetcode_383;
import concretes.solutions.leetcode.heap.Leetcode_215;
import concretes.solutions.leetcode.intervals.Leetcode_228;
import concretes.solutions.leetcode.intervals.Leetcode_56;
import concretes.solutions.leetcode.kadane.Leetcode_53;
import concretes.solutions.leetcode.linked_list.Leetcode_2;
import concretes.solutions.leetcode.math.Leetcode_9;
import concretes.solutions.leetcode.matrix.Leetcode_36;
import concretes.solutions.leetcode.multi_dimensional_dp.Leetcode_120;
import concretes.solutions.leetcode.multi_dimensional_dp.Leetcode_64;
import concretes.solutions.leetcode.one_dimensional_dp.Leetcode_70;
import concretes.solutions.leetcode.sliding_window.Leetcode_209;
import concretes.solutions.leetcode.sliding_window.Leetcode_3;
import concretes.solutions.leetcode.stack.Leetcode_20;
import concretes.solutions.leetcode.stack.Leetcode_71;
import concretes.solutions.leetcode.trie.Leetcode_208;
import concretes.solutions.leetcode.two_pointers.Leetcode_125;
import concretes.solutions.leetcode.two_pointers.Leetcode_392;
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

        else if (type != null && type.equals("909")) {
            solution = new Leetcode_909();
        }

        else if (type != null && type.equals("208")) {
            solution = new Leetcode_208();
        }

        else if (type != null && type.equals("17")) {
            solution = new Leetcode_17();
        }

        else if (type != null && type.equals("53")) {
            solution = new Leetcode_53();
        }

        else if (type != null && type.equals("35")) {
            solution = new Leetcode_35();
        }

        else if (type != null && type.equals("215")) {
            solution = new Leetcode_215();
        }

        else if (type != null && type.equals("67")) {
            solution = new Leetcode_67();
        }

        else if (type != null && type.equals("9")) {
            solution = new Leetcode_9();
        }

        else if (type != null && type.equals("70")) {
            solution = new Leetcode_70();
        }

        else if (type != null && type.equals("120")) {
            solution = new Leetcode_120();
        }

        else if (type != null && type.equals("80")) {
            solution = new Leetcode_80();
        }

        else if (type != null && type.equals("392")) {
            solution = new Leetcode_392();
        }

        else if (type != null && type.equals("3")) {
            solution = new Leetcode_3();
        }

        else if (type != null && type.equals("205")) {
            solution = new Leetcode_205();
        }

        else if (type != null && type.equals("56")) {
            solution = new Leetcode_56();
        }

        else if (type != null && type.equals("71")) {
            solution = new Leetcode_71();
        }

        else if (type != null && type.equals("2")) {
            solution = new Leetcode_2();
        }

        else if (type != null && type.equals("64")) {
            solution = new Leetcode_64();
        }

        else if (type != null && type.equals("637")) {
            solution = new Leetcode_637();
        }

        else if (type != null && type.equals("130")) {
            solution = new Leetcode_130();
        }
        
        solutionCommand.setSolution(solution);
        return solutionCommand;
    }
}
