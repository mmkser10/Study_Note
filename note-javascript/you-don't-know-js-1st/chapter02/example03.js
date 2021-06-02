console.log(42, 42.3)
console.log(0.42, .42)
console.log(42.0, 42.)

console.log(42.300, 42.0);
let a = 5E10;
console.log(a, a.toExponential());
console.log(a + a);
console.log(1 / a);

let b = 42.59;
console.log(b.toFixed(0));
console.log(b.toFixed(1));
console.log(b.toFixed(2));
console.log(b.toFixed(3));
console.log(b.toFixed(4));

console.log(b.toPrecision(1));
console.log(b.toPrecision(2));
console.log(b.toPrecision(3));
console.log(b.toPrecision(4));
console.log(b.toPrecision(5));
console.log(b.toPrecision(6));

// toFixed의 정확한 사용법
// 42.toFixed(3) -> 42.까지를 number타입으로 간주하기
// 때문에 Syntax Error 리턴됨:
console.log((42).toFixed(3));
console.log(0.42.toFixed(3));
console.log(42..toFixed(3));
console.log(42 .toFixed(3));

console.log(0xf3, 0Xf3, 0363, 0o363, 0O363, 0b11110011, 0B11110011);

console.log((0.1 + 0.2 === 0.3));

function numberCloseEnoughToEqual(n1, n2){
	return Math.abs(n1 - n2) < Number.EPSILON;
}
let c = 0.1 + 0.2;
let d = 0.3
console.log(numberCloseEnoughToEqual(c, d));
console.log(numberCloseEnoughToEqual(0.0000001, 0.0000002));

// 정수 확인
console.log('42.000 -> ', Number.isInteger(42.000), ' 42.3 -> ',Number.isInteger(42.3));
console.log(Number.isSafeInteger(Math.pow(2, 53)), Number.isSafeInteger(Math.pow(2, 53) - 1));
