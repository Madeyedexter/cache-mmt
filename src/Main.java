import cache.Cache;
import cache.Policy;
import cache.exception.PolicyNotSupportedException;
import cache.impl.CacheFactory;
import cache.impl.RoundRobinCache;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CacheFactory<String, String> factory = new CacheFactory<>();
         try {
             Cache<String> cache = factory.GetCache(Policy.ROUND_ROBIN);

             cache.Put("hello", "world");

             System.out.println(cache.Get("hello"));
             System.out.println(cache.Get("hello1"));

        } catch (PolicyNotSupportedException p) {
             System.out.println(p.getMessage());
         }
    }
}