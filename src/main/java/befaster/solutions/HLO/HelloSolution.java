package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        if(friendName.equals("John"))
            return "Hello," + friendName + "!";
        return "Hello, World!";
    }
}




