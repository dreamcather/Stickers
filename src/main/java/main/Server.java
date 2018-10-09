package main;
import Game.StickGame;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(final String[] args) throws IOException, AlreadyBoundException {
        BridgeClass bridge = new BridgeClass();
        Registry localReg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        StickGame stickGame = new StickGame(3);
        localReg.bind(bridge.NAME,bridge);
        System.out.println(stickGame.isClosed(4));
    }
}