window.onload = function () {
    const editLinks = document.querySelectorAll('.edit');

    for(const link of editLinks) {
        link.onclick = editRecord;
    }

    const deleteLinks = document.querySelectorAll('.delete');

    for(const link of deleteLinks) {
        link.onclick = deleteRecord;
    }
}

function editRecord(evt) {
    console.log(evt.target)

    const editLink = evt.target;
    const row = editLink.parentElement.parentElement;
    const cells = row.children;
    const id = cells[0].innerHTML;
    console.log(`Editing Id: ${id}`);

    const species = cells[2].innerHTML;
    console.log(`Editing Species ${species}`);

    cells[2].innerHTML = `<input type = "text" id="species" value="${species}">`;

    const color = cells[4].innerHTML;
    cells[4].innerHTML = `<input type = "text" id="color" value="${color}">`;

}

function deleteRecord(evt) {
    const deleteLink = evt.target;

    const row = deleteLink.parentElement.parentElement;
    const cells = row.children;
    const id = cells[0].innerHTML;

    row.remove();
}