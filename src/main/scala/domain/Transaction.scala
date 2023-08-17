package community.review
package domain

import person.PersonCreatedEvent

type Transaction = List[PersonCreatedEvent]

object Transaction:

  def apply(events: PersonCreatedEvent*): Transaction = events.toList
