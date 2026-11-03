class Twitter {

    Map<Integer, Set<Integer>> userToFollowees = new HashMap<>();
    Map<Integer, List<int[]>> userToTweet = new HashMap<>();
    int time = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = userToTweet.computeIfAbsent(userId, k -> new ArrayList<>());
        list.add(new int[]{time++, tweetId,  userId, list.size()});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = userToFollowees.getOrDefault(userId, new HashSet<>());

        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> candidate = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        addLatest(candidate, userId);
        for (int id: followers) {
            if (id != userId) {
                addLatest(candidate, id);
            }
        }

        while (result.size() < 10 && !candidate.isEmpty()) {
            int[] maxTime = candidate.poll();
            
            result.add(maxTime[1]);
            int uid = maxTime[2];
            int index = maxTime[3];

            if (index > 0) {
                candidate.add(userToTweet.get(uid).get(index-1));
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userToFollowees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = userToFollowees.get(followerId);
        if (set != null) set.remove(followeeId);
    }

    private void addLatest(PriorityQueue<int[]> pq, int uid) {
        List<int[]> tweets = userToTweet.get(uid);

        if (tweets == null) return;
        pq.add(tweets.getLast());
    }
}
