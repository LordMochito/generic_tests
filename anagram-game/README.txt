Service to provide an anagram game, similar to the TV show Countdown.

The game is constructed with a base set of letters, e.g. the string "areallylongword",
which may be assumed to be all in lowercase, and with no whitespace or special characters. Users then attempt to create
words out of the letters, and score one point for each letter used. The submissions must be "real words": use
the WordDictionary to check each submission.

For example (see the test skeleton):
"no" is an acceptable submission, with score 2
"grow" is an acceptable submission, with score 4
"bold" is not an acceptable submission
"glly" is not an acceptable submission
"woolly" is an acceptable submission with score 6
"adder" is not an acceptable submission

The service maintains a list of the top ten highest-scoring submissions (including username, word, and score).
Submissions are not summed: if a user enters multiple submissions, these should each be added to the high-score
list (if applicable) independently.

Throughout this test, you need not worry about whitespace, special characters, or uppercase. You may assume
that both the original string of letters and all submissions contain none of these.
