"use strict" //문법 엄격하게 적용
var user = user || {} //user가 있으면 쓰고 없으면 새로 만들어라 namespace에 json을 담았다 json이 되었다 json 구조를 갖게 된다 프론트앤드단에서 global로 선언된다(json은 js에서만 있는데 namespace로 선언되면 프론트단에서의 객체이다)
user = (()=> {
		let init = () => {//맨처음 실행되는 메소드
			 onCreate()
		}//변할 수 있는 값 M m = null;
		let onCreate = () => {//on 만들어지자 마자 java에 가서 어떤 일을 한다 ajax가 걸린다 ***기능***
			setContentView() //그림을 먼저 그린다
			$('#register_a').click(e=>{
				e.preventDefault()
				location.href="/admin"
			}) 
			
		} 
		let setContentView = () =>{ //갖고와서 그림을 그린다??? ***속성***
			 $('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
		        $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
		        $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
		        $('#kcdc td').addClass('border_black', 'width_full')
		} 
		return {init} //to html as json 초기화시킨 함수만 노출시키고 나머지는 감춘다 클로즈
})()  //즉시실행 이벤트가 없기 때문에 e.preventDefault 가 필요없다

//즉시실행함수 IIFE 패턴
