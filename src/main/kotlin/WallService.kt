class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment): Boolean {
        // существует ли в массиве posts пост с id равным тому, что в комментарии в свойстве postId
        var postFound = false;
        for (p in posts) {
            if (p.id == comment.postId) {
                comments += comment
                postFound = true
                break
            }
        }
        if (!postFound)
            throw PostNotFoundException("not post with id ${comment.postId}")
        return true
    }

    fun add(post: Post): Post {
        post.id = posts.size.toLong() + 1
        posts += post
        return post
    }

    fun update(post: Post): Boolean {
        val i = post.id.toInt() - 1
        if (i < 0 || i >= posts.size)
            return false
        val arrayPost: Post = posts[i]

        posts[i] = post.copy(id = i.toLong() + 1, date = arrayPost.date, ownerId = arrayPost.ownerId)

        return true
    }
}