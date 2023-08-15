package community.review

import cats.data.State

type Identity = Long
type IdentityGenerator = State[IdentityIncrementor, Identity]

final case class IdentityIncrementor(value: Identity):
  def next: IdentityIncrementor = IdentityIncrementor(value + 1)

def nextIdentity: IdentityGenerator =
  State(s => (s.next, s.next.value))
