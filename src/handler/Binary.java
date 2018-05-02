package handler;

public class Binary {

    public static String stringToBinary(String text)
    {
        String bString="";
        String temp="";
        for(int i=0;i<text.length();i++)
        {
            temp=Integer.toBinaryString(text.charAt(i));
            for(int j=temp.length();j<8;j++)
            {
                temp="0"+temp;
            }
            bString+=temp;
        }
        return bString;
    }
    public static String binaryToString(String binaryCode)
    {
        String[] code = binaryCode.split("(?<=\\G........)");
        String word="";
        for(int i=0;i<code.length;i++)
        {
            word+= (char)Integer.parseInt(code[i],2);
        }
        return word;
    }

}
