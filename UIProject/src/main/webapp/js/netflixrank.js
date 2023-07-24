$(document).ready(function(){
	
	//페이지 로딩 시 제일 상단이동
	$("body,html").stop().animate({"scrollTop":0},1500,"swing");	

	$(window).scroll(function(){
		
		//현재 화면을 스크롤 거리의 수치
		var scroll = $(this).scrollTop();		
					
		for(var i=0; i<5; i++){
			//스크롤값과 박스의 z축 연동	
			$("section>article").eq(i).css({"transform":"translateZ("   + ((-5000*i)+scroll) +  "px)"});	
			//특정 스크롤 구간에서 스크롤 네비게이션과 박스 활성화
			if(scroll>=i*5000&&scroll<(i+1)*5000){
				$(".scrollNavi li").removeClass();
				$(".scrollNavi li").eq(i).addClass("on");
				$("article").removeClass();				
				$("article").eq(i).addClass("on");
			};
		};	
		
	});
	
	
	//스크롤 네비게이션 클릭 시 스크롤 이동
	$(".scrollNavi li").on("click",function(){
		var a = $(this).index();	
		$("body,html").stop().animate({"scrollTop":5000*a},1500,"swing");		
	});		
	
	$("body").on("mousemove",function(e){
		var posX = e.pageX/100;
		var posY = e.pageY/150;		
		
		//이미지의 기존 좌표값에서 마우스의 좌표값을 빼거나 더함
		$(".obj11").css({"left":-270-posX , "bottom":-100-posY });
		$(".obj12").css({"right":-593+posX , "top":-85+posY });
		$(".obj13").css({"left":-100+posX , "bottom":20+posY });
		
		$(".obj21").css({"right":-710-posX , "bottom":-420-posY });
		$(".obj22").css({"right":-50+posX , "bottom":-100+posY });
		
		$(".obj31").css({"right":230-posX , "bottom":70-posY });
		$(".obj32").css({"left":100-posX , "bottom":-160+posY });
		
		$(".obj41").css({"left":100+posX , "bottom":-10-posY });
		$(".obj42").css({"right":50+posX , "top":-255-posY });
		$(".obj43").css({"right":-100+posX , "bottom":-120+posY });
		
		$(".obj51").css({"left":-35-posX , "bottom":-270-posY });
		$(".obj52").css({"right":30+posX , "top":170-posY });
		$(".obj53").css({"left":-30+posX , "bottom":0-posY });		
	});
	

});















