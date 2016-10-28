
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII'];

assert roman[4] == 'IV'

roman[8] = 'VIII'
assert roman.size() == 9

def http = [100:'continue',200:'OK',400:'BAD REQUEST'];
assert 'OK' == http[200]

http[500] = "INTERNAL SERVER ERROR"

//println http[500]

assert http.size() == 4



//ranges相当于是一个list

def x = 1..10;     // 1 到 10

assert x.contains(5)
assert x.size() == 10;
assert x.from == 1;
assert x.to == 10

assert x.reverse() == 10..1


//闭包
//通俗的说，一个闭包是一个用花括号围起来的语句块，像别的任何代码块，为了传递参数给闭包，闭包有一组可选的参数列表，通过“ ->”表示列表的结束
[1,2,3].each{entr -> println entr}


//使用闭包计算所有在会议室的客人之间的碰杯数,我们使用类Integer的upto方法，这个方法用来从当前整数值到结束的整数值之间

def totalClinks = 0;
def partyPeople = 100;
1.upto(partyPeople){
	guestNumber ->  clinksWithGuest = guestNumber - 1;
	totalClinks  += clinksWithGuest;
}


assert totalClinks == (partyPeople*(partyPeople - 1))/2;

//it是groovy保留字符

1.upto(9){
	x = it;
	1.upto(9){
		y = it;
		z = x * y;
		 print ((z < 10 ? " " + z : z) + " ")
	}
	println "";
}


def code = '1 + ';
code += System.getProperty('os.version');

println code;
println evaluate(code);

/*读取文件
 * 
 * new File("E:/workspace_juno/yxck/ofbiz-release13.07/hot-deploy/yxck/src/org/ofbiz/yxck/redis/RedisUtil.java").getText().eachLine{
	println it;
}*/

def a = 1;
println a.plus(2);


assert "ABCDE".indexOf('C') == 2;






