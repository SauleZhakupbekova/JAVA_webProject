function removeStudents() {

// JS внутри Idea не дебажится. Он дебажится только на браузере

//Код JS для доставания пришитых id студентов (value) у выделенных checkbox. Пришивание id мы сделали в student.jsp в части установки checkbox  <input name="idStudent" type="checkbox" value="${s.id}"> --%>
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked') //см.коммент свеоху. Либо могли бы написать [type=checkbox]

// Предупреждение о том, чтобы выделиле хотя бы одного студента
    if (checkedCheckboxs.length == 0) {
        alert("Please select at least one student");
        return;
    }

    // Собираем все id выделенных студентов
    var ids = ""; //двойные ковычки означают для программы, что это переменная класса String
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + " " // разделяем все найденные id студентов др от др  пробелом
    }

    // Находим скрытый ресурс в students.jsp и вставить туда найденные id студентов  <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove">
    document.getElementById("idsHiddenRemove").value = ids; //value = ids-взяты со строчки выше  ids = ids + checkedCheckboxs[i].value + " "; "idsHiddenRemove" - взят с фвйла student.jsp при создании ресурса <input type="hidden" name="idsHiddenRemove" id="idsHiddenRemove">

    //Находим скрытый ресурс в students.jsp и активируем кнопку submit
    document.getElementById("removeForm").submit(); //JS найди в students.jsp форму document.getElementById по имени ("removeForm") и для нее активируй кнопку submit(); "removeForm" взят с фвйла student.jsp при создании кнопки <form action="/student-remove" methode="post" id="removeForm">
}
    //как продебажить исполнения JS в браузере:
    //открываем консоль
    // выбираем sources
    // в консоле слева выбираем resources --> javascript
    // ставить курсор на строку, с которой зотим начать дебажить и нажимаем на кнопку Remove на вебстранице
    // справа на консоли есть кнопка глаза. На нее надо нажимать, чтобы отслеживать пошаговое выполнение

function modifyStudents() { //modifyStudents - это самопроизвольное название. ни откуда не берется и не имеет ссылок в последующем--%>
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked') //см.коммент свеоху. Либо могли бы написать [type=checkbox]

    if (checkedCheckboxs.length == 0) {
        alert("Please select at least one student");
        return;
        }

    if (checkedCheckboxs.length > 1) {
        alert("Please select ONLY one student");
        return;
        }

    var id = checkedCheckboxs[0].value

    document.getElementById("idHiddenModify").value = id;
    document.getElementById("modifyForm").submit();
    }

function removeDisciplines() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please select at least one discipline");
        return;
    }

    var ids = "";
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + " "
    }
    document.getElementById("idsHiddenRemove").value = ids;
    document.getElementById("removeForm").submit();
}

function modifyDiscipline() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please select at least one discipline");
        return;
    }

    if (checkedCheckboxs.length > 1) {
        alert("Please select ONLY one discipline");
        return;
    }

    var id = checkedCheckboxs[0].value

    document.getElementById("idHiddenModify").value = id;
    document.getElementById("modifyForm").submit();
}


