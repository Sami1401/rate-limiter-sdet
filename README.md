# rate-limiter-sdet
SDET 3 Test

# Rate Limiter (Per User)

Object oriented implementation of API Gateway Rate Limiter.

## Features

- Per user rate limiting
- Rolling time window
- Handles out-of-order timestamps
- Efficient memory usage

## Tech

Java
JUnit
Maven

## Example

limit = 3
window = 10

(A,1) -> true
(A,2) -> true
(A,3) -> true
(A,9) -> false
(A,12) -> true
