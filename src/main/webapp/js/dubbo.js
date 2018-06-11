


   /* 加载数据*/
	loadData = function(port, port_method, isAsync,data, successFunc) {
		var url =("./") + port; 
		$.ajax({
			url: url,
			type: 'POST',
			timeout: 60000,
			async: isAsync,
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			data: data,
			success: function(data){
				//var resdata = data.data, rescode = data.meta.success , message = data.meta.message;
				//alert(message+"----"+resdata);
				successFunc(data);
			},
			error:function(data){
				alert(data.responseJSON.meta.message);
			},
			beforeSend: function(){
		      
		   },
		   complete: function(){
			  
		   }
		});
	};


function loadUser() {
	
    var data = {
    		name: "",
    		account: ""
	};
    
    var dataJson = JSON.stringify(data);
    
    var port = "searchUserDubbo";
    
    var successFunc = function(data) {
    	if(!data.meta.success)
    	{
    		return;
    	}
		
		$("#tbody").empty();
		var dataList = data.data;
		for (var i = 0; i < dataList.length; i++) 
		{
			var html = '<tr data-id="' + dataList[i].id + '">'
					+ '<td>' + dataList[i].id + '</td>'
					+ '<td>' + dataList[i].name + '</td>'
					+ '<td>' + dataList[i].account + '</td>'
					+ '</tr>'
				
			$("#tbody").append(html);
		}
		
	};
    
    loadData(port, null, true, dataJson, successFunc);
};

$(document).ready(function(){
	loadUser();
});

