import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}" //4.11.0 we can add this

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chuckerDebugVer}"
    const val chuckerRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerReleaseVer}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVer}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVer}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.sdkLibVer}"

    //view model, lifecycle,
    const val lifeCycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val lifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModel}"

    //    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-common-java8:${Versions.viewModel}"
    const val lifeCycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleExtention}"

    // timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVer}"

    // stetho
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    // navigation
    const val navigationFragment = ""
    const val navigationUi = ""

    // datastore
    const val preferenceDataStore =
        "androidx.datastore:datastore-preferences:${Versions.prefProtoDataStoreVer}"
    const val protoDataStore = "androidx.datastore:datastore-core:${Versions.prefProtoDataStoreVer}"

    // picasso
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVer}"

    // lottie
    const val lottieAnimation = "com.airbnb.android:lottie:${Versions.lottieVer}"

    //permission
    const val dexterPermission = "com.karumi:dexter:${Versions.dexterPersionsVer}"

    // ui
    const val swipeToReferesh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeToRefereshVer}"
    const val ripple = "com.balysv:material-ripple:${Versions.rippleVer}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimerVer}"
    const val sdpi = "com.intuit.sdp:sdp-android:${Versions.sdpiVer}"
    //

    // gif image load
    const val gifDrawable = "pl.droidsonroids.gif:android-gif-drawable:${Versions.gifDrawableVer}"

    // country code picker
    const val countryCodePicker =
        "com.github.joielechong:countrycodepicker:${Versions.countryCodePickerVer}"

    // show password edittext
    const val showPasswordEditText =
        "com.github.scottyab:showhidepasswordedittext:${Versions.countryCodePickerVer}"

    // spin kit
    const val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinKitVer}"

    //alerter
    const val alerter = "com.github.tapadoo:alerter:${Versions.alerterVer}"

    //phone lib
    const val phoneLib = "io.michaelrocks:libphonenumber-android:${Versions.phoneLibVer}"

    //toasty
    const val toasty = "com.github.GrenderG:Toasty:${Versions.toastVer}"

    // SumSub core
    const val sumSub = "com.sumsub.sns:idensic-mobile-sdk:${Versions.sumSubCoreVer}"

    //Biometric login
    const val biometricLogin = "com.mikhaellopez:biometric:${Versions.biometricLoginVer}"

    // glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVer}"
    const val bumpTechGlideKapt =
        "com.github.bumptech.glide:compiler:${Versions.bumpTechGlideKaptVer}"

    // glide to vector
    const val glideToVector =
        "com.github.2coffees1team:GlideToVectorYou:${Versions.glideToVectorVer}"

    //    image picker
    const val imagePicker = "com.github.dhaval2404:imagepicker:${Versions.imagePickerVer}"
    const val ylantasUCroper = "com.github.yalantis:ucrop:${Versions.ylantasUCropVer}"

    // material
    const val materil = "com.google.android.material:material:${Versions.googleMaterVer}"

    //qr code scanner lib replaced
    const val qrCodeScanner = "com.github.yuriy-budiyev:code-scanner:${Versions.codeScannerVer}"
    const val kenglxn = "com.github.kenglxn.qrgen:android:${Versions.kenglxnVer}"

    //charts
    const val mpaChart = "com.github.PhilJay:MPAndroidChart:${Versions.mpaChartVer}"
    const val eazGraph = "com.github.blackfizz:eazegraph:${Versions.eazGraphVer}"
    const val nineOldAndroid = "com.nineoldandroids:library:${Versions.nineOldAndroidVer}"

    //view pager indicator
    const val dotsIndicator = "com.tbuonomo:dotsindicator:${Versions.dotsIndicator}"

    // flex box
    const val flexBox = "com.google.android.flexbox:flexbox:${Versions.flexBoxVer}"
    const val carouselLayout = "com.mig35:carousellayoutmanager:${Versions.carouselLaoutManagerVer}"

    // firebase fire store
    const val firebaseFireStore = "com.google.firebase:firebase-firestore:${Versions.firebaseFireStoreVer}"
    const val firebaseFireStoreKtx = "com.google.firebase:firebase-firestore-ktx:${Versions.firebaseFireStoreKtxVer}"

    //rotbeer to detect rooted device
    const val rootBeer = "com.scottyab:rootbeer-lib:${Versions.rootBeerVer}"

    // zero branch swipe layout
    const val zeroBracnhSwipeLayout = "com.github.zerobranch:SwipeLayout:${Versions.zeroBracnhSwipeLayoutVer}"



}

fun DependencyHandler.room(){
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    debugImplementation(Dependencies.chuckerDebug)
    releaseImplementation(Dependencies.chuckerRelease)

}

fun DependencyHandler.hilt(){
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.merchantSide(){
    implementation(project(":merchantside"))

}
fun DependencyHandler.userSide(){
    implementation(project(":userside"))

}
fun DependencyHandler.common(){
    implementation(project(":common"))
}

//coroutines
fun DependencyHandler.coroutines() {
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.stdLib)
}

//from here
//view model, life cycle, life cycle extension
fun DependencyHandler.viewModelLiveDataAndLifeCycle() {
    implementation(Dependencies.lifeCycleViewModel)
    implementation(Dependencies.lifeCycleLiveData)
    implementation(Dependencies.lifeCycleExtension)
}

// timber
fun DependencyHandler.timber() {
    implementation(Dependencies.timber)
}

// stetho
fun DependencyHandler.stetho() {
    implementation(Dependencies.stetho)
}

// navigation
fun DependencyHandler.navigationArchitecture() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
}

//data store
fun DependencyHandler.datastorePrefProto() {
    implementation(Dependencies.preferenceDataStore)
    implementation(Dependencies.protoDataStore)
}

// picasso
fun DependencyHandler.picasso() {
    implementation(Dependencies.picasso)
}

// lottie
fun DependencyHandler.lottie() {
    implementation(Dependencies.lottieAnimation)
}

// dexter permission
fun DependencyHandler.dexterPermission() {
    implementation(Dependencies.dexterPermission)
}

// ui
fun DependencyHandler.ui() {
    implementation(Dependencies.swipeToReferesh)
    implementation(Dependencies.ripple)
    implementation(Dependencies.shimmer)
    implementation(Dependencies.sdpi)
}

//gif image load
fun DependencyHandler.gifDrawable() {
    implementation(Dependencies.gifDrawable)
}

//country code picker
fun DependencyHandler.countryCodePicker() {
    implementation(Dependencies.countryCodePicker)
}

//show password edit text
fun DependencyHandler.showPasswordEditText() {
    implementation(Dependencies.showPasswordEditText)
}

//spin kit
fun DependencyHandler.spinKit() {
    implementation(Dependencies.spinKit)
}

//alerter
fun DependencyHandler.alerter() {
    implementation(Dependencies.alerter)
}

// phone lib
fun DependencyHandler.phoneLib() {
    implementation(Dependencies.phoneLib)
}

// toasty
fun DependencyHandler.toasty() {
    implementation(Dependencies.toasty)
}

// sumSub
fun DependencyHandler.sumSum() {
    implementation(Dependencies.sumSub)
}

// biometric login
fun DependencyHandler.biometricLogin() {
    implementation(Dependencies.biometricLogin)
}

// glide
fun DependencyHandler.glide() {
    implementation(Dependencies.glide)
    kapt(Dependencies.bumpTechGlideKapt)
}

// glide to vector
fun DependencyHandler.glideToVector() {
    implementation(Dependencies.glideToVector)
}

// image picker
fun DependencyHandler.imagePicker() {
    implementation(Dependencies.imagePicker)
    implementation(Dependencies.ylantasUCroper)
}

// google material
fun DependencyHandler.googleMaterial() {
    implementation(Dependencies.materil)
}

// qr code scanner
fun DependencyHandler.qrCodeScanner() {
    implementation(Dependencies.qrCodeScanner)
    implementation(Dependencies.kenglxn)
}


// charts
fun DependencyHandler.charts() {
    implementation(Dependencies.mpaChart)
    implementation(Dependencies.eazGraph)
    implementation(Dependencies.nineOldAndroid)
}

// dots indicator
fun DependencyHandler.dotsIndicator() {
    implementation(Dependencies.dotsIndicator)
}

// flexbox layout
fun DependencyHandler.flexBoxLayout() {
    implementation(Dependencies.flexBox)
    implementation(Dependencies.carouselLayout)
}


// fire store
fun DependencyHandler.fireStore() {
    implementation(Dependencies.firebaseFireStore)
    implementation(Dependencies.firebaseFireStoreKtx)
}

// swipe layout
fun DependencyHandler.swipeLayout() {
    implementation(Dependencies.zeroBracnhSwipeLayout)
}

// root beer
fun DependencyHandler.rootBeer() {
    implementation(Dependencies.rootBeer)
}







