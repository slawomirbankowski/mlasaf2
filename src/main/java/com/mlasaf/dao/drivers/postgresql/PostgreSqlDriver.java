package com.mlasaf.dao.drivers.postgresql;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.util.HostSpec;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSqlDriver extends org.postgresql.Driver {

    public Connection connect(String url, Properties info) throws SQLException {
        return super.connect(url, info);
    }

    private static HostSpec[] hostSpecs(Properties props) {
        String[] hosts = props.getProperty("PGHOST").split(",");
        String[] ports = props.getProperty("PGPORT").split(",");
        HostSpec[] hostSpecs = new HostSpec[hosts.length];

        for(int i = 0; i < hostSpecs.length; ++i) {
            hostSpecs[i] = new HostSpec(hosts[i], Integer.parseInt(ports[i]));
        }

        return hostSpecs;
    }

    private static String user(Properties props) {
        return props.getProperty("user", "");
    }
    private static String database(Properties props) {
        return props.getProperty("PGDBNAME", "");
    }
    private static Connection makeConnection(String url, Properties props) throws SQLException {
        return new PgConnection(hostSpecs(props), user(props), database(props), props, url);
    }
}
