"use strict" 
var admin = admin || {}
admin = (() => {
	let init = () =>{
		onCreate()
	}
	let onCreate = () => {
		setContentView()
		   $('#admin_register').click(e=>{
    	 e.preventDefault()
    	 $.ajax({
    		 url:'/admins',
    		 type:'post',
    		 data:JSON.stringify({
    			 name : $('#name').val(),
    			 position : $('#position').val(),
    			 email : $('#email').val(),
    			 phoneNumber : $('#phoneNumber').val()
    		 }),
    		 dataType:'json',
    		 contentType:'application/json',
    		 success:d=>{
    			 if (d ==='SUCCESS') {
					location.href = "../index.html"
				}else{
					alert('실패')
				}
    		 },
    		 error:(r,x,e)=>{alert(r.status)}
    	 })
     })
	}
	let setContentView = () => {
	    $('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
	     $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#kcdc td').addClass('border_black', 'width_full')
	     $('#register_a').css({color: 'skyblue', cursor : 'none', 'text-decoration': 'none'})
	}
	return {init}
})()