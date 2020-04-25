<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<Script>
	var jsAlertMsg = '${jsAlertMsg}';

	if (jsAlertMsg) {
		alert(jsAlertMsg)
	}	
</Script>