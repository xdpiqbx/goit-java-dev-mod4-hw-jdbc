/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.xdpiqbx;

import com.xdpiqbx.db.DataModels.LongestProject;
import com.xdpiqbx.db.DataModels.MaxProjectCountClient;
import com.xdpiqbx.db.DataModels.MaxSalaryWorker;
import com.xdpiqbx.db.Database;
import com.xdpiqbx.db.services.DatabaseQueryService;

import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().maxProjectCountClient();
//        for (MaxProjectCountClient el: maxProjectCountClients) {
//            System.out.println(el);
//        }

//        List<LongestProject> longestProjects = new DatabaseQueryService().longestProject();
//        for (LongestProject el: longestProjects) {
//            System.out.println(el);
//        }

        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().maxSalaryWorker();
        for (MaxSalaryWorker el: maxSalaryWorkers) {
            System.out.println(el);
        }
    }
}
