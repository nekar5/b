package services;

import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class DeleteGroupService {

       public void service(String name, AtomicReference<GroupDAOimpl> groupDAO){
        groupDAO.get().deleteGroup(name);
    }
}
