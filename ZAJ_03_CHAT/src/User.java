public class User {
    long id;
    String name;
    long createdAt;
    int numberOfSentMessages;

    public User(String name)
    {
        this.name = name;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSentMessages(int numberOfSentMessages) {
        this.numberOfSentMessages = numberOfSentMessages;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSentMessages() {
        return numberOfSentMessages;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }
}
