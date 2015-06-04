package com.chat.dao.db;

import org.h2.tools.Server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.sql.*;

/**
 * Created by vlad
 * Date: 04.06.15_13:54
 */
public class H2Memory implements ServletContextListener {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "chat";
    private static final String DB_PASSWORD = "1234";

    private Server server;

    private void setUpDatabase() {
        try {
            //tcp://localhost:9092
            server = Server.createTcpServer().start();
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
            Statement stmt = conn.createStatement();
            stmt.execute(getSql());
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getSql() {
        StringBuilder sql = new StringBuilder("");
        try {
            InputStream is = getClass().getResourceAsStream("/setupDatabase.sql");
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buff = new byte[1024];
            while (bis.read(buff) != -1) {
                sql.append(new String(buff));
            }
            bis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sql.toString());
        return sql.toString();
    }

    private void shutdownDatabase() {
        server.stop();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        setUpDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        shutdownDatabase();
    }
}
