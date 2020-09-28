$(document).ready(function() {
	// teatarea 자동 높이 조절

	var textarea= $("#comment_inbox_text");
	textarea.on("input", function() {
		textarea.css('height','auto')
		height = (textarea.prop('scrollHeight'))+'px';
		textarea.css('height',height)
	})
	
	// 댓글 기본값
	var bno = $("#commentList").attr('date')
	console.log(bno);
	var page = 1;
	getReplyList(page)
	// 댓글 불러오기
	function getReplyList(page) {
		$.getJSON("/web/reply/read/"+bno+"/"+page ,function(data){
			console.log(data);
			var reply = "";
			var replypage = "";
			$(data.reply).each(function() {
				reply += "<li data-rno='"
					+ this.rno
					+ "'class='replyLi'><div><div class='commentImg'><img src='../../resources/img/cafe_profile.png' alt=''></div><div class='commentItem'><div>"
					+ this.replyer
					+"</div><p>"
					+ this.replytext
					+"</p><span>"
					+ this.updatedate
					+ "</span></div></div><div class='commentTool'><a><i class='fas fa-ellipsis-v'></i></a></div></li>";
				$("#commentList>ul").html(reply);
			})
			var pageMaker = data.pageMaker;
			if(pageMaker.prev){
				replypage+="<li class='commentpage-item'><a class='fas fa-angle-double-left' href='"+(pageMaker.startpage-1)+"'></a></li> ";
			}
			for (var i = pageMaker.startpage; i <= pageMaker.endpage; i++) {
				var active=page==i?"active":"";
				
				replypage+="<li class='commentpage-item "+active+"'><a href='"+i+"'>"+i+"</a></li> ";
			}
			if(pageMaker.next){
				replypage+="<li class='commentpage-item'><a class='fas fa-angle-double-right' href='"+(pageMaker.endpage+1)+"'></a></li> ";
			}
			$("#commentPage>ul").html(replypage);
			$(".fa-comment-dots").parent().children("span").text("댓글("+pageMaker.total+")")
		})
	}
	$("#commentPage").on("click","a",function(e){
		e.preventDefault();
		var page= $(this).attr('href')
		getReplyList(page);
	})
	
	// 댓글등록
	$("#register_box").click(function() {
		var replyer = $("#comment_inbox_name").text();
		var replytext = $("#comment_inbox_text").val();
		console.log(replyer+" / "+replytext)
		$.ajax({
			type : "post",
			url : "/web/reply/create/"+bno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Overried" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				bno : bno,
				replytext : replytext,
			}),
			success : function(result) {
				if (result == "success") {
					alert("등록성공");
					getReplyList(page);
				}else{
					alert(result);
				}
			},
			error : function(err) {
				console.log(err)
			}
		})
	})
	
	//좋아요
	$("#replyBox_left>a:nth-child(1)").click(function() {
		$.ajax({
			type : "post",
			url : "/web/board/like/"+bno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Overried" : "POST"
			},
			dataType : "text",
			success : function(data) {
				$("#replyBox_left>a:nth-child(1)>i").attr('class','fas fa-heart')
				$("#replyBox_left>a:nth-child(1)>span").text("좋아요("+data+")")
			},
			error : function(err) {
				console.log(err)
			}
		})
	})
	
	//url복사 기능
	$("#readTool>a:nth-child(2)").click(function(e) {
		e.preventDefault();
		var url=document.URL;
		var tempElem = document.createElement('textarea');
		tempElem.value = url;  
		document.body.appendChild(tempElem);
		tempElem.select();
		document.execCommand("copy");
		document.body.removeChild(tempElem);
		alert('URL 이 복사 되었습니다')
	})
	//수정버튼 추가
	var createMenu=0;
	$(document).on("click",".commentTool>a",function() {
		var rno = $(this).parent().parent().attr('data-rno');
		console.log("수정버튼 추가"+rno)
		var tool = "";
		
		if(createMenu==0){
		tool="<div class='commentModify'><ul><li><a href='#'>수정</a></li></ul></div>"
		$(this).append(tool);
		$(".commentModify").attr("tabindex", -1);
		$(".commentModify").attr("data-rno", rno);
		createMenu=1;
		}
	})
	$(document).on("blur", ".commentTool", function() {
		console.log("blur")
		if(createMenu==1){
			createMenu=0;
			$(".commentModify").remove();			
		}
	})
	$(document).on("click",".commentModify",function(){
		var rno = $(this).attr('data-rno')
		$("[data-rno='"+rno+"']")
	})
	
	//댓글 입력 글자수 제한
	$(document).on("input","#comment_inbox_text",function(){
		var length = $(this).val().length;		
		$("#inbox_count").text(length)
	    if (length > 300){
	        alert("최대 300자까지 입력 가능합니다.");
	        $(this).val($(this).val().substring(0, 300));
	        $("#inbox_count").text('300')
	    }
	})
	
})