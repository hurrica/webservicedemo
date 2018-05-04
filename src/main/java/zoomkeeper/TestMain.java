package zoomkeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeperMain;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("server start...");
            }
        };
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.4.238:2181", 6000, watcher);
            ZooKeeperMain zooKeeperMain = new ZooKeeperMain(zooKeeper);

            System.out.println(zooKeeper.getState().isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
