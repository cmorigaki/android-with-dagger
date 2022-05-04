# Android with dagger
This repository shows how to use Dagger in an Android project. There are several packages representing incremental steps on how to (and not to) integrate Dagger.

## _1_without_dagger
Initial code without Dagger

## _2_wrong_dagger
Naive Dagger usage. The application crashes with configuration changes and app reinstantiation

## _3_member_injection
Simple and older solution using member injection

## _4_dagger_android
Usage of dagger-android lib to help with member injection on android components

## _5_dagger_android_lifecycle
Usage of dagger-android and improving the code with lifecycle components listening

## _6_fragment_factory_simple
Constructor injection and simple solution with Fragment Factory (and without dagger-android)

## _7_fragment_factory_map
Single Fragment Factory for every fragment but poor key

## _8_fragment_factory_fragmentkey
Single Fragment Factory for every fragment with @FragmentKey

## _9_provide_context
Providing context using @Component.Factory

## _10_viewmodel_factory
Providing ViewModel using ViewModelProvider.Factory

## _11_activity_injection
Activity member injection

## _12_activity_injection_new
Activity constructor injection (api 28+)