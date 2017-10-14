package com.example.org.gvrfapplication;

import android.os.Bundle;

import org.gearvrf.GVRActivity;
import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRMesh;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;

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
            quad.getTransform().setPosition(0, 0, -20);

            //Add rectangle to the scene
            gvrContext.getMainScene().addSceneObject(quad);

            GVRMesh dinoMesh = gvrContext.getAssetLoader().loadMesh(new GVRAndroidResource(gvrContext, "trex_mesh.fbx"));
            //GVRTexture dinoTexture = gvrContext.getAssetLoader().loadTexture(new GVRAndroidResource(gvrContext, "trex_tex_diffuse.png"));
            GVRTexture dinoTexture = gvrContext.getAssetLoader().loadTexture(new GVRAndroidResource(gvrContext, "trex_tex_diffuse.pkm"));

            GVRSceneObject dinoObj = new GVRSceneObject(gvrContext, dinoMesh, dinoTexture);
            dinoObj.getTransform().setPosition(0,0,-10);
            dinoObj.getTransform().rotateByAxis(-90, 1f, 0f, 0f);
            gvrContext.getMainScene().addSceneObject(dinoObj);
        }

        @Override
        public void onStep() {
            //Add update logic here
        }
    }
}
