/**
* author @Jon 
* Data 2015-07-22 18:11:50
* �/������JS
* ʹ��ʾ��:
* 	function newActiviti(id , o){
		var str = $(o).attr("perssStr");
		activitiVAR = null;
		activitiVAR = new Activiti("activitiDIV","1000","box-body",str);
		activitiVAR.initialization();
	}
	����Ҫʹ�õİ�ť�ϵ��ü���
**/

/**
 * fatherID ����ID 
 * _with ��ȣ�����Ч��
 * _box_body ����
 * _title ����
 * _colorID  CSS��ɫ
 */
function Activiti( fatherID , _with , _box_body ,_title,_colorID){
	var _rowId="_"+randomString(16);
	if(_with > 100){
	}else{
		_with = 100;
	}
	if(_box_body == null ){
		_box_body = "";
	}
	if(_title == null){
		_title = "";
	}
	if(_colorID == null){
		_colorID = "";
	}
	this.htmls = '<div class="row _cctiviti_rowdiv_class" id="'+_rowId+'"  style="overflow:visible;">'+
	'<div  onclick="stopBubble(event);return 0;" style=" height: 100px">'+
	'<div class=" col-lg-2 "></div>'+
	'<div class=" col-lg-8 col-md-12">'+
	'<div class="box box-success box-solid" id="_activiti_activitiDIV" >'+
	'<div class="box-header with-border" id="'+_colorID+'">'+
	'<h3 class="box-title">'+_title+'</h3>'+
	'<div class="box-tools pull-right">'+
	'<button class="btn btn-box-tool" data-widget="remove" id="_activit_closeBtn'+_rowId+'">'+
	'<i class="fa fa-times"></i>'+
	'</button>'+
	'</div> <!-- 					/.box-tools -->'+
	'</div> <!-- 				/.box-header -->'+
	'<div class="box-body" id="_boxStr_id">'+_box_body+'</div> <!-- 				/.box-body -->'+
	'<!-- 				Loading (remove the following to stop the loading) -->'+
	'<div class="overlay" id="_activiti_overlay">'+
	'<i class="fa fa-refresh fa-spin"></i> </div> <!-- 				end loading --> </div>  <!-- 			/.box --> </div>'+
	'<div class=" col-lg-2 "></div> </div> </div>';
	
	this.boxStr = _box_body;
	
	
	this.fatherDIV = fatherID;
	this.loading = function(){
		$("#"+this.fatherDIV +" #_activiti_overlay").fadeOut("slow");
	}
	/**
	 * ��ʼ��
	 */
	this.initialization = function(){
		$("#"+fatherID).append(this.htmls);
		$("#"+fatherID).fadeIn("slow");
		window.setTimeout(function(){ 
			this.loaded; 
			},5000); 
		$("#_activit_closeBtn"+_rowId).click(this.close); 
	}
	
	/**
	 * ����_box_body����
	 */
	this.boxBodyinit = function(){
		$("#_boxStr_id").html(this.boxStr);
		this.loaded;
	}
	
	/**
	 * ������ɣ����״̬
	 */
	this.loaded = function(){
		$("#_activiti_overlay").fadeOut("slow");
	}
	
	/**
	 * ����
	 */
	this.destroy = function(){
		$("#"+fatherID).fadeOut("slow");
		window.setTimeout(function(){ 
			$("#"+fatherID).html("");
			},300); 
		
	}
	/**
	 * �ر�
	 */
	this.close=function(){
		$("#"+_rowId).fadeOut("slow");
		//alert($("#"+fatherID+" ._cctiviti_rowdiv_class").length);
		if($("#"+fatherID+" ._cctiviti_rowdiv_class").length <=1){
			activitiVARDestroy();
		}
	}
	
}


//**********************����հ״����ٸ���  Begin
var activitiVAR = null;
function activitiVARDestroy() {
	if(activitiVAR == null ){
		return ;
	}else{
		activitiVAR.destroy();
	}
}
$("#activitiDIV").click(activitiVARDestroy); 
//**********************����հ״����ٸ���  End

