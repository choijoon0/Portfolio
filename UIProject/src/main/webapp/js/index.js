/**
 * 
 */

$(function() {
	$('.carousel').carousel({
		interval: 4000
	});

	$('#btn').on('click', function(e) {

		e.preventDefault();
		if ($('#search').val() === '이번 생도 잘부탁해') {
			location.href = "view/thislife.html";
		}
	});
	

	function autocomplete(inp, arr) {

  var currentFocus;

  inp.addEventListener("input", function(e) {
      var a, b, i, val = this.value;
     
      closeAllLists();
      if (!val) { return false;}
      currentFocus = -1;
      
      a = document.createElement("DIV");
      a.setAttribute("id", this.id + "autocomplete-list");
      a.setAttribute("class", "autocomplete-items");
    
      this.parentNode.appendChild(a);
     
      for (i = 0; i < arr.length; i++) {
       
        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
        
          b = document.createElement("DIV");
          
          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
          b.innerHTML += arr[i].substr(val.length);
       
          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
  
          b.addEventListener("click", function(e) {
            
              inp.value = this.getElementsByTagName("input")[0].value;

              closeAllLists();
          });
          a.appendChild(b);
        }
      }
  });
 
  inp.addEventListener("keydown", function(e) {
      var x = document.getElementById(this.id + "autocomplete-list");
      if (x) x = x.getElementsByTagName("div");
      if (e.keyCode == 40) {
  
        currentFocus++;
       
        addActive(x);
      } else if (e.keyCode == 38) { //up
       
        currentFocus--;
        
        addActive(x);
      } else if (e.keyCode == 13) {
       
        e.preventDefault();
        $('#btn').click();
        if (currentFocus > -1) {
        
          if (x) x[currentFocus].click();
        }
      }
  });
  function addActive(x) {
   
    if (!x) return false;
  
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = (x.length - 1);
    
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
  
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
   
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
 
  document.addEventListener("click", function (e) {
      closeAllLists(e.target);
  });
}


var srch = ["이번 생도 잘부탁해", "오징어 게임", "지옥", "하트시그널", "하트시그널2","하트시그널3","하트시그널4","마당이 있는 집","링크","간니발","아바타","아바타2","원피스 1기","원피스 2기","슬램덩크","언내추럴","헤어질 결심","피의 게임","남의 연애","약한영웅","상견니","교섭","늑대사냥","더 킬러 : 죽여도 되는 아이","야차","익스트랜션","익스트랜션2","노바디","바스터즈","시카리오","악인전","유체이탈자","콘스탄틴","곤지암","랑종","런","미드소마","엄마","비바리움","유전","인비테이션","제 8일의 밤","주","주토피아","콜","클로젯","걸캅스","내안의 그놈","럭키","미니언즈","아라한 장풍대작전","어쩌다 로맨스","정직한 후보","청년 경찰","19곰 테드","해치지 않아","트루먼 쇼","히트맨","귀멸의 칼날 : 도공마을편","나의 히어로 아카데미","날씨의 아이","너의 이름은","도로헤도로","목소리의 형태","센과 치히로의 행방불명","원펀맨","진격의 거인","하울의 움직이는 성","하이큐","스파이패밀리"];


autocomplete(document.getElementById("search"), srch);
	
});

