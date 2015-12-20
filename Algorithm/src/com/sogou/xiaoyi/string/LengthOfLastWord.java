package com.sogou.xiaoyi.string;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }else{
            int count = 0;
            int i = s.length()- 1;
            for(;i>=0;i--){
                if(s.charAt(i) == ' '){
                	
                }else{
                		break;
                }
            }
            for(;i>=0;i--){
            		if(s.charAt(i) == ' '){
            			break;
            		}else{
            			count++;
            		}
            }
            return count;
        }
    }
}