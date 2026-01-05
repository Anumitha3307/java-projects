package week9;

import java.util.*;

public class UniqueVisitorsTracker {
    public static void main(String[] args) {
       
        Set<String> uniqueVisitors = new LinkedHashSet<>();

        String[] visitors = {
            "192.168.1.1", "192.168.1.2", "192.168.1.3",
            "192.168.1.2", "192.168.1.4", "192.168.1.1"
        };

        for (String ip : visitors) {
            uniqueVisitors.add(ip);
        }

        System.out.println("Unique visitors in order of arrival:");
        for (String ip : uniqueVisitors) {
            System.out.println(ip);
        }
    }
}
