// JSON이란?
// 자바스크립트 객체를 문자열로 나타낸 것.
// - 속성명은 문자열이므로 "" 가 붙는다.
// - 값이 숫자라면 ""가 붙지 않는다.
// - 값이 문자열이라면 ""가 붙는다.
// JSON 객체를 사용.
// JSON.stringify() : 객체 -> 문자열
// JSON.parse() : 문자열 -> 객체

var luna = {
    name: "Luna",
    age: 4
}

var daisy = {
    name: "Daisy",
    age: '3'
}

var lunaStr = JSON.stringify(luna);
var daisyStr = JSON.stringify(daisy);

// 자바와의 차이점
// 자바스크렙트에서는 : ' '도 문자열을 표시하는데 사용