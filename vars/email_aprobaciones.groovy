def call(String jobNametmp = 'jobNametmp', String NAMESPACE = 'NAMESPACE', String LTCORREO = 'LTCORREO') {
 
 echo "********************Enviado Correo***********************************"
                        emailext body: 'hola'+
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
					'<a href=\'http://aprobacion-git-admin.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com/inicio?jenkinsURL=https://jenkins-cicd-portal.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com&idAprobacion=Dev&intAutorizacion=3&job='+"$jobNametmp"+'&numero='+"${currentBuild.number}&carpeta=$NAMESPACE"+'\' style=\'color: white; font-size: 13px; font-weight: bold; text-decoration: none; display: block; white-space: nowrap;\' target=\'_blank\'>'+
					"<span style='display: block;'>"+"&nbsp; Promover &nbsp;"+"</span>"+"</a>"+"</td>"+
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
					'<a href=\'http://aprobacion-git-admin.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com/inicio/abort?jenkinsURL=https://jenkins-cicd-portal.apps.paasprofuturo-d.r6b1.p1.openshiftapps.com&idAprobacion=Dev&intAutorizacion=3&job='+"$jobNametmp"+'&numero='+"${currentBuild.number}&carpeta=NAMESPACE"+'\' style=\'color: white; font-size: 13px; font-weight: bold; text-decoration: none; display: block; white-space: nowrap;\' target=\'_blank\'>'+
					"<span style='display: block;'>"+"&nbsp; Abortar &nbsp;"+"</span>"+"</a>"+"</td>"+
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
                        subject: 'Aprobado o Cancelacion del pipeline '+"$jobNametmp"+' clave de proyecto ', 
                        to: "$LTCORREO"
                        input id: 'Dev', message: 'Aprobación', ok: 'Promover'
                        echo "********************Termina Enviado Correo***********************************"
 }
