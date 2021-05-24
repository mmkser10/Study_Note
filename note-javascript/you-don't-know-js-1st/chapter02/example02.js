let a = 'foo';
let b = ['f','o','o'];
console.log(a.length, b.length);
console.log(a.indexOf('o'), b.indexOf('o'));
let c = a.concat('bar');
let d = b.concat(['b','a', 'r']);
console.log(a === c, b === d);
console.log(a, b);

// 불변값과 가변값의 차이.
a[1] = 'O';
b[1] = 'O';
console.log(a, b);

c = a.toUpperCase();
console.log(a === c);
console.log(a, c);
b.push('!');
console.log(b);

console.log(a.join, a.map);
let e = Array.prototype.join.call(a, '-');
let f = Array.prototype.map.call( a, (v) => v.toUpperCase() + '.').join('');
console.log(e, f)

// 문자열 뒤집기.
console.log(a.reverse, b.reverse(), b);

console.log(a.split('').reverse().join(''));
