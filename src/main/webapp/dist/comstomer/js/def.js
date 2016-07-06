/**
 * md5加密工具
 */

function MD_kl(inStr){
	var charArray = inStr.split(""); 
	var value = 9;
	var index = 9099;
	for(var i = 0; i < charArray.length;i++){
		charArray[i] =String.fromCharCode( charArray[i].charCodeAt(0) ^ 'g'.charCodeAt(0));
	}
	return charArray.join("");
	
}

/**
 * 禁页面
 */
function desablePage(){
	$("#desablePageDIV").fadeIn();
}

/**
 * 启用页面
 */
function enablePage(){
	$("#desablePageDIV").fadeOut();
}



