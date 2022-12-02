package com.xdpiqbx.db.services;

import com.xdpiqbx.common.Helper;
import com.xdpiqbx.db.DataModels.MaxProjectCountClient;
import com.xdpiqbx.db.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final Database db = Database.getInstance();
    private static final String path = Helper.env("SQL_FILES_PATH");
    private String sqlQueryFromFile(String fileName){
        try {
            return String.join("\n", Files.readAllLines(Paths.get(path+fileName+".sql")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<MaxProjectCountClient> longestProject(){
        try {
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlQueryFromFile("find_max_projects_client"));
            List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
            while(rs.next()){
                maxProjectCountClients.add(
                    new MaxProjectCountClient(
                            rs.getString("name"),
                            rs.getInt("project_count")
                    ));
            }
            rs.close();
            st.close();
            return maxProjectCountClients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public static void maxProjectCountClient(){}
//    public static void maxSalaryWorker(){}
//    public static void youngestAndEldestWorkers(){}
//    public static void projectPrices(){}
}