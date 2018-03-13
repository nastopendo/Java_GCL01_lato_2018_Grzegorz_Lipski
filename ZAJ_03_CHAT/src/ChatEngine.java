import java.util.*;

public class ChatEngine {
    Scanner in = new Scanner(System.in);
    private Map<String, User> users;
    private Map<Long, User> usersID;
    private Set<String> banned;
    long IDcount;

    public ChatEngine() {
        users = new HashMap<>();
        usersID = new HashMap<>();
        banned = new TreeSet<>();
        IDcount = 0;
    }

    Queue<String> queue = new ArrayDeque<String>();

    public void addUser(User user) throws UserAddException {
        if (!users.containsKey(user.name)) {
            user.setId(IDcount++);
            user.setCreatedAt(System.currentTimeMillis());
            users.put(user.getName(), user);
            usersID.put(user.getId(), user);
        } else throw new UserAddException();
    }

    public void removeUser(long userId) throws UserRemoveException {
        if (usersID.containsKey(userId)) {
            users.remove(usersID.remove(usersID).getName());
        } else throw new UserRemoveException();
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public void createBan(String userName) {
        if (users.containsKey(userName))
            usersID.remove(users.remove(usersID).getId());
        else banned.add(userName);
    }

    public void removeBan(String userName)
    {
        if(banned.contains(userName)) banned.remove(userName);
    }

    public boolean hasUser(long userId)
    {
        return usersID.containsKey(userId);
    }

    public boolean hasUser(String userName)
    {
        return users.containsKey(userName);
    }

    public boolean broadcastMessage(long userId, String message)
    {
        if(users.containsKey(userId))
        {
            System.out.println("Wiadomosc: " + message + " wyslano do:");
            for (int i=0; i<users.size(), i++) {
            System.out.println();
            }

            return true;
        } else return false;
    }
}














//    private Map<String,FulfillmentCenter> magazines;
//
//    public FulfillmentCenterContainer() {
//
//        magazines = new HashMap<>();
//    }
//
//    public void addCenter(String name, double maxCapacity){
//        magazines.put(name, new FulfillmentCenter(name, maxCapacity));
//    }
//
//    public void addCenter(FulfillmentCenter fC){
//
//        magazines.put(fC.getName(), fC);
//    }
//
//    public void removeCenter(String name) {
//
//        magazines.remove(name);
//    }
//
//    public List<String> findEmpty() {
//        List<String> result = new ArrayList<>();
//
//        for(Map.Entry<String,FulfillmentCenter> keyValuePair : magazines.entrySet()){
//            if(keyValuePair.getValue().isEmpty()) {
//                result.add(keyValuePair.getKey());
//            }
//        }
//        return result;
//    }
//
//    public void summary() {
//        FulfillmentCenter tmp = null;
//
//        for(Map.Entry<String,FulfillmentCenter> keyValuePair : magazines.entrySet()){
//            tmp = keyValuePair.getValue();
//            System.out.println("Magazine \"" + tmp.getName() + "\" filled in " + tmp.percentageFill() + "%.");
//        }
//    }
//}