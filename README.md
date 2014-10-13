TaggerString
============

TaggerString is very light library which allows to build dynamic string resource in much more readable way.


I guess that every Android developer has seen or added similar piece of code in *string.xml* file:

`<string name="user_description_string">I am %s and I am %d years old</string>`


Some probably discovered that above code is a little bit not readable and extended such declarations to something like this:
`<string name="user_description_string">I am $1%s and I am $2%d years old</string>`

And in source code:
`String userDesc = String.format(resources.getString(R.string.user_description_string), "John Kowalski", 27);`


So far so good but maybe this could be a little bit more readable ? Yes, it can be (at least in my opinion) - **TaggerString**.

Above example will look like :

```
  TaggerString taggerString = TaggerString.from(getString(R.string.user_description_string));
  taggerString.with("user_name", "John Kowalski");
  taggerString.with("user_age", 27);

  tvExampleOne.setText(taggerString.format());
```

If you want to use **bold** (TaggerStyleType.BOLD), *italic* (TaggerStyleType.ITALIC) or underscore (TaggerStyleType.UNDERLINE), please go ahead:

```
TaggerString taggerString = TaggerString.from(getString(R.string.user_description_string));
taggerString.with("user_name", "John Kowalski", TaggerStyleType.BOLD);
taggerString.with("user_age", 27, TaggerStyleType.UNDERLINE);

tvExampleOne.setText(taggerString.formatCustom());
```
Please note thatin this case method *formatCustom()* returns *Spanned* object.
