import java.util.Random;

public class AntFactory
{
    private Random random = new Random();
    public Ant getAnt(String antType)
    {
        if(antType == null){
            return null;
        }
        if(antType.equals("fire ant")){
            return new FireAnt(random.nextInt(600), 600, "");

        } else if(antType.equals("normal ant")) {
            return new NormalAnt(random.nextInt(600), 600, "");
        }

        return null;
    }
}
