# Skeleton
Because the original library was deprecated, I converted all code to Kotlin and published to jitpack.io so that I can continue using them in my existing projects.

All the credit goes to ethanhua -> https://github.com/ethanhua/Skeleton

# Feature

- Light
- Noninvasive, you don't need to make changes to existing code.
- Wide applicability，it is available for all views
- Memory optimised

# Getting started

In your build.gradle:
```
dependencies {
       implementation 'com.bhardwaj:skeleton:1.1.2'
       implementation 'io.supercharge:shimmerlayout:2.1.0'
    }
```
    
    

# Usage
  For RecyclerView:
  ```java
  skeletonScreen = Skeleton.bind(recyclerView)
                                .adapter(adapter)
                                .load(R.layout.item_skeleton_news)
                                .show();
  ``` 
       
                                
                         
  For View:
  ```java
  skeletonScreen = Skeleton.bind(rootView)
                                .load(R.layout.layout_img_skeleton)
                                .show();
  ```    
       
                                
                       
  More Config:
  ```java
  .shimmer(true)      // whether show shimmer animation.                      default is true
  .count(10)          // the recycler view item count.                        default is 10
  .color(color)       // the shimmer color.                                   default is #a2878787
  .angle(20)          // the shimmer angle.                                   default is 20;
  .duration(1000)     // the shimmer animation duration.                      default is 1000;
  .frozen(false)      // whether frozen recyclerView during skeleton showing  default is true; 
```
                            
  when data return you can call the method to hide skeleton loading view 
   ```java
  skeletonScreen.hide()
   ```
       
        
 # Thanks
 
 https://github.com/team-supercharge/ShimmerLayout
 
