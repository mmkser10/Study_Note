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

console.log(0xf3, 0Xf3, 0363, 0o363, 0O363, 0b11110011, 0B11110011)
