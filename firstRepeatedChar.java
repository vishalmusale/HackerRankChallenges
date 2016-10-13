public static char repeatedChar(String str){
	if(str == null)
		return;
	else{
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++){
			if(hm.containsKey(str.charAt(i)))
				return str.charAt(i);
			else
				hm.put(str.charAt(i), 0);
		}
		return;
	}
}