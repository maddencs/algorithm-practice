"""
Topcoder problem:

Problem Statement
A lexer (lexical analyzer) is used in compilers to break input text into pieces called tokens. In this problem you will be given a list of valid tokens. For example: 
tokens = {"ab","aba","A"} 

Given a list of valid tokens and an input string your lexer will work as follows: 
1) a) If the input doesn't begin with one of the valid tokens, remove the first character from the string. 
b) If the input does begin with a valid token, determine the longest valid token the input starts with and remove it from the string. The removed portion is considered CONSUMED. 
2) Repeat 1 until there are no characters left in the input. 

The lexer is CASE-SENSITIVE so a token must exactly match the beginning of the string. 

Given a list of valid tokens and an input string your method will return a list containing the CONSUMED valid tokens in the order they were CONSUMED. For example: 
tokens = {"ab","aba","A"} 
input = "ababbbaAab" 

"ab" and "aba" are found at the beginning of the input but "aba" is longest so it is consumed. Now: 
consumed = {"aba"} 
input = "bbbaAab" 

There are no tokens that start with 'b' so the lexer will remove the first 3 characters from the string. 
consumed = {"aba"} 
input = "aAab" 

The 'a' doesn't match the token "A" due to CASE-SENSITIVITY. The lexer removes the 'a' from the beginning of the string.
consumed = {"aba"}
input = "Aab"

The lexer consumes the "A" token.
consumed = {"aba","A"}
input = "ab"

Finally the lexer consumes the "ab" token and completes the process.
consumed = {"aba","A","ab"}
input = ""
The returned list is {"aba","A","ab"}.

Create a class Lexer that contains the method tokenize, which takes a tokens, and a input, and returns a in the form specified above.
Definition
Class: Lexer
Method: tokenize
Parameters: tuple (string), string
Returns: tuple (string)
Method signature: def tokenize(self, tokens, input):
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- tokens will contain between 0 and 50 elements inclusive
- Each element of tokens will have length between 1 and 50 inclusive
- Each element of tokens will only consist of letters (A-Z,a-z)
- input will have length between 0 and 50 inclusive
- input will only consist of letters (A-Z,a-z)
Examples
0)
{"ab","aba","A"}
"ababbbaAab"
Returns: { "aba", "A", "ab" }
Same as above
1)
{"a","a","aa","aaa","aaaa","aaaaa","aa"}
"aaaaaaaaaaaaaaaaaaaaaaaaa"
Returns: { "aaaaa", "aaaaa", "aaaaa", "aaaaa", "aaaaa" }
Make sure to use the longest valid starting token
2)
{"wow","wo","w"}
"awofwwofowwowowowwwooo"
Returns: { "wo", "w", "wo", "w", "wow", "wow", "w", "wo" }
3)
{"int","double","long","char","boolean","byte","float"}
"intlongdoublecharintintboolean"
Returns: { "int", "long", "double", "char", "int", "int", "boolean" }
4)
{}
"Great"
Returns: { }
No valid tokens, so nothing is CONSUMED
5)
{"AbCd","dEfG","GhIj"}
"abCdEfGhIjAbCdEfGhIj"
Returns: { "dEfG", "AbCd", "GhIj" }
Remember CASE-SENSITIVITY
"""

class Lexer(object):
    def tokenize(self, tokens, input):
        tokens.sort(key=len, reverse=True)
        def helper(input, consumed):
            if len(input) == 0:
                return consumed 
            for token in tokens:
                if input[:len(token)] == token:
                    consumed.append(token)
                    return helper(input[len(token):], consumed)
            return helper(input[1:], consumed)
        return helper(input, list())

