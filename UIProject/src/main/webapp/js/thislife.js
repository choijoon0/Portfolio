/**
 * 
 */

 $(document).ready(function () {
     
        $('#main_navigation a').click(function () {
            
            var target = $(this).attr('data-target');

         
            $(':not([data-name=' + target + '])').removeClass('active');
            $('[data-name=' + target + ']').addClass('active');
        });
		
        var myVideo = $('video').get(0);
        
			$('#multimedia').on('mouseenter',function(){
				$(this).find('#play').show();
            });
            
			$('#multimedia').on('mouseleave',function(){
				$(this).find('#play').hide();
            });
            
			$('#play').on('click',function(){
				if($('#play').text() == 'play'){
					myVideo.play();
					$(this).text('pause');
				}else{
					myVideo.pause();	
					$(this).text('play');
				}
				$(this).hide();
			});

 
        var currentPosition = 1;
        $('#character > a:nth-child(1)').click(function () {
            currentPosition -= 1;
            if (currentPosition < 1) {
                currentPosition = 3;
            }
            $('article').removeClass('show');
            $('article:nth-of-type(' + currentPosition + ')').addClass('show');
        });
        
        $('#character > a:nth-child(2)').click(function () {
            currentPosition += 1;
            if (currentPosition > 3) {
                currentPosition = 1;
            }
            $('article').removeClass('show');
            $('article:nth-of-type(' + currentPosition + ')').addClass('show');
        });
		
		$(function(){
		var heart = $('#heart');
		heart.hover(function() {
			heart.html("<i class='fa-solid fa-heart fa-beat fa-2x' style='color: #d32727;'>4.0</i>");
		}, function(){
			heart.html("<i class='fa-solid fa-heart fa-2x' style='color: white;'>4.0</i>");
		});
		
	}); 
    });
    
     	
    

    