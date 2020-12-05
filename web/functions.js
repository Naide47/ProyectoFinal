var subjects = [
    "Where's My Stuff?",
    "Cancel Items or Orders",
    "Returns & Refunds",
    "Shipping Rates & Information",
    "Change Your Payment Method",
    "Manage Your Account Information",
    "About Two-Step Verification",
    "Cancel Items or Orders",
    "Change Your Order Information",
    "Contact Third-Party Sellers",
    "More in Managing Your Orders"
];
function Login() {
    var usuario = $("#txtUser").val();
    var password = $("#txtPass").val();
    //alert(usuario);
    //alert(password);
    var data = {
        "nombre_usuario": usuario,
        "contrasenia": password
    };
    //Se valida que los campos no esten vacios
    if (usuario == null || password == null || usuario == "" || password == "")
    {
        //Sweet alert
        Swal.fire(
                'Se debe de llenar todos los campos',
                'Verifica que los campos no esten vacios',
                'error'
                );
    } else {
        // console.log(data);
        $.ajax(
                {
                    type: "POST",
                    url: "api/Usuario/login",
                    async: true,
                    data: data
                }).done(
                function (data) {
                    var usuario1 = data;
                    console.log(usuario1);
                    if (usuario1.length > 0) {
                        console.log("usuario1 tuvo lenght >0");
                        console.log(usuario1.nombre_usuario);
                        Swal.fire(
                                'Sesion iniciada correctamenta',
                                'Bienvenido' + usuario1.nombre_usuario,
                                'success'
                                );
                        var usuario = localStorage.getItem("usuario");
                    }
                    if (usuario.length === 0) {
                        Swal.fire(
                                'Error al iniciar Sesion',
                                'Los datos ingresados son incorrectos',
                                'error'
                                );
                    }
                }
        );

    }
    $('#txtUser').val("");
    $('#txtPass').val("");
}

function logout() {

    var usuario = localStorage.getItem("usuario");
    var data = {
        usuario: usuario
    };
    $.ajax(
            {
                type: "POST",
                url: "api/login/Cerrar",
                async: true,
                data: data
            }).done(
            function (data) {
                console.log(data);
                Swal.fire('Movimiento realizado',
                        'Sesión cerrada', 'success');
                //alert("Sesion cerrada");
                location.href = "index.html";
                localStorage.clear();
            }
    );
}

function insertarPeticion() {
    var nombre = $('#txtNombre').val();
    var primerApe = $('#txtApe1').val();
    var segundoApe = $('#txtApe2').val();
    var calle = $('#txtCalle').val();
    var numExt = $('#numExt').val();
    var numInt = $('#txtInt').val();
    var letra = $('#').val();
    var cp = $('#numCP').val();
    var colonia = $('#txtCol').val();
    var municipio = $('#txtMuni').val();
    var estado = $('#txtEstado').val();
    var correo = $('#txtCorreo').val();
    var telefono = $('#numTel').val();
    var nombreEmpresa = $('#txtEmpresa').val();
    var tamanioEmpresa = $('#').val();
    var horario = $('#timeDis').val();
    var descripcion = $('#Comen').val();
    //verifica que los datos se llenen todos
    if (nombre === null || primerApe === null || calle === null || numExt === null || cp === null || colonia === null || municipio === null || estado === null || correo === null || telefono === null || nombreEmpresa === null || horario === null || descripcion === null || nombre === "" || primerApe === "" || calle === "" || numExt === "" || cp === "" || colonia === "" || municipio === "" || estado === "" || correo === "" || telefono === "" || nombreEmpresa === "" || horario === "" || descripcion === "")
    {
        //Sweet alert
        Swal.fire(
                'Se debe de llenar todos los campos',
                'Verifica que los campos * no esten vacios',
                'error'
                );
    } else {

    }
    $('#txtNombre').val("");
    $('#txtApe1').val("");
    $('#txtApe2').val("");
    $('#txtCalle').val("");
    $('#numExt').val("");
    $('#txtInt').val("");
    $('#').val("");
    $('#numCP').val("");
    $('#txtCol').val("");
    $('#txtMuni').val("");
    $('#txtEstado').val("");
    $('#txtCorreo').val("");
    $('#numTel').val("");
    $('#txtEmpresa').val("");
    $('#').val("");
    $('#timeDis').val("");
    $('#Comen').val("");
}
function closePeticion() {
    $('#txtNombre').val("");
    $('#txtApe1').val("");
    $('#txtApe2').val("");
    $('#txtCalle').val("");
    $('#numExt').val("");
    $('#txtInt').val("");
    $('#').val("");
    $('#numCP').val("");
    $('#txtCol').val("");
    $('#txtMuni').val("");
    $('#txtEstado').val("");
    $('#txtCorreo').val("");
    $('#numTel').val("");
    $('#txtEmpresa').val("");
    $('#').val("");
    $('#timeDis').val("");
    $('#Comen').val("");
}


$('#form-autocomplete-2').mdbAutocomplete({
    data: subjects
});

