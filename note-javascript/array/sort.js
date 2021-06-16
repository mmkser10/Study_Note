// 버블정렬
function bubbleSort(arr){
	for(let i = 0 ; i < arr.length ; i++){
	    let swap = 0;
		for(let j = 1 ; j < arr.length - i ; j++){
			if(arr[j-1] > arr[j]){
                swap = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = swap;
            }
		}
		console.log(arr);
	}
	return arr;
}

// 삽입정렬
function insertionSort(arr){
	for (let i = 0; i < arr.length; i++) {
		let index = i;
		while (arr[index - 1] > arr[index]) {
			let temp = arr[index - 1];
			arr[index - 1] = arr[index];
			arr[index] = temp;
			index--;
		}
		console.log(arr)
	}
    return arr;
}

insertionSort([5,4,3,2,1])
