package com.codetest.anagram.game.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;

import com.codetest.anagram.game.WordDictionary;

@Named
public class WordDictionaryImpl implements WordDictionary {

    Vector<String> v = new Vector<String>();
    ArrayList<String> list = new ArrayList<String>();
    LinkedList<String> linkedList = new LinkedList<String>();
    HashMap<String, String> map = new HashMap<String, String>();
    ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
    TreeSet<String> ts = new TreeSet<>();
    Set<String> set = new HashSet<>();
    /**
     * 
     */
    public WordDictionaryImpl() {
        try {
            URL url = new URL("http://www.plumbeegames.com/codetest/wordlist.txt");
            URLConnection dc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(dc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                v.add(inputLine);
                linkedList.add(inputLine);
                list.add(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean contains(String word) {
        return v.contains(word);
    }

    @Override
    public int size() {
        return v.size();
    }
}
