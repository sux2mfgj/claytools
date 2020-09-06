package dev.sux2mfgj.claytools.network;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.container.ClayWorkbenchContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SamplePacket {

    public int value;
    
    public SamplePacket(final int value)
    {
        this.value = value;
    }

    public static void encode(SamplePacket packet, PacketBuffer packetBuffer) {
        packetBuffer.writeInt(packet.value);
    }

    public static SamplePacket decode(PacketBuffer packetBuffer) {
        return new SamplePacket(packetBuffer.readInt());
    }
    public static void handle(SamplePacket packet, Supplier<NetworkEvent.Context> context) {
        ClayTools.LOGGER.info("SamplePacket::handle" + Integer.toString(packet.value));
        context.get().enqueueWork(() -> {
            ServerPlayNetHandler netHandler =  (ServerPlayNetHandler)context.get().getNetworkManager().getNetHandler();
            ClayWorkbenchContainer c = (ClayWorkbenchContainer)netHandler.player.openContainer;
            c.onPressServer();
        });
        context.get().setPacketHandled(true);
    }
}
