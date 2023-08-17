package community.review
package person

import domain.DomainEvent


case class PersonCreatedEvent(person: Person) extends DomainEvent