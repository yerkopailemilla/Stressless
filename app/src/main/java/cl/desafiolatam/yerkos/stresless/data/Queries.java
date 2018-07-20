package cl.desafiolatam.yerkos.stresless.data;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.yerkos.stresless.models.Pending;

public class Queries {

    public List<Pending> pendings(){

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.listAll(Pending.class);

        if(pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }

        return pendings;
    }

}
