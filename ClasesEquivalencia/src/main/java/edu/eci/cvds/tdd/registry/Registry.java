package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {

    private ArrayList<Integer> ids = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {
        if (p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }
        else if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        else if(p.getAge() > 100){
            return RegisterResult.INVALID_AGE;
        }
        else if(ids.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }
        else{
            ids.add(p.getId());
            return RegisterResult.VALID;
        }
    }
}