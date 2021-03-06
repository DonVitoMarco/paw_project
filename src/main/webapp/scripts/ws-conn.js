var ws = new WebSocket('ws://localhost:8081/exchange_websocket/websocket');

ws.onopen = function (msg) {
    ws.send('sync_msg')
};

ws.onmessage = function (msg) {
    var data = JSON.parse(msg.data);
    var date = new Date(data.time);

    var mainElement = document.getElementById("main-content");
    mainElement.firstElementChild.innerHTML = "Server time: " + date.toLocaleString();

    var tableElement = document.getElementById("table-content");
    tableElement.innerHTML = '';
    tableElement.appendChild(createTable(data.companies));
};

function createTable(companies) {
    var table = document.createElement('table');

    table.appendChild(createHeader());
    for (var i = 0; i < companies.length; i++) {
        table.appendChild(createRow(companies[i]));
    }

    return table;
}

function createHeader() {
    var head = ['CODE', 'FULLNAME', 'CHANGE', 'PRICE'];
    var headRow = document.createElement('tr');

    for(var i = 0; i < head.length; i++) {
        var elementCode = document.createElement('td');
        elementCode.innerHTML = head[i];
        headRow.appendChild(elementCode);
    }

    return headRow;
}

function createRow(company) {
    var row = document.createElement('tr');

    var code = document.createElement('td');
    code.innerHTML = company.code;

    var fullname = document.createElement('td');
    fullname.innerHTML = company.fullName;

    var change = document.createElement('td');
    createChangeCell(change, company.changeToUp);

    var price = document.createElement('td');
    price.innerHTML = company.price;

    row.appendChild(code);
    row.appendChild(fullname);
    row.appendChild(change);
    row.appendChild(price);

    return row;
}

function createCell() {
    var cell = document.createElement('td');
}

function createChangeCell(element, value) {
    if (value === 1) {
        element.innerHTML = '<i class="fa fa-caret-up green" aria-hidden="true"></i>';
    } else if (value === -1) {
        element.innerHTML = '<i class="fa fa-caret-down red" aria-hidden="true"></i>';
    } else if (value === 0) {
        element.innerHTML = '<i class="fa fa-minus" aria-hidden="true"></i>';
    }
}
