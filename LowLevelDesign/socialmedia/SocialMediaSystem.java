package LowLevelDesign.socialmedia;

import java.util.*;

class User {
    private String userId;
    private String name;
    private String email;
    private List<User> friends;
    private List<Post> posts;

    public User() {
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}

class Friendship {
    private User user1;
    private User user2;
    private Date friendshipDate;

    public Friendship(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.friendshipDate = new Date();
    }
}

class Post {
    private String postId;
    private User author;
    private String content;
    private List<Comment> comments;
    private List<Like> likes;
    private Date timestamp;

    public Post(User author, String content) {
        this.postId = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.timestamp = new Date();
    }

    public String getPostId() {
        return postId;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void addLike(Like like) {
        likes.add(like);
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class Comment {
    private String commentId;
    private User author;
    private String content;
    private Date timestamp;

    public Comment(User author, String content) {
        this.commentId = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        this.timestamp = new Date();
    }

    public String getCommentId() {
        return commentId;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class Like {
    private String likeId;
    private User user;
    private Date timestamp;

    public Like(User user) {
        this.likeId = UUID.randomUUID().toString();
        this.user = user;
        this.timestamp = new Date();
    }

    public String getLikeId() {
        return likeId;
    }

    public User getUser() {
        return user;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class NewsFeed {
    private User user;
    private List<Post> posts;

    public NewsFeed(User user) {
        this.user = user;
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}

class Timeline {
    private User user;
    private List<Post> posts;

    public Timeline(User user) {
        this.user = user;
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}

class UserDatabase {
    private Map<String, User> users;

    public UserDatabase() {
        this.users = new HashMap<>();
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getUserId());
    }
}

class PostDatabase {
    private Map<String, Post> posts;

    public PostDatabase() {
        this.posts = new HashMap<>();
    }

    public Map<String, Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.put(post.getPostId(), post);
    }

    public void removePost(Post post) {
        posts.remove(post.getPostId());
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.values());
    }
}

class InteractionFlow {
    public void createFriendship(User user1, User user2) {
        Friendship friendship = new Friendship(user1, user2);
        user1.addFriend(user2);
        user2.addFriend(user1);
        // Save friendship details if needed
    }

    public Post createPost(User author, String content) {
        Post post = new Post(author, content);
        author.addPost(post);
        // Save post details if needed
        return post;
    }

    public void createComment(User author, Post post, String content) {
        Comment comment = new Comment(author, content);
        post.addComment(comment);
        // Save comment details if needed
    }

    public void likePost(User user, Post post) {
        Like like = new Like(user);
        post.addLike(like);
        // Save like details if needed
    }

    public void generateNewsFeed(User user, NewsFeed newsFeed) {
        // Logic to generate personalized news feed for the user
    }

    public void addToTimeline(User user, Post post, Timeline timeline) {
        timeline.addPost(post);
        // Save timeline details if needed
    }

    public boolean isCycle(User currentUser, Set<User> visited, User parent) {
        visited.add(currentUser);
        for(User friend : currentUser.getFriends()){
            if(!visited.contains(friend)){
                if (isCycle(friend, visited, currentUser)) {
                    return true;
                }
            } else {
                if(parent != friend)
                    return true;
            }
        }
        return false;
    }

    /*public boolean isCycle(User currentUser, Set<User> visited, User parent) {
        visited.add(currentUser);

        for (User friend : currentUser.getFriends()) {
            if (!visited.contains(friend)) {
                if (isCycle(friend, visited, currentUser)) {
                    return true;
                }
            } else if (friend!=(parent)) {
                return true;
            }
        }

        return false;
    }*/


    // Other interaction-related methods
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        UserDatabase userDatabase = new UserDatabase();
        PostDatabase postDatabase = new PostDatabase();
        InteractionFlow interactionFlow = new InteractionFlow();

        // Create users
        User ram = new User();
        ram.setUserId("1");
        ram.setName("Ram");
        ram.setEmail("ram@example.com");

        User laxman = new User();
        laxman.setUserId("2");
        laxman.setName("Laxman");
        laxman.setEmail("laxman@example.com");

        User sita = new User();
        sita.setUserId("3");
        sita.setName("Sita");
        sita.setEmail("sita@example.com");

        User mandavi = new User();
        mandavi.setUserId("4");
        mandavi.setName("Mandavi");
        mandavi.setEmail("mandavi@example.com");

        User sruthi = new User();
        sruthi.setUserId("5");
        sruthi.setName("Sruthi");
        sruthi.setEmail("sruthi@example.com");

        User bharath = new User();
        bharath.setUserId("6");
        bharath.setName("Bharath");
        bharath.setEmail("bharath@example.com");

        User srathugna = new User();
        srathugna.setUserId("7");
        srathugna.setName("Srathugna");
        srathugna.setEmail("srathugna@example.com");

        // Add users to the database
        userDatabase.addUser(ram);
        userDatabase.addUser(laxman);
        userDatabase.addUser(sita);
        userDatabase.addUser(mandavi);
        userDatabase.addUser(sruthi);
        userDatabase.addUser(bharath);
        userDatabase.addUser(srathugna);

        // Establish friendships
        interactionFlow.createFriendship(ram, laxman);
        interactionFlow.createFriendship(ram, sita);

        // Add two friends to Sita (Mandavi and Sruthi)
        interactionFlow.createFriendship(sita, mandavi);
        interactionFlow.createFriendship(sita, sruthi);

        // Add two friends to Laxman (Bharath and Srathugna)
        interactionFlow.createFriendship(laxman, bharath);
        interactionFlow.createFriendship(laxman, srathugna);
        //interactionFlow.createFriendship(bharath, ram);

        // Detect and print cycles in the friendship network
        Set<User> visited = new HashSet<>();
        for (User user : userDatabase.getUsers().values()) {
            if (!visited.contains(user)) {
                boolean hasCycle = interactionFlow.isCycle(user, visited, null);
                System.out.println("User: " + user.getName() + ", Has Cycle: " + hasCycle);
            }
        }
    }
}
