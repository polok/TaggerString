/*
    Copyright 2014 Marcin Polak

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package pl.polak.taggerstring;

import android.text.Html;
import android.text.Spanned;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaggerString {

    private static final String PLACEHOLDER_BRACKET_OPEN = "\\{";
    private static final String PLACEHOLDER_BRACKET_CLOSE = "\\}";

    private final String format;
    private final Map<String, Object> tags;

    public static TaggerString from(String format) {
        return new TaggerString(format);
    }

    private TaggerString(String format) {
        this.format = format;
        this.tags = new LinkedHashMap<String, Object>();
    }

    public TaggerString with(Map<String, Object> tags) {
        for (Map.Entry<String, Object> tag : tags.entrySet()) {
            with(tag.getKey(), tag.getValue());
        }
        return this;
    }

    public TaggerString with(String key, Object value) {
        StringBuilder builder = new StringBuilder(PLACEHOLDER_BRACKET_OPEN);
        builder.append(key);
        builder.append(PLACEHOLDER_BRACKET_CLOSE);
        tags.put(builder.toString(), value);
        return this;
    }


    public TaggerString with(String key, Object value, TaggerStyleType taggerStyleType) {
        StringBuilder builder = new StringBuilder(PLACEHOLDER_BRACKET_OPEN);
        builder.append(key);
        builder.append(PLACEHOLDER_BRACKET_CLOSE);
        tags.put(builder.toString(), taggerStyleType.getTagStart() + value + taggerStyleType.getTagEnd());
        return this;
    }

    public String format() {
        String result = format;

        for (Map.Entry<String, Object> tag : tags.entrySet()) {
            result = result.replaceAll(tag.getKey(), tag.getValue().toString());
        }

        return result;
    }

    public Spanned formatCustom() {
        String result = format;

        for (Map.Entry<String, Object> tag : tags.entrySet()) {
            result = result.replaceAll(tag.getKey(), tag.getValue().toString());
        }

        return Html.fromHtml(result);
    }

}
