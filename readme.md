<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Documentación de la API</h1>
    <div class="indice">
        <h2>Índice de Contenidos</h2>
        <ul>
            <li><a href="#descripcion">Descripción</a></li>
            <li><a href="#tecnologias">Tecnologías Utilizadas</a></li>
            <li><a href="#acceso">Acceso a la API</a></li>
            <li><a href="#autenticacion">Autenticación</a></li>
            <li><a href="#endpoints">Endpoints</a>
                <ul>
                    <li><a href="#hoteles">1. Hoteles</a></li>
                    <li><a href="#pois">2. Puntos de Interés (POIs)</a></li>
                    <li><a href="#vuelos">3. Vuelos</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <h2 id="descripcion">Descripción</h2>
    <p>Esta API proporciona acceso a información y funcionalidades relacionadas con:</p>
    <ul>
        <li><strong>Hoteles:</strong> Consulta, creación, actualización y eliminación de hoteles, así como reservas asociadas.</li>
        <li><strong>Vuelos:</strong> Consulta, creación, actualización y eliminación de vuelos, así como reservas asociadas.</li>
        <li><strong>Puntos de Interés (POIs):</strong> Consulta, creación, actualización y eliminación de puntos de interés, así como reservas asociadas</li>
    </ul>
    <h2 id="tecnologias">Tecnologías Utilizadas</h2>
    <ul>
        <li>Java (Spring Boot)</li>
        <li>MongoDB (Base de datos)</li>
        <li>Thymeleaf (para vistas HTML)</li>
        <li>Maven (gestión de dependencias)</li>
    </ul>
    <h2 id="acceso">Acceso a la API</h2>
    <p>Para acceder a esta API se realiza accediendo al siguiente enlace de internet:</p>
    <pre><code>https://apiturismo-sjtd.onrender.com</code></pre>
    <h2 id="autenticacion">Autenticación</h2>
    <p>La API utiliza tokens para validar las solicitudes protegidas.Todos los endpoints de modificación (POST, PUT, DELETE) requieren autenticación mediante un token como parámetro:</p>
    <pre><code>?token=tu-token-de-autenticacion</code></pre>
    <h2 id="endpoints">Endpoints</h2>
    <p>Para acceder a la interfaz gráfica de la API accede mediante el sigueinte endpoint:</p>
    <pre><code>https://render.com/api/</code></pre>
    <h3 id="hoteles">1. Hoteles</h3>
    <h4>1.1 Listar todos los hoteles</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/hoteles</p>
    <p><strong>Descripción:</strong> Devuelve una lista con todos los hoteles disponibles.</p>
    <pre><code>
    [
        {
            "_id": "67b8969a5d15acb64c08b692",
            "nombre": "Compania ZDNN S.A. Hotel",
            "ciudad": "Murcia",
            "direccion": "Callejon Belen Rocha 48 Puerta 4 ",
            "telefono": "+34 945 578 713",
            "email": "bernardoneira@grupo.com",
            "estrellas": 4,
            "precio": 95.0
        },
        { ...
    ]
    </code></pre>
    <h4>1.2 Obtener un hotel por su ID</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/hoteles/{id}</p>
    <p><strong>Descripción:</strong> Obtén la información detalla de un hotel de la base de datos mediante su ID.</p>
    <pre><code>
    {
        "_id": "67b8969a5d15acb64c08b695",
        "nombre": "Hnos Nicolau S.L. Hotel",
        "ciudad": "Palma de Mallorca",
        "direccion": "Glorieta Goyo Sanabria 36",
        "telefono": "+34886 731 781",
        "email": "alcoleaciro@distribuciones.net",
        "estrellas": 5,
        "precio": 121.77
    }
    </code></pre>
    <h4>1.3 Crear un nuevo hotel</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/hoteles</p>
    <p><strong>Descripción:</strong> Crea un nuevo hotel en la base de datos.</p>
    <pre><code>
    {
        "nombre": "Ramos & Asociados S.L.N.E Hotel",
        "ciudad": "Sevilla",
        "direccion": "Rambla Socorro Revilla 3",
        "telefono": "+34922634216",
        "email": "sosaivan@talleres.net",
        "estrellas": 2,
        "precio": 137.93
    }
    </code></pre>
    <h4>1.4 Actualizar un hotel existente</h4>
    <p><strong>Método:</strong> PUT</p>
    <p><strong>URL:</strong> /api/hoteles/{id}</p>
    <p><strong>Descripción:</strong> Actualiza los detalles de un hotel existente.</p>
    <pre><code>
    {
        "nombre": "Hotel Costa del Sol Renovado",
        "precioPorNoche": 95.0
    }
    </code></pre>
    <h4>1.5 Eliminar un hotel</h4>
    <p><strong>Método:</strong> DELETE</p>
    <p><strong>URL:</strong> /api/hoteles/{id}</p>
    <p><strong>Descripción:</strong> Elimina un hotel por su ID.</p>
    <pre><code>
    {
        "mensaje": "Hotel eliminado exitosamente"
    }
    </code></pre>
    <h4>1.6 Filtrar por ciudad</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/hoteles/ciudad/{ciudad}</p>
    <p><strong>Descripción:</strong> Muestra todos los hoteles disponibles que hay en la ciudad.</p>
    <pre><code>
    {
        "_id": "67b8969a5d15acb64c08b734",
        "ciudad": "Malaga",
        "direccion": "Glorieta Teresita Ibanez 20 Puerta 3 ",
        "email": "ainaraporcel@logistica.com",
        "estrellas": 4,
        "nombre": "Hermanos Poza S.A. Hotel",
        "precio": 136.49,
        "telefono": "+34942730371"
    },
    {
        "_id": "67b8969a5d15acb64c08b73a",
        "ciudad": "Malaga",
        "direccion": "Alameda de Carmelita Morata 76 Puerta 5 ",
        "email": "victor76@familia.com",
        "estrellas": 4,
        "nombre": "Distribuciones CA S.L. Hotel",
        "precio": 214.69,
        "telefono": "+34 880 983 684"
    }, 
    { ...
    </code></pre>
    <h4>1.7 Filtrar por estrellas</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/hoteles/estrellas/{estrellas}</p>
    <p><strong>Descripción:</strong> Muestra todos los hoteles disponibles que tengan esas determinadas estrellas.</p>
    <pre><code>
    {
        "_id": "67b8969a5d15acb64c08b783",
        "ciudad": "Vitoria",
        "direccion": "Pasadizo Trinidad Santiago 41",
        "email": "mgabaldon@instalaciones.es",
        "estrellas": 5,
        "nombre": "Compania Pedro S.A. Hotel",
        "precio": 136.56,
        "telefono": "+34873344762"
    },
    {
        "_id": "67b8969a5d15acb64c08b789",
        "ciudad": "Murcia",
        "direccion": "C. Jose Mari Enriquez 26 Apt. 32 ",
        "email": "rmenendez@mineria.net",
        "estrellas": 5,
        "nombre": "Baquero & Asociados S.Coop. Hotel",
        "precio": 73.31,
        "telefono": "+34 943642147"
    },
    { ...
    </code></pre>
    <h4>1.8 Filtrar por intervalo de precios</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/hoteles/precio/{precioAfter}&{precioBefore}</p>
    <p><strong>Descripción:</strong> Muestra todos los hoteles disponibles cuyo precio esté entre el intervalo de precios.</p>
    <pre><code>
    {
        "_id": "67b8969a5d15acb64c08b75d",
        "ciudad": "Murcia",
        "direccion": "C. de Teresita Campillo 27",
        "email": "eporcel@transportes.com",
        "estrellas": 1,
        "nombre": "Talleres HJC S.Com. Hotel",
        "precio": 98.79,
        "telefono": "+34963203093"
    },
    {
        "_id": "67b8969a5d15acb64c08b767",
        "ciudad": "Sevilla",
        "direccion": "Vial Nicanor Gomez 417",
        "email": "barrosoramon@santamaria.com",
        "estrellas": 3,
        "nombre": "Hermanos Pazos S.A. Hotel",
        "precio": 96.5,
        "telefono": "+34 877 55 48 64"
    },
    { ...
    </code></pre>
    <h4>1.9 Reservar un hotel</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/hoteles/reserva/{id}</p>
    <p><strong>Descripción:</strong> Realiza una reserva asignada a un usuario para un hotel específico.</p>
    <pre><code>
    {
        "hotel": {
          "_id": "67b8969a5d15acb64c08b72c",
          "ciudad": "Oviedo",
          "direccion": "Acceso de Geronimo Valenzuela 73 Puerta 5 ",
          "email": "odalyscabo@industrias.com",
          "estrellas": 2,
          "nombre": "Logistica FNC S.A.U Hotel",
          "precio": 91.38,
          "telefono": "+34 928647292"
    },
        "usuario": {
          "_id": "67b75cf05d15acb64c08abee",
          "nombre": "Margarita",
          "apellidos": "Jover",
          "email": "margarita.jover@hotmail.com",
          "telefono": "+34 827 680 061"
      }
    }
    </code></pre>
    <h3 id="pois">2. Puntos de Interés (POIs)</h3>
    <h4>2.1 Listar todos los puntos de interés</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/pois/</p>
    <p><strong>Descripción:</strong> Devuelve una lista con todos los puntos de interés disponibles.</p>
    <pre><code>
    [
        {
            "_id": "67b896bb5d15acb64c08b885",
            "ciudad": "Valencia",
            "horario_apertura": "9:00-19:00",
            "nombre": "Castillo Dignissimos Valencia",
            "precio": 4.48,
            "tipo": "Castillo"
        },
        {
            "_id": "67b896bb5d15acb64c08b886",
            "ciudad": "Logrono",
            "horario_apertura": "9:00-21:00",
            "nombre": "Catedral Iste Logrono",
            "precio": 17.33,
            "tipo": "Catedral"
        },
        { ...
    ]
    </code></pre>
    <h4>2.2 Obtener un punto de interés por su ID</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/pois/{id}</p>
    <p><strong>Descripción:</strong> Obtiene la información detallada de un punto de interés mediante su ID.</p>
    <pre><code>
    {
        "_id": "67b896bb5d15acb64c08b86f",
        "ciudad": "Valencia",
        "horario_apertura": "10:00-21:00",
        "nombre": "Parque Natural Eius Valencia",
        "precio": 11.92,
        "tipo": "Parque Natural"
    }
    </code></pre>
    <h4>2.3 Crear un nuevo punto de interés</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/pois/</p>
    <p><strong>Descripción:</strong> Crea un nuevo punto de interés en la base de datos.</p>
    <pre><code>
    {
        "nombre": "Catedral de Santiago",
        "ciudad": "Santiago de Compostela",
        "horario_apertura": "8:00-20:00",
        "precio": 0.0,
        "tipo": "Iglesia"
    }
    </code></pre>
    <h4>2.4 Actualizar un punto de interés existente</h4>
    <p><strong>Método:</strong> PUT</p>
    <p><strong>URL:</strong> /api/pois/{id}</p>
    <p><strong>Descripción:</strong> Actualiza los detalles de un punto de interés existente.</p>
    <pre><code>
    {
        "nombre": "Museo del Prado",
        "horario_apertura": "9:00-21:00",
        "precio": 18.0
    }
    </code></pre>
    <h4>2.5 Eliminar un punto de interés</h4>
    <p><strong>Método:</strong> DELETE</p>
    <p><strong>URL:</strong> /api/pois/{id}</p>
    <p><strong>Descripción:</strong> Elimina un punto de interés por su ID.</p>
    <pre><code>
    {
        "mensaje": "El punto de interés ha sido borrado con éxito"
    }
    </code></pre>
    <h4>2.6 Filtrar por ciudad</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/pois/ciudad/{ciudad}</p>
    <p><strong>Descripción:</strong> Muestra todos los puntos de interés disponibles en la ciudad especificada.</p>
    <pre><code>
    [
        {
            "_id": "67b896bb5d15acb64c08b882",
            "ciudad": "Malaga",
            "horario_apertura": "9:00-20:00",
            "nombre": "Museo Vel Malaga",
            "precio": 13.76,
            "tipo": "Museo"
        },
        {
            "_id": "67b896bb5d15acb64c08b884",
            "ciudad": "Malaga",
            "horario_apertura": "9:00-21:00",
            "nombre": "Castillo Sint Malaga",
            "precio": 15.34,
            "tipo": "Castillo"
        },
        { ...
    ]
    </code></pre>
    <h4>2.7 Filtrar por tipo</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/pois/tipo/{tipo}</p>
    <p><strong>Descripción:</strong> Muestra todos los puntos de interés del tipo especificado.</p>
    <pre><code>
    [
        {
            "_id": "67b896bb5d15acb64c08b867",
            "ciudad": "Ceuta",
            "horario_apertura": "9:00-18:00",
            "nombre": "Parque Natural Facilis Ceuta",
            "precio": 9.03,
            "tipo": "Parque Natural"
        },
        {
            "_id": "67b896bb5d15acb64c08b868",
            "ciudad": "Ceuta",
            "horario_apertura": "10:00-20:00",
            "nombre": "Parque Natural Ea Ceuta",
            "precio": 11.7,
            "tipo": "Parque Natural"
        },
        { ...
    ]
    </code></pre>
    <h4>2.8 Filtrar por intervalo de precios</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/pois/precio/{precioAfter}&{precioBefore}</p>
    <p><strong>Descripción:</strong> Muestra todos los puntos de interés cuyo precio esté dentro del intervalo especificado.</p>
    <pre><code>
    [
        {
            "_id": "67b896bb5d15acb64c08b883",
            "ciudad": "Sevilla",
            "horario_apertura": "8:00-18:00",
            "nombre": "Monumento Repellendus Sevilla",
            "precio": 18.97,
            "tipo": "Monumento"
        },
        {
            "_id": "67b896bb5d15acb64c08b884",
            "ciudad": "Malaga",
            "horario_apertura": "9:00-21:00",
            "nombre": "Castillo Sint Malaga",
            "precio": 15.34,
            "tipo": "Castillo"
        },
        { ...
    ]
    </code></pre>
    <h4>2.9 Reservar un punto de interés</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/pois/reserva/{id}</p>
    <p><strong>Descripción:</strong> Realiza una reserva asignada a un usuario para un punto de interés específico.</p>
    <pre><code>
    {
        "usuario": {
            "_id": "67b75cf05d15acb64c08abed",
            "nombre": "Sarita",
            "apellidos": "Martorell",
            "email": "sarita.martorell@yahoo.com",
            "telefono": "+34973 794 523"
        },
        "poi": {
            "_id": "67b896bb5d15acb64c08b883",
            "ciudad": "Sevilla",
            "horario_apertura": "8:00-18:00",
            "nombre": "Monumento Repellendus Sevilla",
            "precio": 18.97,
            "tipo": "Monumento"
        }
    }
    </code></pre>
    <h3 id="vuelos">3. Vuelos</h3>
    <h4>3.1 Listar todos los vuelos</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/vuelos/</p>
    <p><strong>Descripción:</strong> Devuelve una lista con todos los vuelos disponibles.</p>
    <pre><code>
    [
        {
            "_id": "67b387105d15acb64c088a4a",
            "codigo": "UX950",
            "duracion": 81,
            "fecha_salida": "2025-05-21",
            "origen": "Ceuta",
            "destino": "Santa Cruz de Tenerife",
            "hora_salida": "19:46"
        },
        {
            "_id": "67b387105d15acb64c088a4b",
            "codigo": "UX864",
            "duracion": 171,
            "fecha_salida": "2025-03-12",
            "origen": "Palma de Mallorca",
            "destino": "Toledo",
            "hora_salida": "07:49"
        },
        { ...
    ]
    </code></pre>
    <h4>3.2 Obtener un vuelo por su ID</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/vuelos/{id}</p>
    <p><strong>Descripción:</strong> Obtiene la información detallada de un vuelo mediante su ID.</p>
    <pre><code>
    {
        "_id": "67b387105d15acb64c088a4a",
        "codigo": "UX950",
        "duracion": 81,
        "fecha_salida": "2025-05-21",
        "origen": "Ceuta",
        "destino": "Santa Cruz de Tenerife",
        "hora_salida": "19:46"
    }
    </code></pre>
    <h4>3.3 Crear un nuevo vuelo</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/vuelos/</p>
    <p><strong>Descripción:</strong> Crea un nuevo vuelo en la base de datos.</p>
    <pre><code>
    {
        "codigo": "FR5678",
        "duracion": 150,
        "fecha_salida": "2024-03-17",
        "origen": "Madrid",
        "destino": "París",
        "hora_salida": "14:20"
    }
    </code></pre>
    <h4>3.4 Actualizar un vuelo existente</h4>
    <p><strong>Método:</strong> PUT</p>
    <p><strong>URL:</strong> /api/vuelos/{id}</p>
    <p><strong>Descripción:</strong> Actualiza los detalles de un vuelo existente.</p>
    <pre><code>
    {
        "hora_salida": "15:30",
        "duracion": 160
    }
    </code></pre>
    <h4>3.5 Eliminar un vuelo</h4>
    <p><strong>Método:</strong> DELETE</p>
    <p><strong>URL:</strong> /api/vuelos/{id}</p>
    <p><strong>Descripción:</strong> Elimina un vuelo por su ID.</p>
    <pre><code>
    {
        "mensaje": "El vuelo ha sido borrado con éxito"
    }
    </code></pre>
    <h4>3.6 Filtrar por origen</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/vuelos/origen/{origen}</p>
    <p><strong>Descripción:</strong> Muestra todos los vuelos disponibles desde el origen especificado.</p>
    <pre><code>
    [
        {
          "_id": "67b387105d15acb64c088a14",
          "codigo": "FR384",
          "duracion": 83,
          "fecha_salida": "2025-04-03",
          "origen": "Malaga",
          "destino": "Toledo",
          "hora_salida": "07:36"
        },
        {
          "_id": "67b387105d15acb64c088a3a",
          "codigo": "VY180",
          "duracion": 138,
          "fecha_salida": "2025-12-17",
          "origen": "Malaga",
          "destino": "Zaragoza",
          "hora_salida": "05:14"
        },
        { ...
    ]
    </code></pre>
    <h4>3.7 Filtrar por destino</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/vuelos/destino/{destino}</p>
    <p><strong>Descripción:</strong> Muestra todos los vuelos disponibles hacia el destino especificado.</p>
    <pre><code>
    [
        {
          "_id": "67b387105d15acb64c088a30",
          "codigo": "FR115",
          "duracion": 152,
          "fecha_salida": "2026-01-10",
          "origen": "Logrono",
          "destino": "Sevilla",
          "hora_salida": "16:50"
        },
        {
          "_id": "67b387105d15acb64c088a36",
          "codigo": "IB554",
          "duracion": 81,
          "fecha_salida": "2025-07-13",
          "origen": "Vitoria",
          "destino": "Sevilla",
          "hora_salida": "01:02"
        },
        { ...
    ]
    </code></pre>
    <h4>3.8 Filtrar por duración</h4>
    <p><strong>Método:</strong> GET</p>
    <p><strong>URL:</strong> /api/vuelos/duracion/{duracionAfter}&{duracionBefore}</p>
    <p><strong>Descripción:</strong> Muestra todos los vuelos cuya duración esté dentro del intervalo especificado (en minutos).</p>
    <pre><code>
    [
        {
          "_id": "67b387105d15acb64c088a45",
          "codigo": "VY751",
          "duracion": 84,
          "fecha_salida": "2025-07-08",
          "origen": "Murcia",
          "destino": "Pamplona",
          "hora_salida": "19:08"
        },
        {
          "_id": "67b387105d15acb64c088a4a",
          "codigo": "UX950",
          "duracion": 81,
          "fecha_salida": "2025-05-21",
          "origen": "Ceuta",
          "destino": "Santa Cruz de Tenerife",
          "hora_salida": "19:46"
        },
        { ...
    ]
    </code></pre>
    <h4>3.9 Reservar un vuelo</h4>
    <p><strong>Método:</strong> POST</p>
    <p><strong>URL:</strong> /api/vuelos/reserva/{id}</p>
    <p><strong>Descripción:</strong> Realiza una reserva asignada a un usuario para un vuelo específico.</p>
    <pre><code>
    {
        "usuario": {
          "_id": "67b75cf05d15acb64c08abed",
          "nombre": "Sarita",
          "apellidos": "Martorell",
          "email": "sarita.martorell@yahoo.com",
          "telefono": "+34973 794 523"
        },
        "vuelo": {
          "_id": "67b387105d15acb64c088a3e",
          "codigo": "FR453",
          "duracion": 135,
          "fecha_salida": "2025-02-18",
          "origen": "Malaga",
          "destino": "Valencia",
          "hora_salida": "01:14"
        }
    }
    </code></pre>
</body>
</html>

