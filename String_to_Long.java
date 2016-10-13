static long parseLong(String str) {
	//  To check if the number is positive or negative.
	boolean isPositive;
	if(str.charAt(0) != '-')
		isPositive = true;
	else
		isPositive = false;

	//  If Number is positve
	if(isPositive){
		long num = 0;
		for(int i=str.length() - 1, j=0; i>=0; i--, j++){
			num += Math.pow(10,j) * (str.charAt(i) - 48);
		}

		return num;
	}
	else{
		long num = 0;
		for(int i=str.length() - 1, j=0; i>0; i--, j++){
			num += Math.pow(10,j) * (str.charAt(i) - 48);
		}

		return num * -1;
	}

}