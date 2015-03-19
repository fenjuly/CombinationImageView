##CombinationImageView

---

This's just a simple component that hold more than one image into a view.You are probably familiar with WeChat, yeah! just like the avatar of wechat group.

 There is no limit how many images you can add in the view, but the maxium number can be shown is nine. 
 
 
###ScreenShot

![screenshot](http://i.imgur.com/EFkbKMW.jpg)

###Usage

* **XML**
 
  There are four images you can assign in xml.
  
```xml
<com.fenjuly.combinationimageview.CombinationImageView
        android:layout_marginTop="8dp"
        android:layout_gravity="center_horizontal"
        android:background="#CCCCCC"
        android:layout_width="50dp"
        android:layout_height="50dp"
        custom:first_image_src="@drawable/example1"
        custom:second_image_src="@drawable/example2"
        custom:third_image_src="@drawable/example3"
        custom:fourth_image_src="@drawable/example4"
        />
```

* **Add View in Code**

In this lib, there are three methods provided for you.
 
 * ```public void addImageView(String path)```
 * ```public void addImageView(int resId)```
 * ```public void addImageView(Bitmap bitmap)```
 
you can use these method like this:
  
	 number5 = (CombinationImageView) findViewById(R.id.number5);
	 number5.addImageView(R.drawable.example5);  
	 
* **Delete View in Code**
  
Also provide servial methods.

* ```public int getNumbersOfView()``` 
* ```public void removeView(int position)```
* ```public void removeAllView()```


###Other
All right `unreserved`!

It's my pleasure anybody use this lib.


