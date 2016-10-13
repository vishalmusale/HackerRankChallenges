//	Assuming the given number is pure integer, including positive and negative.

public static int reverse_number(int num){
	int newNum=0;
	String tNum = "" + num;
	if(num >= 0){	//	For positive numbers
		for(int i=0; i<tNum.length(); i++){
			newNum += Math.pow(10, i) * (tNum.charAt(i) - 48);
		}

		return newNum;
	}
	else{			//	For negative numbers
		for(int i=1; i<tNum.length(); i++){
			newNum += Math.pow(10, i-1) * (tNum.charAt(i) - 48);
		}

		return newNum * -1;
	}
}