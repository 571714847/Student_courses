function getDelete() {
    let ids = document.getElementsByName("account");
    if(document.form.selectAll.checked) {
        for(let i=0; i<ids.length; i++){
            ids[i].checked="checked";
        }
    } else {
        for(let i=0; i<ids.length; i++){
            ids[i].checked="";
        }
    }
    $("input:checked").each(function () {
        ids.push($(this.stuId).val());
    })
}