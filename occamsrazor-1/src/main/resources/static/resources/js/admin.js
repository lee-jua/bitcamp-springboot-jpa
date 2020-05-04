"use strict" 
var admin = admin || {}
admin = (() => {
	let init = () =>{
		onCreate()
	}
	let onCreate = () => {
		setContentView()
		$.getJSON('/users', d => {
			$.each(d, (i, j) => {
				$(`<tr>
                        	<td>
                                <span>${i+1}</span>
                            </td>
                            <td>
                                <span>${j.userid}</span>
                            </td>
                            <td>
                                <span>${j.name}</span>
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
			})
		})
	}
	let setContentView = () => {
		$('#userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()