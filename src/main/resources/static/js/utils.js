var base = window.location.protocol + "//" + window.location.host;

function alert(msg) {
    bootbox.alert(msg);
}

function areYouSure(onYes, onNo) {
    bootbox.confirm({
        message: "Czy jestes pewny?",
        buttons: {
            confirm: {
                label: 'Tak',
                className: 'btn-success'
            },
            cancel: {
                label: 'Nie',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result == true) {
                onYes();
            }
            else if (onNo) {
                onNo();
            }
        }
    });
}

function defaultOnSuccess() {
    alert("Poszlo zgodnie z planem.");
}

function defaultOnFailure() {
    alert("Cos nie tak. Sprobuj ponownie, lub poinformuj swojego ukochanego Zawiszka");
}

function handleFormAsync(form, onSuccess, onFailure) {
    var jqueryForm = $(form);
    jqueryForm.submit(function (event) {
        event.preventDefault();
        var ourForm = $(this);
        var target = ourForm.attr('target');
        var action = ourForm.data('actionType');
        var shouldConfirm = ourForm.data('shouldConfirm');

        function send() {
            var emptyStringsAndZerosToNulls = function(val, inputName) {
                if (val === "") return null; // parse empty strings as nulls
                if (val === 0)  return null; // parse 0 as null
                return val;
            };

            var formData = ourForm.serializeJSON({
                checkboxUncheckedValue: "false",
                parseBooleans: true,
                parseNumbers: true,
                parseWithFunction: emptyStringsAndZerosToNulls
            });

            $.ajax({
                type: action,
                url: base + target,
                contentType: "application/json",
                success: onSuccess ? onSuccess : defaultOnSuccess,
                failure: onFailure ? onFailure : defaultOnFailure,
                data: JSON.stringify(formData),
                form: ourForm
            });
        }

        if (shouldConfirm == true) {
            areYouSure(send());
        } else {
            send();
        }
    });
}

function deleteBean(target, id, onSuccess, onFailure) {
    $.ajax({
        type: "DELETE",
        url: base + target + '/' + id,
        contentType: "application/json",
        success: onSuccess ? onSuccess : defaultOnSuccess,
        failure: onFailure ? onFailure : defaultOnFailure,
    });
}

var polishDataTables =

    {
        "processing": "Przetwarzanie...",
        "search": "Szukaj:",
        "lengthMenu": "Pokaż _MENU_ pozycji",
        "info": "Pozycje od _START_ do _END_ z _TOTAL_ łącznie",
        "infoEmpty": "Pozycji 0 z 0 dostępnych",
        "infoFiltered": "(filtrowanie spośród _MAX_ dostępnych pozycji)",
        "infoPostFix": "",
        "loadingRecords": "Wczytywanie...",
        "zeroRecords": "Nie znaleziono pasujących pozycji",
        "emptyTable": "Brak danych",
        "paginate": {
            "first": "Pierwsza",
            "previous": "Poprzednia",
            "next": "Następna",
            "last": "Ostatnia"
        },
        "aria": {
            "sortAscending": ": aktywuj, by posortować kolumnę rosnąco",
            "sortDescending": ": aktywuj, by posortować kolumnę malejąco"
        }
    };
