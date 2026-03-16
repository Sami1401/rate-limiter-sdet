package ratelimiter;

public class Driver {

    public static void main(String[] args) {

        RateLimiter limiter = new RateLimiter(3, 10);

        System.out.println(limiter.allowRequest("A",1));
        System.out.println(limiter.allowRequest("A",2));
        System.out.println(limiter.allowRequest("A",3));
        System.out.println(limiter.allowRequest("A",9));
        System.out.println(limiter.allowRequest("A",12));
    }
}
