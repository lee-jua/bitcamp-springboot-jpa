"use strict" 
var admin = admin || {}
admin = (() => {
	let init = () =>{
		onCreate()
	}
	let onCreate = () => {
		setContentView()
	
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
                	  alert(`${j.userid}`)
		      	})
			})
		})
	
		$('#admin_list').click(e=>{
			$("#userData").empty()
				
			$.getJSON('/admins', d => {
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
                </tr>`).appendTo('#userData')
                $(`<a>${j.name}</a>`)
                .css({cursor : 'pointer', color : 'blue'})
                .appendTo("#admin_"+(i+1))
                .click(e=>{
                	alert(`${j.employNumber}`)
                })
			})
		})
			})
		
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()