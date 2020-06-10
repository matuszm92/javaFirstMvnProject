$(document).ready(function () {
    var $app = $('#app');
    
    $.get("/api/user/list", function (data, status) {
        $app.append('<ul class="list-group"')
        if(data) {
            data.forEach(user => {
                $app.append('<li class="list-group-item">' + user.login + '</li>');
            });
        }
        $app.append('</ul>')
    });
    
    $("button").click(function () {
        $.post("/api/user/add",
            {
                login: $('#login').val(),
                firstName: $('#firstName').val(),
                lastName: $('#lastName').val(),
                password: $('#password').val()
            },
            function (data, status) {
    
            });
    }); 
});
