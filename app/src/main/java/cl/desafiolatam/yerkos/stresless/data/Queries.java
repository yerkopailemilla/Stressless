package cl.desafiolatam.yerkos.stresless.data;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.yerkos.stresless.models.Pending;

public class Queries {

    public List<Pending> pendings(){

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");

        if(pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }


        return pendings;
    }

    public List<String> names(){
        List<String> names = new ArrayList<>();
        List<Pending> pendings = pendings();
        for (int i = 0; i < pendings.size(); i++) {
            names.add(pendings.get(i).getName());
        }

        return names;
    }

    public List<Pending> byName(String name){
        List<Pending> pendings = new ArrayList<>();
        String query = "done = 0 AND name LIKE '%"+name+"%'";
        List<Pending> pendingList = Pending.find(Pending.class, query);
        if (pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }

        return pendings;
    }

    public Pending byId(long id){
        Pending pending = Pending.findById(Pending.class, id);
        return pending;
    }

}
