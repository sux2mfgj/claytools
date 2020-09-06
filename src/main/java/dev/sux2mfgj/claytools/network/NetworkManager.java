package dev.sux2mfgj.claytools.network;

import dev.sux2mfgj.claytools.ClayTools;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.OptionalInt;

public class NetworkManager {
    
    private static NetworkManager instance;
    private static final String PROTOCOL_VERSION = "1";
    private static SimpleChannel channel;
    
    public NetworkManager()
    {
        channel = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(ClayTools.mod_id, "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );
        channel.<SamplePacket>registerMessage(0, SamplePacket.class, SamplePacket::encode,
                SamplePacket::decode, SamplePacket::handle,
                Optional.ofNullable(NetworkDirection.PLAY_TO_SERVER));
    }

    public static void init() {
        instance = new NetworkManager();
    }

    public static void pressClayWorkbenchButton()
    {
        channel.sendToServer(new SamplePacket(0));
    }
}
