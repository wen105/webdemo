<html>
<head>
    <meta charset="UTF-8">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>
        Test Spring MVC JSON
    </title>
</head>
<body>
<input name="name" value="wen"><br/>
<input name="age" value="22"><br/>
<button id="test">test</button>

<table id="user" class="table table-striped  table-hover">
    <tr>
        <th>name</th>
        <th>age</th>
    </tr>
</table>
<script>
    var user = $("#user");
    $("#test").click(function () {
        var name = $("input[name=name]").val();
        var age = $("input[name=age]").val();
        var data = {name: name, age: age};
        $.ajax("test11", {
            method: "POST",
            type: "json",
            data: data,
            success: function (d) {
                if (d && d.success) {
                    window.open('showUser.jsp');
                }
                $("<tr></tr>").append($("<td></td>").text(d.name))
                        .append($("<td></td>").text(d.age)).appendTo(user);
            }
        });
    });

</script>
</body>
</html>
