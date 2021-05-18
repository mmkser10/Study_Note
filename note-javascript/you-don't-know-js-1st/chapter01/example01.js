typeof undefined === "undefined";
typeof true === "boolean";
typeof 42 === "number";
typeof "42" === "string";
typeof { life : 42 } === "object";

// ES6 추가
typeof Symbol() === "symbol";

// null 판별에 대한 문제
// null반환을 하고 싶지만 object로 반환된다. 이런 버그가 20년 넘게 존재해왔고
// 이제 와서 손을 볼 경우 다른 버그의 발생으로 인한 기존 웹 sw에 장애 유발함.
// 해결될 가능성이 적어보임
typeof null === "null"
typeof null === "object"

// null 판별 시 추가적인 조건이 필요하게 됨
let data = null;
(!data && typeof data === "object");

// function이 최상위 레벨의 내장 타입처럼 보이지만
// 실제로는 Object의 하위 타입이다. 즉 함수는 호출 가능한 객체이다.
typeof function a(){ /* */ } === "function"
typeof [1,2,3] === "object"