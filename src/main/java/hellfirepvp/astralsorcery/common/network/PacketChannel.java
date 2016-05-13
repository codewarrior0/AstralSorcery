package hellfirepvp.astralsorcery.common.network;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.common.network.packet.client.PktDiscoverConstellation;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncConfig;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncData;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncKnowledge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: PacketChannel
 * Created by HellFirePvP
 * Date: 07.05.2016 / 01:11
 */
public class PacketChannel {

    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(AstralSorcery.NAME);

    public static void init() {
        int id = 0;

        //Synchronizing data (server -> client)
        CHANNEL.registerMessage(PktSyncConfig.class, PktSyncConfig.class, id++, Side.CLIENT); //General config sync
        CHANNEL.registerMessage(PktSyncKnowledge.class, PktSyncKnowledge.class, id++, Side.CLIENT); //Knowledge data sync
        CHANNEL.registerMessage(PktSyncData.class, PktSyncData.class, id++, Side.CLIENT); //General dataholder sync

        //Constellation discovery (client -> server)
        CHANNEL.registerMessage(PktDiscoverConstellation.class, PktDiscoverConstellation.class, id++, Side.SERVER); //discover a constellation in gui and inform server.
    }

}