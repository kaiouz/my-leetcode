package p1410;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String entityParser(String text) {
        Map<String, String> cache = new HashMap<>();
        cache.put("&quot;", "\"");
        cache.put("&apos;", "'");
        cache.put("&amp;", "&");
        cache.put("&gt;", ">");
        cache.put("&lt;", "<");
        cache.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();

        int start = 0;
        int i = 0;
        for (i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '&') {
                sb.append(text, start, i);
                start = i;
            } else if (c == ';') {
                String html = text.substring(start, i + 1);
                String cc = cache.getOrDefault(html, html);
                sb.append(cc);
                start = i + 1;
            }
        }

        if (start < text.length()) {
            sb.append(text.substring(start));
        }

        return sb.toString();
    }

}
