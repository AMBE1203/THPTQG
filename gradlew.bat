apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.ambe.imageresize"
        minSdkVersion 21
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        debug {
            debuggable true
        }
        release {
            debuggable false
            zipAlignEnabled true
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

repositories {
    google()
    jcenter()
//    maven { url  "https://dl.bintray.com/cats-oss/maven" }
}

dependencies {
    implementation project(':library')

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:support-v4:28.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation 'android.arch.navigation:navigation-fragment-ktx:1.0.0'
    implementation 'android.arch.navigation:navigation-ui-ktx:1.0.0'

    //live data
    implementation 'android.arch.lifecycle:livedata:1.1.1'
    annotationProcessor "android.arch.lifecycle:compiler:1.1.1"
    implementation 'android.arch.lifecycle:extensions:1.1.1'
    implementation 'android.arch.lifecycle:viewmodel:1.1.1'

    implementation 'com.intuit.sdp:sdp-android:1.0.6'
    // Glide
    implementation 'com.github.bumptech.glide:glide:4.9.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
    implementation 'com.google.code.gson:gson:2.8.5'

    implementation 'com.android.support:cardview-v7:28.0.0'
    implementation 'com.github.chrisbanes:Photo