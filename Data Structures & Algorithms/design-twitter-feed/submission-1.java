class Tweet {    
    int id;
    int time;
    public Tweet(int id, int time) {
        this.id = id;
        this.time = time;
    }
} 

class Twitter {

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> posts;
    private int time;

    public Twitter() {
        following = new HashMap<>();
        posts = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId, value -> new ArrayList<>()).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> recent = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));

        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (posts.containsKey(followeeId)) {
                    for (Tweet twit : posts.get(followeeId)) {
                        recent.offer(twit);
                        if (recent.size() > 10) {
                            recent.poll();
                        }
                    }
                }
            }
        }

        if (posts.containsKey(userId)) {
            for (Tweet twit : posts.get(userId)) {
                recent.offer(twit);
                if (recent.size() > 10) {
                    recent.poll();
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!recent.isEmpty()) {
            res.add(0, recent.poll().id);
        } 
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        following.computeIfAbsent(followerId, value -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId) && following.get(followerId).contains(followeeId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
