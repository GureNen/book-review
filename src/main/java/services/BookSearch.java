package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookSearch  {

    // converting the json String to a java object
    public static Map<String, Object> toJavaObject (String jsonResponse) {

    }

    // getting the json response as a String
    private static String getJsonResponse(String bookTitle) throws IOException {
        // building the url
        String stringURL = urlBuilder(bookTitle);
        if (stringURL.equals("")) {
            return "No Result Found";
        }
        URL url = new URL(stringURL);
        // establishing the connection with the url and connection properties
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        // getting the response from the request
        int status = con.getResponseCode();
        Reader streamReader = null;
        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }
        BufferedReader in = new BufferedReader(streamReader);
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

    // URL builder method
    private static String urlBuilder(String bookTitle) {
        // splitting title with space characters
        bookTitle = bookTitle.trim();
        String[] titleParts = bookTitle.split(" {1,}", 0);
        String url = "http://openlibrary.org/search.json?title=";
        int length = titleParts.length;
        // if title isn't valid valid
        if (length == 1 && titleParts[0].equals("")) {
            return "";
        }
        for (int i = 0; i < length - 1; i++) {
            url += titleParts[i]  + "+";
        }
        url += titleParts[length-1] + "&fields=cover_i,edition_count,title,author_name,first_publish_year&sort=editions";
        return url;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getJsonResponse("candide"));
    }
}
