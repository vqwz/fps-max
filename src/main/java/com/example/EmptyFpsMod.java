package com.example.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class EmptyFpsMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null || client.options == null) return;

            int fps = MinecraftClient.getCurrentFps();
            String fpsText = "FPS: " + fps;

            drawContext.drawTextWithShadow(
                client.textRenderer, 
                fpsText, 
                10, 
                10, 
                0xFFFF00
            );
        });
    }
}
