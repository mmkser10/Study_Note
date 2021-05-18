let a = 42;
typeof a; // number

a = true;
typeof a; // boolean

// typeof 연산자의 반환 값은 문자열이다.
typeof typeof 42; // type "number" -> string

let x;
typeof x; // undefined

let y = 42;
let z;

y = z;

typeof y; // undefined
typeof z; // undefined

// 선언하지 않은 변수를 typeof 를 이용하여 호출하면
// 브라우저에서는 오류 처리를 하지 않고 "undefined"를 리턴한다.
// 이것이 typeof만의 독특한 safe guard이다. "undeclared"와 같은 표현을
// 사용했으면 "undefined"와 충돌할 일이 없어서 편하겠지만 safe guard 의외로 쓸모가 있다.
// 전역 변수 DEBUG가 선언되었는지 안되었는지 확인이 불가능함.
if(DEBUG){
    console.log("start DEBUG!")
}
// safe guard에 의해 전역 변수 DEBUG가 선언되었는지 안되었는지 확인이 가능하다.
if(typeof DEBUG !== "undefined"){
    console.log("start DEBUG!")
}
// 내장 API 기능을 체크할 때에도 safe guard에 의해 에러가 나지 않게 한다.
if(typeof atob === "undefined"){
    atob = function () {/* */};
}

// typeof safe guard없이 전역 변수를 체크하는 방법은 전역 변수가
// 모두 전역 개체의 프로퍼티라는 점을 이용하는 것이다.
if(window.DEBUG){

}
if(window.atob){

}

// 또한 safe guard는 전역 변수를 사용하지 않을 때에도 유용하다.(바람직함의 논란이 있음)
// 카피 앤 페이스트시 해당 유틸리티의 특정 변숫값이 정의되어 있는지 체크가 가능함.
(function() {
    function FeatureXYZ(){ /* */}

    function doSomething(){
        let helper = (typeof FeatureXYZ !== "undefined") ? FeatureXYZ :
            function () { /* */};
        let val = helper();
    }

    doSomething();
})();
// function doSomething(){
//     let helper = (typeof FeatureXYZ !== "undefined") ? FeatureXYZ :
//         function () { /* */};
//     let val = helper();
// }

// 의존성 주입 설계 패턴을 선호하는 경우도 있다.
function doSomething(FeatureXYZ) {
    let helper = FeatureXYZ || function () { /* */};
    let val = helper();
}