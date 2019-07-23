## Android Live Broadcasts
Live broadcast receiver library for Android

[![](https://jitpack.io/v/ibrahimsn98/android-live-broadcasts.svg)](https://jitpack.io/#ibrahimsn98/android-live-broadcasts)

## Setup
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
      implementation 'com.github.ibrahimsn98:android-live-broadcasts:1.0'
}
```

## Usage
```kotlin
LiveBroadcasts.init().subscribe(context, arrayOf(Intent.ACTION_TIME_TICK)).observe(this, Observer {
	if (it != null)
		Log.d("MainActivity", it.action)
})
```

License
--------

    MIT License

	Copyright (c) 2018 ibrahim süren

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
	© 2018 Git


> Follow me on Twitter [@ibrahimsn98](https://twitter.com/ibrahimsn98)