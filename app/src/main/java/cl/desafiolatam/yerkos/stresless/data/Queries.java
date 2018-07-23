package cl.desafiolatam.yerkos.stresless.data;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.yerkos.stresless.models.Pending;
import cl.desafiolatam.yerkos.stresless.models.Wine;

public class Queries {

    public List<Pending> pendings(){

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");

        if(pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }


        return pendings;
    }

    public List<Wine> wines(){

        List<Wine> wines = new ArrayList<>();
        List<Wine> wineList = Wine.listAll(Wine.class);

        if(wineList != null && wineList.size() > 0){
            wines.addAll(wineList);
        }

        return wines;
    }

}
