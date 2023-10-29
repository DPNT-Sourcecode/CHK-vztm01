package befaster.solutions.HLO;

public class HelloSolution {
    public String hello(String friendName) {
        if(friendName.equals("John"))
            return "Hello," + friendName + "!";
        return "Hello, World!";
    }
}
