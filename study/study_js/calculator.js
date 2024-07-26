const readLine = require('readline-sync');

function showPrompt() {
    console.clear();
    const testStr = readLine.question('Enter test message : ');
    console.log(testStr);

}

showPrompt();
// 함수 선언문
function fun1() {
    console.log("fun1");
};
fun1();

// 함수 표현식
let fun2 = function() {
    console.log("fun2");
};
fun2();

function callTenTimes(callback) {
    // 10회 반복
    for (let i = 0; i < 10; i++) {
        // 매개 변수로 전달된 함수를 호출
        callback();
    }
}

// 변수 선언
callTenTimes(function () {
    console.log(`함수 ${i + 1}번 출력`);
})