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

var usuario1;
var peticiones;

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
                    usuario1 = data;
                    console.log(usuario1);
                    //console.log("usuario1 tuvo lenght >0");
                    console.log(usuario1.nombre_usuario);
                    Swal.fire(
                            'Sesion iniciada correctamenta',
                            'Bienvenido' + usuario1.nombre_usuario +
                            'success'
                            );
                    localStorage.setItem('idUsuario', usuario1.idUsuario);
                    location.href = "Peticiones.html";

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

    localStorage.clear();
    location.href = "index.html";
}

//function letra1() {
//    var select1 = document.getElementById("letra");
//    var letra = select1.options[select1.selectedIndex].text;
//    return letra;
//}

function tamanio_empresa() {
    var select2 = document.getElementById("tamanio_empresa");
    var empresa = select2.options[select2.selectedIndex].text;
    return empresa;
}

function paises1() {
    var select3 = document.getElementById("paises");
    var paises = select3.value;
    return paises;
}

function insertarPeticion() {
    var nombre = $('#txtNombre').val();
    var primerApe = $('#txtApe1').val();
    var segundoApe = $('#txtApe2').val();
    var calle = $('#txtCalle').val();
    var numExt = $('#numExt').val();
    var numInt = $('#txtInt').val();
    //var letra = letra1();
    var cp = $('#numCP').val();
    var colonia = $('#txtCol').val();
    var municipio = $('#txtMuni').val();
    var estado = $('#txtEstado').val();
    var correo = $('#txtCorreo').val();
    var telefono = $('#numTel').val();
    var nombreEmpresa = $('#txtEmpresa').val();
    var tamanioEmpresa = tamanio_empresa();
    var horario = $('#timeDis').val();
    var descripcion = $('#Comen').val();
    var paises = paises1();
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
        console.log(paises);
        var data = {
            "nombres": nombre,
            "primer_apellido": primerApe,
            "segundo_apellido": segundoApe,
            "ciudad": municipio,
            "colonia": calle,
            "cp": cp.toString(),
            "numero_exterior": numExt.toString(),
            "numero_interior": "0",
            "telefono": telefono.toString(),
            "celular": telefono.toString(),
            "correo": correo,
            "tamanio_empresa": tamanioEmpresa,
            "horario_disponible": horario.toString(),
            "nombre_empresa": nombreEmpresa,
            "persona_fisica_moral": nombre + '' + primerApe + '' + segundoApe,
            "descripcion": descripcion,
            "paises": "10"
        };
        console.log(data);
        $.ajax(
                {
                    type: "POST",
                    url: "api/Peticion/enviarPeticion",
                    async: true,
                    data: data
                }).done(
                function (data) {

                    Swal.fire('Movimiento realizado',
                            'Peticion enviada.\nEspere su respuesta por correo', 'success');
                    //alert("Sesion cerrada");
                    location.href = "index.html";

                }
        );


    }
    $('#txtNombre').val("");
    $('#txtApe1').val("");
    $('#txtApe2').val("");
    $('#txtCalle').val("");
    $('#numExt').val("");
    $('#txtInt').val("");
//    $('#').val("");
    $('#numCP').val("");
    $('#txtCol').val("");
    $('#txtMuni').val("");
    $('#txtEstado').val("");
    $('#txtCorreo').val("");
    $('#numTel').val("");
    $('#txtEmpresa').val("");
//    $('#').val("");
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


function consultarPeticiones() {
    $.ajax({
        type: "GET",
        url: "api/Peticion/consultarPeticiones",
        async: true
    }).done(
            function (data) {
                peticiones = data;
                var str = '<tr>' +
                        '<th scope="col"><strong>Nombre del cliente</strong></th>' +
                        '<th scope="col"><strong>Petición</strong></th>' +
                        '<th scope="col"><strong>Opciones</strong></th>' +
                        '</tr>';
                console.log(data);

                for (var i = 0; i < peticiones.length; i++) {
                    str += '<tr id="' + peticiones[i].idPeticion + '">' +
                            '<td>' + peticiones[i].cliente.persona_fisica_moral + '</td>' +
                            '<td>' + peticiones[i].descripcion + '</td>' +
                            '<td class="text-danger">' +
                            '<button type="button" class="btn btn-outline-info waves-effect btn-rounded btn-sm m-0" data-toggle="modal" data-cliente=' + peticiones[i].cliente.persona_fisica_moral + ' data-correo=' + peticiones[i].cliente.correo_electronico + ' data-telefono=' + peticiones[i].cliente.telefono + ' data-problematica-' + peticiones[i].descripcion + ' data-target="#fullHeightModalRight" onclick="llenarModal(' + i + ');">' +
                            '<i class="fas fa-eye fa-lg"></i></button>' +
                            '<button type="button" class="btn btn-outline-danger waves-effect btn-rounded btn-sm m-0" disabled><i class="far fa-trash-alt fa-lg"></i></button>' +
                            '</td>' +
                            '</tr>';
                }
                $('#tblPeticiones').html(str);
            }
    )
}


function llenarModal(i) {
    var peticion = peticiones[i];
    //console.log(peticion);

    $('#txtClienteU').val(peticion.cliente.persona_fisica_moral);

    $('#txtCorreoU').val(peticion.cliente.correo_electronico);
    $('#txtTelU').val(peticion.cliente.telefono);
    $('#txtComent').val(peticion.descripcion);

    $('#btnAceptar').val(peticion.idPeticion);
}

function aceptarPeticion() {
    //var peticion = peticiones[i];
    var idPeticion = $('#btnAceptar').val();
    var idUsuario = localStorage.getItem('idUsuario');
//    console.log(idPeticion);
//    console.log(idUsuario);

    data = {
        "idPeticion": idPeticion,
        "idUsuario": idUsuario
    }

    $.ajax({
        type: "POST",
        url: "api/Peticion/aceptarPeticion",
        async: true,
        data: data
    }).done(function (data) {
//        console.log(data)
        Swal.fire(
                'Peticion aceptada',
                'La peticion fue aceptada correctamente',
                'success'
                );
        location.reload();
    });
}

