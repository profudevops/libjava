def call(String jobNametmp = 'jobNametmp', String NAMESPACE = 'NAMESPACE', String LTCORREO = 'LTCORREO', String urlcomponente='urlcomponente', String Componente='Componente', String GITHUB_PR_SOURCE_BRANCH='GITHUB_PR_SOURCE_BRANCH') {
 
 echo "********************Enviado Correo***********************************"
                        emailext body: "Hola buen dia <br> Esta notificacion es para que nos puedan ayudar a validar el componente $Componente compilado desde el pipeline "+
				"$jobNametmp"+
				"<br> Les compartimos la ruta nexus asi como el usuario y contraseña para la validacion <br> url nexus: $urlcomponente <br><br> usuario:"+ 
                        	'<span style="background-color: #000000; color: #000000; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;"> Validacion_WPOS</span>' +
                        	"<br> contraseña:"+ '<span style="background-color: #000000; color: #000000; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;"> Profutur0</span>'+
                        	" <br><br>"+ 
				"Si el componente es correcto favor de darle click en el boton Componente correcto y se les entregara la ruta productiva,"+
				"en caso contrario dar click en el boton Componente incorrecto"
				"<table bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' style='margin: 0px; padding: 0px; width: 1000px; color: rgb(34, 34, 34); font-family: Helvetica, Arial, sans-serif; font-size: 12.8px; border-collapse: collapse; background-color: rgb(255, 255, 255);' width='100%'>"+
				"<td style='margin: 0px; font-family: arial, sans-serif;'>"+
					"<table border='0' cellpadding='0' cellspacing='0' style='font-family: Helvetica, Arial, sans-serif;' width='0'>"+
						"<tr>"+
						"<td style='margin: 0px; font-family: arial, sans-serif;'>"+
							"<table align='left' border='0' cellpadding='0' cellspacing='0'>"+
								"<tr>"+
								"<td align='center' background='https://tslp.s3.amazonaws.com/training/production/314/line-fd2085.png' bgcolor='#287bbc' height='30' style='background: url(&quot;https://tslp.s3.amazonaws.com/training/production/314/line-fd2085.png&quot;) repeat-x 50% 100% rgb(40, 123, 188); margin: 0px; border-radius: 3px; border: 1px solid rgb(27, 84, 128);' valign='middle'>"+
									"<table bgcolor='transparent' border='0' cellpadding='0' cellspacing='0' style='font-family: Helvetica, Arial, sans-serif;' width='100%'>"+
										"<td style='margin: 0px; font-family: arial, sans-serif;'>"+
										'<a href=\'http://aprobacion-git-admin.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com/inicio?jenkinsURL=https://jenkins-cicd-portal.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com&idAprobacion=Dev&intAutorizacion=3&job='+"$jobNametmp"+'&numero='+"${currentBuild.number}&carpeta=$
	SPACE"+'\' style=\'color: white; font-size: 13px; font-weight: bold; text-decoration: none; display: block; white-space: nowrap;\' target=\'_blank\'>'+
										"<span style='display: block;'>"+"&nbsp; Componente Correcto &nbsp;"+"</span>"+"</a>"+"</td>"+
										"</tr>"+
									"</table>"+
								"</td>"+
								"</tr>"+	
							"</table>"+
						"</td>"+
						"<!--TERMINA PRIMER TD PRIMER BOTON-->"+
						"<td style='margin: 0px; font-family: arial, sans-serif;' width='10'>"+
							"<table border='0' cellpadding='1' cellspacing='0' width='10'>"+
								"<tr>"+
								"<td style='margin: 0px;'>"+
									"<div style='line-height: 0px; font-size: 0px; min-height: 0px;'>"+"&nbsp;"+"</div>"+
								"</td>"+
								"</tr>"+				
							"</table>"+
						"</td>"+
						"<!--TERMINA SEGUNDO TD PARA ESPACION-->"+
						"<td style='margin: 0px; font-family: arial, sans-serif;'>"+
							"<table align='left' border='0' cellpadding='0' cellspacing='0'>"+
								"<tr>"+
								"<td align='center' background='https://tslp.s3.amazonaws.com/training/production/314/line-fd2085.png' bgcolor='#287bbc' height='30' style='background: url(&quot;https://tslp.s3.amazonaws.com/training/production/314/line-fd2085.png&quot;) repeat-x 50% 100% rgb(40, 123, 188); margin: 0px; border-radius: 3px; border: 1px solid rgb(27, 84, 128);' valign='middle'>"+
									"<table bgcolor='transparent' border='0' cellpadding='0' cellspacing='0' style='font-family: Helvetica, Arial, sans-serif;' width='100%'>"+
										"<td style='margin: 0px; font-family: arial, sans-serif;'>"+
										'<a href=\'http://aprobacion-git-admin.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com/inicio/abort?jenkinsURL=https://jenkins-cicd-portal.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com&idAprobacion=Dev&intAutorizacion=3&job='+"$jobNametmp"+'&numero='+"${currentBuild.number}&carpeta=$NAMESPACE"+'\' style=\'color: white; font-size: 13px; font-weight: bold; text-decoration: none; display: block; white-space: nowrap;\' target=\'_blank\'>'+
										"<span style='display: block;'>"+"&nbsp; Componente Incorrecto &nbsp;"+"</span>"+"</a>"+"</td>"+
										"</tr>"+
									"</table>"+
								"</td>"+
								"</tr>"+	
							"</table>"+
						"</td>"+

						"</tr>"+
					"</table>"+
					"</td>"+
					"</table>",
                        mimeType: 'text/html', 
                        from: 'ejedevopsprod@profuturo.com.mx', 
                        subject: 'Validacion del componente '+"$Componente"+' clave de proyecto '+"$GITHUB_PR_SOURCE_BRANCH", 
                        to: "$LTCORREO"
                        input id: 'Dev', message: 'Aprobación', ok: 'Promover'
                        echo "********************Termina Enviado Correo***********************************"
 }