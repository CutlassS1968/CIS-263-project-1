# CIS 263 Project 1
Given a dictionary, find the largest set of anagram words
(Words that use the same set of letters)
Suggestion:
Use a map with the following structure
* Key: A string
* Value: A set (LinkedList, ArrayList, TreeSet) of words
###Pseudo-code
```Read all the words in the dictionary
For each word in the dictionary
   Calculate the key
   Check if the key is already present in the map
   If it is not present in the map
       Instantiate a new set, add this word to the set
       Add this key and this new set to the map
   else
       Retrieve the set associated with this key
       Add this word to that set
   end-if
end-for
Visit all the entries in the map and find the largest set
Print the largest set
```

The dictionary used for this project was downloaded from:
https://github.com/dwyl/english-words
There are roughly 480,000 words in the dictionary