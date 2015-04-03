TaggerString
============

TaggerString is very light library which allows to build dynamic string resource in much more readable way.

[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TaggerString-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1048)

I guess that every Android developer has seen or added similar piece of code in *string.xml* file:

```xml
<string name="user_description_string">I am %s and I am %d years old</string>`
```

Some probably discovered that above code is a little bit not readable and extended such declarations to something like this:
```xml
<string name="user_description_string">I am $1%s and I am $2%d years old</string>
```

And in source code:
```java
String userDesc = String.format(resources.getString(R.string.user_description_string), "John Kowalski", 27);
```

So far so good but maybe this could be a little bit more readable ? Yes, it can be (at least in my opinion) - **TaggerString**.

In source code above example will look like :

```java
  TaggerString taggerString = TaggerString.from(getString(R.string.user_description_string));
  taggerString.with("user_name", "John Kowalski");
  taggerString.with("user_age", 27);
  tvExampleOne.setText(taggerString.format());
```

And our string resource looks

```xml
<string name="example_one">My name is {user_name} and I am a {developer_role}</string>
```

If you want to use **bold** (TaggerStyleType.BOLD), *italic* (TaggerStyleType.ITALIC) or underscore (TaggerStyleType.UNDERLINE), please go ahead:

```java
TaggerString taggerString = TaggerString.from(getString(R.string.user_description_string));
taggerString.with("user_name", "John Kowalski", TaggerStyleType.BOLD);
taggerString.with("user_age", 27, TaggerStyleType.UNDERLINE);
tvExampleOne.setText(taggerString.formatCustom());
```
Please note that in this case method *formatCustom()* returns *Spanned* object.

##### Multiple formatting (since version 1.1.0)
If you want to apply few tags for one string go ahead and do it:

```java
taggerString.with("developer_role", "Android Software Developer", TaggerStyleType.UNDERLINE, TaggerStyleType.BOLD, TaggerStyleType.ITALIC);
```

Usage
----------

If you are using gradle please add below:

```xml
dependencies {
    compile 'com.github.polok.taggerstring:library:1.0.0'
}
```

####
Since version 1.1.0 the artefactId was changed from library to taggerstring:

```xml
dependencies {
    compile 'com.github.polok.taggerstring:taggerstring:1.1.0'
}
```

Developed By
------------
Marcin Polak - mpolak87(at).gmail.com

License
----------

```
Copyright 2015 Marcin Polak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

