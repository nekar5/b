package services;

import com.mainpackage.classes.Group;
import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class AddGroupService {
        public void service(Group group, AtomicReference<GroupDAOimpl> groupDAO){
        groupDAO.get().addGroup(group);
    }
}
