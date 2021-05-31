package services;

import com.mainpackage.classes.Group;
import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class GroupService {
        public Group service(String name,AtomicReference<GroupDAOimpl> groupDAO) {
        return groupDAO.get().getGroup(name);
    }
}
