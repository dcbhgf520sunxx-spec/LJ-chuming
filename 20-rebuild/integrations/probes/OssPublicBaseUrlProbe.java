import com.hzchum.scim.plan.core.api.util.OssUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** Prepared only, not executed. Uses reserved .invalid hosts and calls no OSS SDK method. */
public class OssPublicBaseUrlProbe {
   private static final Method BUILD;
   static {
      try {
         BUILD = OssUtils.class.getDeclaredMethod("remoteObjectUrl", String.class);
         BUILD.setAccessible(true);
      } catch (ReflectiveOperationException e) {
         throw new ExceptionInInitializerError(e);
      }
   }

   public static void main(String[] args) throws Exception {
      OssUtils subject = new OssUtils();
      set(subject, "BUCKET_NAME", "example-bucket");
      set(subject, "END_POINT", "https://oss-region.example.invalid");
      set(subject, "publicBaseUrl", "");
      equal("https://example-bucket.oss-region.example.invalid/drawings/part.dxf", build(subject));
      set(subject, "END_POINT", "oss-another-region.example.invalid");
      equal("https://example-bucket.oss-another-region.example.invalid/drawings/part.dxf", build(subject));
      set(subject, "END_POINT", "http://oss.example.invalid:9000/");
      equal("http://example-bucket.oss.example.invalid:9000/drawings/part.dxf", build(subject));
      set(subject, "publicBaseUrl", "https://downloads.example.invalid/objects/");
      equal("https://downloads.example.invalid/objects/drawings/part.dxf", build(subject));
      for (String invalid : new String[] {
         "https://user:password@example.invalid", "https://example.invalid?signature=example",
         "https://example.invalid/#fragment", "file:///tmp/objects", "downloads.example.invalid"
      }) {
         set(subject, "publicBaseUrl", invalid);
         invalid(subject);
      }
      set(subject, "publicBaseUrl", "");
      set(subject, "END_POINT", "https://oss.example.invalid/unsupported-path");
      invalid(subject);
      System.out.println("OSS URL construction assertions passed; no cloud or local storage operation executed.");
   }

   private static String build(OssUtils subject) throws Exception {
      return (String) BUILD.invoke(subject, "drawings/part.dxf");
   }

   private static void set(OssUtils subject, String name, String value) throws Exception {
      Field field = OssUtils.class.getDeclaredField(name);
      field.setAccessible(true);
      field.set(subject, value);
   }

   private static void equal(String expected, String actual) {
      if (!expected.equals(actual)) throw new AssertionError("Unexpected object URL: " + actual);
   }

   private static void invalid(OssUtils subject) throws Exception {
      try {
         build(subject);
      } catch (InvocationTargetException e) {
         if (e.getCause() instanceof IllegalArgumentException) return;
         throw e;
      }
      throw new AssertionError("Invalid base URL was accepted");
   }
}
