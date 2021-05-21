console.log('배열');
const a = [1, '2', [3]];
console.log(a);
console.log(a.length);
console.log(a[0] === 1);
console.log(a[2][0] === 3);

// 빈 배열에 값 입력
console.log('빈 배열에 값 입력');
let b = [];
console.log(b);
console.log(b.length);
b[0] = 1;
b[1] = '2';
b[2] = [3];
console.log(b.length);

// 구멍 난 배열 생성이 가능하므로 조심하여야 한다.
let c = [];
c[0] = 1;
c[2] = [3];
console.log(c);
console.log(c.length);

// 유사 배열
function foo(){
	let arr = Array.prototype.slice.call(arguments);
	arr.push('bam');
	console.log(arr);
}
foo('bar', 'baz');

function anotherFoo(){
	let arr = Array.from(arguments);
	arr.push('bam');
	console.log(arr);
}
anotherFoo('bar', 'baz');
