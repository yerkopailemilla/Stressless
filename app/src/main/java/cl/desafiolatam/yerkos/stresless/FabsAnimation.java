package cl.desafiolatam.yerkos.stresless;

import android.view.View;

public class FabsAnimation {

    private FabsCallback fabsCallback;

    public FabsAnimation(FabsCallback fabsCallback) {
        this.fabsCallback = fabsCallback;
    }

    public View fabAnimation(View view){
         if (view.getRotation() != 0){
             fabsCallback.hideFabs();
             return view;
         } else {
             fabsCallback.showFabs();
             return view;
         }
    }
}
