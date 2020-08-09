# okhttputils
-dontwarn com.zhy.http.**
-keep class com.zhy.http.** { *; }

# okhttp
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okio.**
-keep class okio.** { *; }

-dontwarn org.blinkenlights.jid3.**

-keep class android.support.** { *; }

# glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# amap
-dontwarn com.amap.api.**
-keep class com.amap.api.** { *; }

# greenDAO
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
    public static java.lang.String TABLENAME;
}
-keep class **$Properties { *; }
# If you do not use SQLCipher:
-dontwarn org.greenrobot.greendao.database.**
# If you do not use Rx:
-dontwarn rx.**
# greenDAO end

# RxBus
-keep class com.hwangjr.rxbus.** { *; }
-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.hwangjr.rxbus.annotation.Subscribe public *;
    @com.hwangjr.rxbus.annotation.Produce public *;
}
# RxBus end

# NineOldAndroids
-keep class com.nineoldandroids.** { *; }
#-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile, LineNumberTable, *Annotation*, EnclosingMethod
-keep class me.wcy.music.model.** { *; }