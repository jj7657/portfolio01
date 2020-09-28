window.onload = function() {
    document.querySelectorAll(".editorHTMLDIV")[0].style.display = "none";
    var form = document.querySelector('#form')
    form.addEventListener('submit', function(e) {
    	e.preventDefault();
    	var content = document.querySelectorAll(".editorDIV")[0].innerHTML
    	console.log(content) 
    	document.querySelector('#content').value=content
    	form.submit()
    })
}
//HTML코드로 보기
function convertToHTML() {
    console.log(document.querySelectorAll('.editorDIV')[0].innerHTML)
    document.querySelectorAll(".editorHTMLDIV")[0].textContent = document.querySelectorAll(".editorDIV")[0].innerHTML;
    document.querySelectorAll(".editorHTMLDIV")[0].style.display = "block";
    document.querySelectorAll(".editorDIV")[0].style.display = "none";
}
//에디터 화면으로 보기
function convertToEditor() {
    document.querySelectorAll(".editorHTMLDIV")[0].style.display = "none";
    document.querySelectorAll(".editorDIV")[0].style.display = "block";
}








