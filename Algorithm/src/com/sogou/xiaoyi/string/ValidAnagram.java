package com.sogou.xiaoyi.string;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s == null && t == null){
        		return true;
        }else if(s == null && t !=null){
        		return false;
        }else if(s != null && t == null){
        		return false;
        }else{
        		if(s.length() != t.length()){
        			return false;
        		}else{
        			int len = s.length();
        			int twentySix = 26;
            		int[] sTable = new int[twentySix];
            		int[] tTable = new int[twentySix];
            		for(int i=0;i<len;i++){
            			sTable[s.charAt(i) - 'a']++;
            			tTable[t.charAt(i) - 'a']++;
            		}
            		for(int i=0;i<twentySix;i++){
            			if(sTable[i] != tTable[i]){
            				return false;
            			}
            		}
            		return true;
        		}
        }
    }
}
