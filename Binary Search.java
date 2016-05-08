int sorted_search(int []elements, int target){
	if(elements == null || elements.length <= 0)	// elements.length <= 0
		retrun -1;
	int legt = 0, right = elements.length - 1;
while(left < right){	//	<=
	int middle = (left + right + 1) / 2;	// left + (right - left) / 2
	
	if(elements[middle] > target)
		right = middle - 1;
	/*
	else if(elements[middle] < target)
		left = middle + 1;
	else
		return middle;
	*/
	else
		left = middle + 1;
}	

if(elements[right] == target)
	return right;
return -1;
}