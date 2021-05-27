const array1 = [1, 2, 3, 4];
const reducer = (accumulator, currentValue) => accumulator + currentValue;

console.log(array1.reduce(reducer));
console.log(array1.reduce(reducer, 5));

console.log([0, 1, 2, 3, 4].reduce(function(accumulator, currentValue, currentIndex, array) {
	return accumulator + currentValue;
}));
console.log([0, 1, 2, 3, 4].reduce(function(accumulator, currentValue, currentIndex, array) {
	return accumulator + currentValue;
}, 10));

// 배열의 모든 값을 합산
let sum = [0, 1, 2, 3].reduce( (accumulator, currentValue) => accumulator + currentValue, 0);
console.log(sum);

// 객체 배열의 모든 값을 합산
let initialValue = 0;
let sumObject = [{x: 1}, {x:2}, {x:3}].reduce(
    (accumulator, currentValue) => accumulator + currentValue.x
	, initialValue);
console.log(sumObject);

// 중첩 배열 단일화
let flattened = [[0, 1], [2, 3], [4, 5]].reduce(
  (accumulator, currentValue ) => accumulator.concat(currentValue), []);
console.log(flattened);

// 객체 내의 값 인스턴스 개수 세기
let names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
let countedNames = names.reduce(function (allNames, name) {
	if(name in allNames)
		allNames[name]++;
	else
		allNames[name] = 1;
	return allNames;
}, {});
console.log(names, ' ', countedNames);

// 속성으로 객체 분류하기
let people = [
  { name: 'Alice', age: 21 },
  { name: 'Max', age: 20 },
  { name: 'Jane', age: 20 }
];

function groupBy(objectArray, property) {
  return objectArray.reduce(function (acc, obj) {
    let key = obj[property];
    if (!acc[key]) {
      acc[key] = [];
    }
    acc[key].push(obj);
    return acc;
  }, {});
}
console.log(groupBy(people, 'age'));

// 확장 연산자와 초기값을 이용하여 객체로 이루어진 배열에 담긴 배열을 연결
let friends = [{
  name: 'Anna',
  books: ['Bible', 'Harry Potter'],
  age: 21
}, {
  name: 'Bob',
  books: ['War and peace', 'Romeo and Juliet'],
  age: 26
}, {
  name: 'Alice',
  books: ['The Lord of the Rings', 'The Shining'],
  age: 18
}];
console.log(friends.reduce(function(accumulator, currentValue) {
  return [...accumulator, ...currentValue.books];
}, ['Alphabet']));
