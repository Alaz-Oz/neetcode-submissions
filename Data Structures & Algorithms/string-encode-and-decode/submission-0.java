class Solution {

    public String encode(List<String> strs) {
        StringBuilder b = new StringBuilder();
        for(String s : strs){
            b.append(s.length()).append('.').append(s);
        }
        return b.toString(); // 3.Hey5.Hello5.hy4.h
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();
        StringBuilder lengthString = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        int length = -1;
        int curLength = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (length > 0){
                // We are finding string
                curLength++;
                builder.append(c);

                if (length == curLength){
                    // This is the last char
                    result.add(builder.toString());
                    length = -1;
                    curLength = 0;
                }

            }else {
                // We are finding length
                if (c == '.'){
                    // Length found
                    length = Integer.parseInt(lengthString.toString());
                    lengthString.setLength(0);
                    builder.setLength(0);

                    // Handle 0 length string
                    if (length == 0) {
                        result.add("");
                        length = -1;
                    }
                    continue;
                }

                lengthString.append(c);
            }


        }

        return result;
    }
}
