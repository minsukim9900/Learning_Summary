//JSON 문자열

var str = '{"name":"Luna","age":4}';

var obj = JSON.parse(str);


// 배열
// [] 안에다가 값을 나열
var arr = [1,2,3,"hi"];
var arrStr = JSON.stringify(arr);

var str2 = '[1,2,3,"hi","hello","5"]'
var arr2 = JSON.parse(str2);