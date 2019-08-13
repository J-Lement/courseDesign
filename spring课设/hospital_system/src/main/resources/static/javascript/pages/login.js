$(function(){
	$('#entry').click(function(){
		if($('#adminName').val()==''){
			$('.mask,.dialog').show();
			$('.dialog .dialog-bd p').html('请输入用户账号');
		}else if($('#adminPwd').val()==''){
			$('.mask,.dialog').show();
			$('.dialog .dialog-bd p').html('请输入用户密码');
		}else{
			$('.mask,.dialog').hide();
			$('#loginform').submit();
		}
	});
});
