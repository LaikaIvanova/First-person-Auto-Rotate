package com.laikaivanova;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BetterBodyAngleClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && client.getCameraEntity() != null) {
				float cameraYaw = client.getCameraEntity().getYaw();
				client.player.setYaw(cameraYaw);
				client.player.bodyYaw = cameraYaw;
				client.player.headYaw = cameraYaw;
			}
		});
	}
}