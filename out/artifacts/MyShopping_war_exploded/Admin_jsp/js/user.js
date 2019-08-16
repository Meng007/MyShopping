
var u_id =new Array();
function checkAll() {
    var chAll = document.getElementById("checks");
    var checks = document.getElementsByName("ch");
    //alert("开始")
    if(chAll.checked){
        for (var i=0;i<checks.length;i++){
            checks[i].checked=true;
        }
    }else {
        for (var i=0;i<checks.length;i++){
            checks[i].checked=false;
    }

    }
    getId();
    for (var i=0;i<u_id.length;i++){
        console.log(u_id[i]);
        //alert("666")
    }

}
//获取用户的id
function getId() {
    var checks = document.getElementsByName("ch");
    for (var i=0;i<checks.length;i++){
        //checks[i].checked=false;
        if (checks[i].checked) {
            var td = checks[i].parentElement;
            var tr = td.parentElement;
            var id = tr.children[1].innerText;
            u_id.push(id);
        }
    }
}

//第一步，创建XMLHttpRequest对象
var xmlHttp = new XMLHttpRequest();

function CommentAll() {
    //第二步，注册回调函数
    xmlHttp.onreadystatechange = callback1;
    //第三步，配置请求信息，open(),get
    //get请求下参数加在url后，.ashx?methodName = GetAllComment&str1=str1&str2=str2
    xmlHttp.open("post", "adminServlet?id="+u_id, true);

    //post请求下需要配置请求头信息
    //xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    //第四步，发送请求,post请求下，要传递的参数放这
    xmlHttp.send(null);//"

}

//第五步 根据不同的响应进行处理
function callback1() {
    if (xmlHttp.readyState == 4)
        if (xmlHttp.status == 200) {
            alert("成功")
            dele();
        }
}
function dele() {
    var checks = document.getElementsByName("ch");
    for (var i=0;i<checks.length;i++){
        if (checks.checked){
            var td = checks[i].parentElement;
            var tr = td.parentElement;
            tr.remove()
        }
    }
}