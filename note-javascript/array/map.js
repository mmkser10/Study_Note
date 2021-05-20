// 배열에 들어있는 숫자들을 2로 곱해서 구한 새로운 배열을 만들기
const array1 = [1, 4, 9, 16];
const map1 = array1.map(el => el * 2);
console.log(map1);

// 배열에 들어있는 숫자들의 제곱근을 구하여 새로운 배열을 만들기
const array2 = [1, 4, 9];
const map2 = array2.map(el => Math.pow(el, 2));
console.log(map2);

// 배열 속 객체를 재구성하기
const kvArray = [
	{key:1, value:10},
	{key:2, value:20},
	{key:3, value: 30}
];
const reformattedArray = kvArray.map(function(obj){
   var rObj = {};
   rObj[obj.key] = obj.value;
   return rObj;
});
console.log(reformattedArray);

// map을 사용해서 각 문자의 ASCII 인코딩 값을 요소로 갖는 배열을 만들기
const map3 = Array.prototype.map;
const result = map3.call('Hello World', x => x.charCodeAt(0));
console.log(result);

// map에 하나의 인자(순회하는 원소)만 받는 콜백을 사용하는 경우가 많지만
// 어떤 함수는 대개 하나의 인자로 호출하지만 두 개 이상의 인자를 사용하는 경우도 존재
const number = ['1', '2', '3'];
const number_result_a = number.map(parseInt);
const number_result_b = number.map(el => parseInt(el));
const number_result_c = number.map(Number);

console.log(number_result_a);
console.log(number_result_b);
console.log(number_result_c);
