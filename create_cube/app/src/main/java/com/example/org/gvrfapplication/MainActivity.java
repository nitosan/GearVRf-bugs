package com.example.org.gvrfapplication;

import android.os.Bundle;

import org.gearvrf.GVRActivity;
import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;
import org.gearvrf.scene_objects.GVRCubeSceneObject;

public class MainActivity extends GVRActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Set Main Scene
         * It will be displayed when app starts
         */
        setMain(new Main());
    }

    private final class Main extends GVRMain {

        @Override
        public void onInit(GVRContext gvrContext) throws Throwable {

            GVRCubeSceneObject cube_obj = new GVRCubeSceneObject(gvrContext);
            cube_obj.getRenderData().getMaterial().setColor(1, 0, 0);
            gvrContext.getMainScene().addSceneObject(cube_obj);

        }

    }
}
