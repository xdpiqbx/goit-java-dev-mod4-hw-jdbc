package com.xdpiqbx.db.Services;

import com.xdpiqbx.common.Helper;
import com.xdpiqbx.db.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        initDb(Database.getInstance());
    }
    public static void initDb(Database db){
        String initDbFilename = Helper.env("SQL_FILES_PATH") + "init_db.sql";
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(initDbFilename)));
            db.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
