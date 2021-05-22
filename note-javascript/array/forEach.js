const array1 = ['a', 'b', 'c'];
array1.forEach(element => console.log(element));

const arraySparse = [1,3, ,7];
let numCallbackRuns = 0;

// 초기화하지 않은 배열 값의 반복 생략
arraySparse.forEach(function(element){
	console.log(element);
	numCallbackRuns++;
});
console.log("numCallbckRuns: ", numCallbackRuns);


// for -> forEach()로 바꾸기
const items = ['item1', 'item2', 'item3'];
const copy = [];
// 이전
for (let i=0; i<items.length; i++) {
  copy.push(items[i]);
}
// 이후
items.forEach(function(item){
  copy.push(item);
});


