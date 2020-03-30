## JQuery的方式异步请求

### $.ajax
```javascript
$.ajax({“type”:"get","url":"data1.txt"});//人的阅读性不是很好
$.ajax({
    "type":"get", //含义：亲求方式。默认值：参数不写，采用默认值：get方式。type是
参数名称，可以使用双引号(推荐)，也可以使用单引号，也可以不写引号。
    "url":"data1.txt", //含义：指定异步请求的地址
    "contentType":"application/x-www-form-urlencode",// 含义：post请求方式时，请求内
容的数据类型。默认值：application/x-www-form-urlencode
    "data":"username=admin&password=123", //客户端发送给服务器的数据。此处的数据类
型就是application/x-www-form-urlencode
    "async":true, //含义：是否是异步。默认值是true（异步）
    "dataType":"text", //含义：服务器响应的内容的类型。可选值：xml、html、script、
    json（js代码）、jsonp、text（纯文本）
    "success":function(data){ //含义：服务器正常返回时，执行的代码。函数中的data表示服
务器返回的响应内容
    "error":function(response){//含义：服务器没有正确返回时执行的代码。
}
});
```

>磁盘系统：（计算机上的文件）是通过文件的扩展名来区分文件的类型的。比如：.txt，.html，.doc网络数据：是通过MIME类型区分数据的类型的。纯文本：text/plain，html内容：text/html:json内容：
application/json。即MIME类型是由“大类型/具体类型”

### $.get
$.get(地址，请求的数据，回调函数，数据类型);发送get请求

```
 $("#bt2").click(function () {
                $.get(
                    "data2.txt", //请求的地址
                    "",//请求的数据
                    function (data) {//响应成功执行的函数
                        for (let d of data) {//dataType直接指定json，就不用自己将文本转换为js
                            let spanObj = document.querySelector("#content");
                            spanObj.innerHTML = spanObj.innerHTML + d;
                        }
                    },
                    "json"//响应返回的数据类型
                );
            });
```

### $.post
```
$("#bt3").click(function () {
                $.post(
                    "data2.txt", //请求的地址
                    "",//请求的数据
                    function (data) {//响应成功执行的函数
                        for (let d of data) {//dataType直接指定json，就不用自己将文本转换为js
                            let spanObj = document.querySelector("#content");
                            spanObj.innerHTML = spanObj.innerHTML + d;
                        }
                    },
                    "json"//响应返回的数据类型
                );
            });
```