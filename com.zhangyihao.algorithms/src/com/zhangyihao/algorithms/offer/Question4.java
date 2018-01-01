package com.zhangyihao.algorithms.offer;

/**
 * 面试题4
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author zhangyihao
 *
 */
public class Question4 {

	public String replaceSpace(StringBuffer str) {
		int spaceNum = 0;
		for(int i=0; i<str.length(); i++) {
			if(Character.isSpaceChar(str.charAt(i))) {
				spaceNum++;
			}
		}
		
		if(spaceNum>0) {
			int oldLength = str.length();
			int newLength = oldLength + (2*spaceNum);
			str.setLength(newLength);
			
			for(int oldIndex=oldLength-1, newIndex=newLength-1; oldIndex>=0 && oldIndex!=newIndex; oldIndex--) {
				char ch = str.charAt(oldIndex);
				if(Character.isSpaceChar(ch)) {
					str.setCharAt(newIndex--, '0');
					str.setCharAt(newIndex--, '2');
					str.setCharAt(newIndex--, '%');
				} else {
					str.setCharAt(newIndex, ch);
					newIndex--;
				}
			}
		}
		
		return str.toString();
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("We Are Hap py");
		Question4 q = new Question4();
		System.out.println(q.replaceSpace(sb));
	}

}
