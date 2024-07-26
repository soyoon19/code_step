a = 0, b= 1;
if (!b === a) {
    console.log("Gd");
}
console.log(`${a} 는 ${typeof(a)}`);
console.log(`${!b} 는 ${typeof(!b)}`);

let print = function(name, count) {
    console.log(`${name}이(가) ${count}개 있습니다`);

}

print("사과", 10);
print("사과");