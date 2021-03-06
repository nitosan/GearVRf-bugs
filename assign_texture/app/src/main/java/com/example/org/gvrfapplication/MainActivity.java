package com.example.org.gvrfapplication;

import android.os.Bundle;

import org.gearvrf.GVRActivity;
import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;
import org.gearvrf.scene_objects.GVRModelSceneObject;

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

            //Load texture
            GVRTexture texture = gvrContext.getAssetLoader().loadTexture(new GVRAndroidResource(gvrContext, R.drawable.__default_splash_screen__));

            //Create a rectangle with the texture we just loaded
            GVRSceneObject quad = new GVRSceneObject(gvrContext, 4, 2, texture);
            quad.getTransform().setPosition(0, 0, -3);

            //Add rectangle to the scene
            gvrContext.getMainScene().addSceneObject(quad);

            GVRModelSceneObject dinoObj = gvrContext.getAssetLoader().loadModel("trex_mesh.fbx");
            dinoObj.getTransform().setPosition(0,0,-10);
            gvrContext.getMainScene().addSceneObject(dinoObj);

            GVRTexture dinoTexture = gvrContext.getAssetLoader().loadTexture(new GVRAndroidResource(gvrContext, "trex_tex_diffuse.pkm"));
            dinoObj.getRenderData().getMaterial().setMainTexture(dinoTexture);
        }

        @Override
        public void onStep() {
            //Add update logic here
        }
    }
}
