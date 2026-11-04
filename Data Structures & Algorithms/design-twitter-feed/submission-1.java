class Twitter {

    Map<Integer, Set<Integer>> followees = new HashMap<>();
    Map<Integer, List<int[]>> tweets = new HashMap<>();
    int time = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = tweets.computeIfAbsent(userId, k -> new ArrayList<>());
        list.add(new int[]{time++, tweetId, userId, list.size()});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followeeIds = followees.getOrDefault(userId, new HashSet<>());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        addLatest(pq, userId);
        for (int followeeId: followeeIds) {
            if (followeeId != userId) {
                addLatest(pq, followeeId);
            }
        }

        while (result.size() < 10 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int tweetId = cur[1], uid = cur[2], index = cur[3];

            result.add(tweetId);
            
            List<int[]> list = tweets.get(uid);
            if (index > 0) {
                pq.add(list.get(index-1));
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followees.get(followerId);
        if (set != null) set.remove(followeeId);
    }

    private void addLatest(PriorityQueue<int[]> pq, int uid) {
        List<int[]> tweetsId = tweets.get(uid);
        if (tweetsId != null) pq.add(tweetsId.getLast());
    }
}
