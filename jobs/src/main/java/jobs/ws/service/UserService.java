package jobs.ws.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jobs.ws.model.User;

public class UserService {
      private static Map<Integer, User> USER_DATA = new ConcurrentHashMap<Integer, User>();

      private int getNewId() {
            int newId = 0;
            for (int id : USER_DATA.keySet()) {
                  if (newId < id)
                        newId = id;
            }
            return ++newId;
      }

      public User addUser(User u) {
            int id = getNewId();
            if (USER_DATA.get(u.getId()) != null) {
                  return null;
            }
            u.setId(id);
            USER_DATA.put(id, u);
            return u;
      }

      public boolean deleteUser(int id) {
            if (USER_DATA.get(id) == null) {
                  return false;
            }
            USER_DATA.remove(id);
            return true;
      }

      public User getUser(int id) {
            return USER_DATA.get(id);
      }

      public User updateUser(int id, User u) {
            if (USER_DATA.get(id) == null) {
                  return null;
            }

            USER_DATA.put(id, u);
            return u;
      }

      public ArrayList<User> getAllUsers() {
            return new ArrayList<User>(USER_DATA.values());
      }

}
