package services;

import com.mainpackage.classes.Group;
import com.mainpackage.dao.GroupDAOimpl;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class SearchService {
    public ArrayList<Group> service(String text,String type,  AtomicReference<GroupDAOimpl> groupDAO) {
        System.out.println(text+ " "+type);
        switch(type) {
            case "name":
                return groupDAO.get().searchByGroupName(text);
            default:
                return groupDAO.get().searchByStudentSurname(text);
        }
    }
}
