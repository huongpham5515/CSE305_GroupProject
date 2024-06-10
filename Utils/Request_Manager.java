/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.Request;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class Request_Manager {
    private static Map<String, List<Request>> listRequest = RequestDAO.readRequestListAsChar();

    public static Map<String, List<Request>> getListRequest() {
        return listRequest;
    }

    public static void setListRequest(Map<String, List<Request>> listRequest) {
        Request_Manager.listRequest = listRequest;
    }
}
