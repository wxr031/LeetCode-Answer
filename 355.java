class Twitter {
	private static class Tweet implements Comparable<Tweet> {
		int userId, tweetId, timestamp;
		Tweet(int tweetId, int timestamp) {
			this.tweetId = tweetId;
			this.timestamp = timestamp;
		}
		public int compareTo(Tweet tweet) {
			return this.timestamp < tweet.timestamp ? 1 : -1;
		}
	}

	Map<Integer,Set<Integer>> adj;
	Map<Integer,List<Tweet>> post;
	int timestamp;

	/** Initialize your data structure here. */
	public Twitter() {
		adj = new HashMap<>();
		post = new HashMap<>();
		timestamp = 0;
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		post.putIfAbsent(userId, new LinkedList<>());
		post.get(userId).add(new Tweet(tweetId, timestamp++));
		adj.putIfAbsent(userId, new HashSet<Integer>());
		adj.get(userId).add(userId);
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		PriorityQueue<Tweet> pq = new PriorityQueue<>();
		if(adj.containsKey(userId)) {
			for(int follower : adj.get(userId)) {
				if(post.containsKey(follower)) {
					pq.addAll(post.get(follower));
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		int size = Math.min(10, pq.size());
		for(int i = 0; i < size; i++) {
			result.add(pq.poll().tweetId);
		}
		return result;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		adj.putIfAbsent(followerId, new HashSet<Integer>());
		adj.get(followerId).add(followeeId);
		adj.get(followerId).add(followerId);
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if(!adj.containsKey(followerId) || !adj.get(followerId).contains(followeeId) || followerId == followeeId)
			return;
		adj.get(followerId).remove(followeeId);
		if(adj.get(followerId).size() == 0)
			adj.remove(followerId);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
