package community.review


/**
 * A community of peers that review content
 */
case class PeerReviewCommunity(
                              val qualification: Qualification,
                              val peers: List[Peer]
                              )

/**
 * The specific field a community is expert in
 */
case class Field()

/**
 * The qualification of a peer review community to review content in a field
 */
case class Qualification(
                        val field: Field
                        )

/**
 * A peer participating in the review process as an author or reviewer
 */
case class Peer():
  def review(c: Content): Review = ???

/**
 * A peer that is authoring content
 */
case class Author()

/**
 * A peer that is reviewing content
 */
case class Reviewer()

/**
 * Some online content to review
 */
case class Content(
                  val authors: List[Author],
                  val field: Field
                  ):
  def requestReview(): Review = ???

/**
 * A comment made during a content review
 */
case class Comment()

/**
 * A reply to a comment made during a content review
 */
case class Reply()

/**
 * The status of a peer review
 */
enum Status:
  case Accepted
  case Rejected
  case Pending
  case Denied

case class Review(
                 val reviewer: Reviewer,
                 val content: Content,
                 val comments: List[Comment],
                  val status: Status,
                 ):
  def accept(): Review = ???
  def reject(): Review = ???
  def comment(c: Comment): Review = ???