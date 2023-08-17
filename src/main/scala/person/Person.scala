package community.review
package person

import cats.data.State
import community.review.domain.{DomainEvent, Transaction}
import community.review.{IdentityIncrementor, nextIdentity}

case class Person(
                 id: Long,
                 firstName: String,
                 lastName: String,
                 email: String
                 )

object Person:

  def apply(
              firstName: String,
              lastName: String,
              email: String
            ): State[IdentityIncrementor, Transaction] =
    for (
      id                        <- nextIdentity;
      person                    = Person(id, firstName, lastName, email);
      evt                       = PersonCreatedEvent(person);
      transaction: Transaction  = Transaction(evt)
    ) yield transaction
