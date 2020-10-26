data class Comment(
    val id: Int = 0,
    val postId: Long = 0,
    val from_id: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val reply_to_user: Int = 1,
    val reply_to_comment: Int = 0,

) {
    val attachments = emptyArray<Attachment>()
    val parents_stack = emptyArray<Int>()
    val thread = Thread()

    data class Thread(
        val count: Int = 0,
        val can_post: Boolean = false,
        val show_reply_button: Boolean = false,
        val group_can_post: Boolean = false
    ) {
        private var items = emptyArray<Comment>()
    }
}