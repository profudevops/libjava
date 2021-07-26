def call(String uversion = '$uversion', String ProjectName='$ProjectName') {
 echo "#########GENERERA JSON COMPLETO#########"
					 withCredentials([usernamePassword(credentialsId: 'CREDENCIALES_NEXUS-PROD', passwordVariable: 'PWD_NEXUS', usernameVariable: 'USER_NEXUS')]) {
						  response= sh ( script: " curl -u ${USER_NEXUS}:${PWD_NEXUS} -X GET "+
						  "http://172.22.50.14:8081/nexus/service/rest/v1/search/assets?repository=$NAMEREPO -H "+
						  "'accept: application/json' ", returnStdout: true)
						  props = readJSON text:  "$response"
						  def propstoken = props.continuationToken
						  props = props.items.path
						  writeFile file:'json1', text: "$props"
						  def count = 1
							  while("$propstoken" != "null"){
								       echo "####### ENTRA AL WHILE ########"
                response= sh ( script: ' curl -u ${USER_NEXUS}:${PWD_NEXUS} -X GET '+
                "'http://172.22.50.14:8081/nexus/service/rest/v1/search/assets?continuationToken="+
                "$propstoken"+"&repository=$NAMEREPO'"+" -H 'accept: application/json' ", returnStdout: true)
								        props = readJSON text:  "$response"
								        propstoken = props.continuationToken
								        echo "$propstoken"
								        count++;
								        echo "$count";
								        props = props.items.path
								        writeFile file: 'json'+"$count", text: "$props"
							  }
						  sh "cat json* > json"
					}
					
					echo "#########LIMPIA JSON COMPLETO#########"
					withCredentials([usernamePassword(credentialsId: 'CREDENCIALES_NEXUS-QA', passwordVariable: 'PWD_NEXUS', usernameVariable: 'USER_NEXUS')]) {
						sh label: "shell para limpiar json", script: "curl -X GET -u ${USER_NEXUS}:${PWD_NEXUS} "+
						"http://172.22.178.4:8081/nexus/repository/thirdparty/sh/limpiarjson/1.0/limpiarjson-1.0.sh -O"
						sh label:"ultima version", script: "sh limpiarjson-1.0.sh json $DIRECTORYNEXUS$ProjectName/temporal/"
						uversion = sh (script: 'cat UVERSION.txt', returnStdout: true )
						echo "valor actual: $uversion"
						if(uversion == "")
						{
						    echo "vacio el valor"
						    uversion = 0
						    uversion = uversion+1
						    echo "valor de esta construccion: $uversion"
						}else{
						    echo "si tiene valor"
						    uversion = uversion.toInteger()
						    uversion = uversion+1
						    echo "valor final: $uversion"
						}
					}
	return uversion;
}
