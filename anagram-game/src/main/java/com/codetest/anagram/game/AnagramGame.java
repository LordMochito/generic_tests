package com.codetest.anagram.game;


public interface AnagramGame {

    /**
     * Submit a word on behalf of a user. A word is accepted if its letters are contained in the original string
     * submitted in the constructor, and if it is in the WordDictionary. If the word is accepted and its score is high
     * enough, the user's submission should be added to the top-ten leaderboard. If there are multiple submissions with
     * the same score, all are accepted, but the first submission with that score should rank higher. If there are
     * multiple submissions with the same username, each should be treated as a separate entry and recorded independently.
     * <p/>
     * NOTE: This method must be threadsafe; multiple users may be submitting at the same time.
     *
     * @param username Name to record the submission under
     * @param word     User's submission. All submissions may be assumed to be lowercase and containing no whitespace
     *                 or special characters.
     * @return the user's score, 0 if the word is not accepted
     */
    public int submitWord(String username, String word);

    /**
     * Return username at given position in the leaderboard, 0 being the highest (best score) and 9 the lowest.
     * You may assume that this method will never be called with position > 9.
     *
     * @param position Index on leaderboard
     * @return username at given position in the leaderboard, or null if there is no entry at that position
     */
    String getUserNameAtPosition(int position);

    /**
     * Return word entry at given position in the leaderboard, 0 being the highest (best score) and 9 the lowest.
     * You may assume that this method will never be called with position > 9.
     *
     * @param position Index on leaderboard
     * @return word entry at given position in the leaderboard, or null if there is no entry at that position
     */
    String getWordEntryAtPosition(int position);

    /**
     * Return score at given position in the leaderboard, 0 being the highest (best score) and 9 the lowest.
     * You may assume that this method will never be called with position > 9.
     *
     * @param position Index on leaderboard
     * @return score at given position in the leaderboard, or null if there is no entry at that position
     */
    Integer getScoreAtPosition(int position);
    
    void setBaseSetOfLetters(String baseSetOfLetters);
}