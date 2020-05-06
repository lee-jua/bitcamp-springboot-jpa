"use strict" 
var admin = admin || {}
admin = (() => {
	let user_vue
	const WHEN_ERROR = `호출하는 JS 파일을 읽지 못했습니다.`
	
	let init = () =>{
		user_vue = `/resources/vue/user_vue.js`
		onCreate()
	}
	let onCreate = () => {
		setContentView()
	$.when(
			$.getScript(user_vue) 
	).done(()=>{
		$.getJSON('/users', d => {
			$('#total_count').text('총 회원수 : ' + d.length)
			$.each(d, (i, j) => {
				$(`    
				        <tr>
                        	<td>
                                <span>${i+1}</span>
                            </td>
                            <td>
                                <span>${j.userid}</span>
                            </td>
                            <td>
                              <span id="user_`+(i+1)+`"></span>
                            </td>
                             <td>
                                <span>${j.ssn}</span>
                            </td>
                           <td>
                                <span>${j.email}</span>
                            </td>
                            <td>
                                <span>${j.phoneNumber}</span>
                            </td>
                            <td>
                                <span>${j.registerDate}</span>
                            </td>
                        </tr>`).appendTo('#userData')
                  $(`<a>${j.name}</a>`)
                  .css({cursor : 'pointer' , color : 'blue'})
                  .appendTo("#user_"+(i+1))
                  .click(e=>{
                	  $('#userData').empty()
                	  $(userVue.detail()).appendTo('#userData')
                	  $.getJSON(`/users/${j.userid}`,d=>{
                		  $('#userId').text(d.name)
                		  $('#userName').text(d.userid)
                		  $('#userSSN').text(d.ssn)
                		  $('#userAddr').text(d.addr)
                		  $('#userEmail').text(d.email)
                		  $('#userPhoneNumber').text(d.phoneNumber)
                		  $('#registerDate').text(d.registerDate)
                	  })
		      	})
			})
		})
	
		$('#admin_list').click(e=>{
			$("#userData").empty()
			$.getJSON('/admins', d => {
			$('#total_count').text('총 회원수 : ' + d.length)
		    $(` <tr><td><a>No.</a></td><td><a>직원번호</a></td><td><a>이름</a></td>
                           <td><a>직급</a></td><td><a>이메일</a></td><td><a>전화번호</a></td>
                           <td><a>등록일자</a></td></tr>`).appendTo('#userData')
                        	setContentView()
			$.each(d, (i,j) => {
				$(`<tr>
                    	<td>
                        <span>${i+1}</span>
                    </td>
                    <td>
                        <span>${j.employNumber}</span>
                    </td>
                    <td>
                      <span id="admin_`+(i+1)+`"></span>
                    </td>
                     <td>
                        <span>${j.position}</span>
                    </td>
                   <td>
                        <span>${j.email}</span>
                    </td>
                    <td>
                        <span>${j.phoneNumber}</span>
                    </td>
                    <td>
                        <span>${j.registerDate}</span>
                    </td>
                </tr>`).appendTo('#userData') //html은 오버라이딩 appendTo는 오버로딩(empty가 필요하다)
                $(`<a>${j.name}</a>`)
                .css({cursor : 'pointer', color : 'blue'})
                .appendTo("#admin_"+(i+1))
                .click(e=>{
                	alert(`${j.employNumber}`)
                })
			})
		})
			})
			
		$('#lost_item_list').click(e=>{
			$("#userData").empty()
				$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
			$.getJSON('/items', d => {
				$('#total_count').text('총 분실물 수 : ' + d.length)
		    $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
              $.each(d, (i,j) => {
              if (i<15) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
         
              $('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (15<=i && i<30) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
		  $('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (30<=i && i<45) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
				  $('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (45<=i && i<60) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
		  $('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (60<=i && i<75) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
		$('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (75<=i && i<90) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
			$('#next_page').click(e=>{
            		$("#userData").empty()
            		 	$(`<input type ="button" id ="next_page"/>`).appendTo('#userData').val(`다음페이지`)
            		 $(` <tr><td style="width: 3%"><a>No.</a></td><td style="width: 10%"><a>분실물 ID</a></td><td ><a>습득물품명</a></td>
                           <td  style="width: 10%"><a>습득일자</a></td><td  style="width: 10%"><a>습득물분류</a></td><td><a>습득위치</a></td>
                           `).appendTo('#userData')
                        	setContentView()
            		 $.each(d, (i,j) => {
              if (90<=i && i<105) {
            		$(`<tr>
                        	<td>
                            <span>${i+1}</span>
                        </td>
                        <td>
                            <span>${j.id}</span>
                        </td>
                        <td>
                          <span>${j.name}</span>
                        </td>
                         <td>
                            <span>${j.date}</span>
                        </td>
                       <td>
                            <span>${j.group}</span>
                        </td>
                        <td>
                            <span>${j.location}</span>
                        </td>
                       
                    </tr>`).appendTo('#userData') 
                    
			}
              })
		
			})
			})
			})
			})
			
			})
			})
		
		})
			})
	}).fail(()=>{
		
		alert(WHEN_ERROR)
	})
	
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()