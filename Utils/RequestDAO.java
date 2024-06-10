/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.Request;
import Model.RequestType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.StatusType;
import java.io.IOException;

/**
 *
 * @author Asus
 */
public class RequestDAO {
    private static String pathStr = "E:\\LoginForm\\LoginForm\\Data\\";
    public static void saveRequestListAsChar(Map<String, List<Request>> listRequest) throws FileNotFoundException {
        String fileName_Char = "Request Data List.txt";
        File fileChar = new File(pathStr + "//" + fileName_Char);
        PrintWriter pw = null;
        pw = new PrintWriter(fileChar);
        for (Map.Entry<String, List<Request>> entry : listRequest.entrySet()) {
            String userID = entry.getKey();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            pw.println(userID);
            List<Request> userRequest = entry.getValue();
            for (Request requestForm : userRequest) {
                LocalDate start = requestForm.getDateFrom();
                LocalDate end = requestForm.getDateTo();
                pw.println(start + "*" + end + "*" + requestForm.getRequest() + "*"
                        + requestForm.getReason() + "*" + requestForm.getStatus());

            }
            pw.println("$");
            pw.flush();
        }

    }

    public static Map<String, List<Request>> readRequestListAsChar() {
        Map<String, List<Request>> requestMap = new HashMap<>();
        String fileName_Char = "Request Data List.txt";
        File fileChar = new File(pathStr + "\\" + fileName_Char);

        try ( BufferedReader br = new BufferedReader(new FileReader(fileChar))) {
            String line;
            String currentUser = null;
            List<Request> currentRequestList = new ArrayList<>();
           
            while ((line = br.readLine()) != null) {
                if (!line.equals("$")) {
                    if (currentUser == null) {
                        currentUser = line;
                    } else {
                        String[] requestInfo = line.split("\\*");
                        if (requestInfo.length == 5) {
                            try {
                                LocalDate startDate = LocalDate.parse(requestInfo[0], DateTimeFormatter.ISO_LOCAL_DATE);
                                LocalDate endDate = LocalDate.parse(requestInfo[1], DateTimeFormatter.ISO_LOCAL_DATE);
                                Request request = new Request(startDate, endDate, RequestType.valueOf(requestInfo[2]), requestInfo[3]);
                                request.setStatus(StatusType.valueOf(requestInfo[4]));
                                currentRequestList.add(request);
                            } catch (DateTimeParseException e) {

                            }
                        } else {
                            System.out.println("Skipping line with invalid format: " + line);
                        }
                    }
                } else {
                    requestMap.put(currentUser, currentRequestList);
                    currentUser = null;
                    currentRequestList = new ArrayList<>();
                }
            }

            // Handle the last user's request list
            if (currentUser != null) {
                requestMap.put(currentUser, currentRequestList);
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + fileName_Char);
            ex.printStackTrace();
        }

        return requestMap;
    }
}
