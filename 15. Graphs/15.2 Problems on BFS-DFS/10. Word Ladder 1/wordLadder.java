//que link.
//https://leetcode.com/problems/word-ladder/submissions/1110657207/

class Solution {

    //created pair class that store the 'String' and 'Level'
    class Pair
    {
        String str;
        int level;
        Pair(String str, int level)
        {
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //created Queeu
        Queue<Pair> queue = new ArrayDeque<>();

        //creating hashset that store the STring
        HashSet<String> hset = new HashSet<>();

        //run a loop and add string in the hashset.
        for(String str: wordList)
        {
            hset.add(str);
        }
        hset.remove(beginWord);

        //at start add the begin word.
        queue.add(new Pair(beginWord, 1));

        //now run loop till the queue is empty.
        while(queue.size() > 0)
        {
            //remove
            Pair remove = queue.remove();
            //extrct the string and level;
            String word = remove.str;
            int level = remove.level;

            //if we found the desired word then we return the level.
            if(word.equals(endWord))
            {
                return level;
            }

          
            for(int i=0; i<word.length(); i++)
            {
                  //created the char array.
                char wordArray[] = word.toCharArray();

                //now run a for loop from 'a' to 'z'
                for(char j='a'; j<='z'; j++)
                {
                    wordArray[i] = j;

                    //req. string
                    String comparedString = new String(wordArray);

                    if(hset.contains(comparedString) == true)
                    {
                        hset.remove(comparedString);
                        queue.add(new Pair(comparedString, level + 1));
                    }
                }

            }
        }

        //this is sign of no sequence is found.
        return 0;
    }
}