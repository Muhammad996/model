package com.muhammad.registration.model.dao.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;

public class DataBaseConnect {
    private LinkedBlockingQueue<ConnectionWrapper> queue = new LinkedBlockingQueue();


    public ConnectionWrapper returnCW() throws SQLException, InterruptedException {
        ConnectionWrapper cw = new ConnectionWrapper(DriverManager.getConnection("jdbc:mysql://localhost/studentdao",
                "root", "root@JEA"));

        if (queue.isEmpty()) {
            return cw;
        } else {
            ConnectionWrapper cw2 = queue.poll();
            if (cw2.isAlive()) {
                System.out.println("Alive");
                return cw2;
            } else {
                System.out.println("Not Alive");
                return returnCW();
            }
        }
    }

    public void release(ConnectionWrapper cw) throws InterruptedException {
        queue.put(cw);
    }


}
