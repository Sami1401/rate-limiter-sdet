# Rate Limiter Test Cases

## Functional Cases

1. Allow requests under limit
2. Block when limit reached
3. Allow again after window expiry

Example:
limit = 3
window = 10

(A,1) -> true
(A,2) -> true
(A,3) -> true
(A,9) -> false
(A,12) -> true

## Edge Cases

1. Multiple users
2. Same timestamp requests
3. Out-of-order timestamps
4. Window boundary conditions

## Failure Modes

- Large number of users
- High frequency requests
- Timestamp collisions
