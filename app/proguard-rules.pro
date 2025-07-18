# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep semua data class, entity, use case, repository, dan ViewModel
-keep class com.dennyoctavian.core.domain.** { *; }
-keep class com.dennyoctavian.core.data.** { *; }
-keep class com.dennyoctavian.core.presentation.** { *; }

# Keep ViewModel Hilt injection
-keep class * extends androidx.lifecycle.ViewModel
-keep @dagger.hilt.EntryPoint class *
-keepclassmembers class * {
    @dagger.hilt.android.lifecycle.HiltViewModel <init>(...);
}

# Keep Hilt generated classes
-keep class dagger.hilt.internal.** { *; }
-keep class * extends dagger.hilt.android.internal.lifecycle.HiltViewModelFactory$ViewModelFactoryCreator

# Optional: Keep Room DAO
-keep class androidx.room.RoomDatabase
-keep class * extends androidx.room.RoomDatabase
-keep interface * implements androidx.room.Dao

-keep class net.sqlcipher.** { *; }
-dontwarn net.sqlcipher.**
-keep class androidx.sqlite.db.SupportSQLiteDatabase { *; }
