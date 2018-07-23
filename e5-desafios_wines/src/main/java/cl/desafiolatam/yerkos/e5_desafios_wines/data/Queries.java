package cl.desafiolatam.yerkos.e5_desafios_wines.data;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.yerkos.e5_desafios_wines.models.Wine;

public class Queries {

    public List<Wine> wines(){

        List<Wine> wines = new ArrayList<>();
        List<Wine> wineList = Wine.listAll(Wine.class);

        if(wineList != null && wineList.size() > 0){
            wines.addAll(wineList);
        }

        return wines;
    }

}
