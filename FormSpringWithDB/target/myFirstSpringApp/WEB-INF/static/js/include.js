$(function() {
	$("#date").datepicker({
		format : 'mm-dd-yyyy'
	});
});

$(function() {
	$(document)
			.on(
					'click',
					'.btn-add',
					function(e) {
						e.preventDefault();

						var controlForm = $('.controls');
						// var currentEntry = $(this).parents('.entry:first');
						var entry = $('<div class="entry input-group col-md-6">'
								+ '<input class="form-control" id="fields" name="fields" path="fields" type="text" />'
								+ '<span class="input-group-btn">'
								+ '<button class="btn btn-remove btn-danger" type="button">'
								+ '<span class="glyphicon glyphicon-minus">'
								+ '</span>'
								+ '</button>'
								+ '</span>'
								+ '</div>');
						var text_value = $('#fields').val();
						entry.find(":input").val(text_value || "");
						var newEntry = entry.appendTo(controlForm);

					}).on('click', '.btn-remove', function(e) {
				$(this).parents('.entry:last').remove();

				e.preventDefault();
				return false;
			});
});

$('#create').click(function(e) {
	e.preventDefault();
	$.ajax({
		type : "POST",
		url : "saveWebGame",
		/* contentType : "application/json; charset=utf-8", */
		data : $('#newWebGameFo').serialize(),
		success : function(data) {
			window.location.href = "listGames"; // create butonuna bastiktan
			// sonra listGames sayfasına
			// yönlendirme yapar
		},
		error : function(request, status, error) {
			debugger;
			$.each(request.responseJSON, function(key, value) {
				$('#' + value.field + 'Err').text(value.defaultMessage);
			});
			//alert(request.responseText);
			console.log(status, error);
		},
		dataType : "json"
	});
});

$('#createPCGame').click(function(e) {
	e.preventDefault();
	$.ajax({
		type : "POST",
		url : "savePCGame",
		data : $('#newPCGameForm').serialize(),
		success : function(data) {
		},
		error : function(request, status, error) {
			console.log(status, error);
		},
		dataType : "json"
	});
});

$('#update').click(function(e) {
	e.preventDefault();
	$.ajax({
		type : "POST",
		url : "",
		data : $('#editGameForm').serialize(),
		success : function(data) {
			//alert("Update isleminiz basariyla tamamlanmistir.");
			document.location.href = $('#contextPath').val()+"listGames";  //update butonuna bastiktan sonra listGames sayfasına yonlendirme yapar
		},
		error : function(request, status, error) {
			console.log(status, error);
		},
		dataType : "json"
	});
});

$(document).on('click','.deleteGame',function(e) {
	e.preventDefault();
	$.ajax({
		type : "GET",
		url : $(this).attr('href'),
		success : function(data) {
			document.location.href = "listGames";
		},
		error : function(request, status, error) {
			console.log(status, error);
		}
	});
});

$("#gameList").hide();

$('#search').click(function(e) {
	e.preventDefault();
	$.ajax({
		type : "POST",
		url : "searchGames",
		data : $('#listGameForm').serialize(),
		dataType : "json",
		success : function(data) {
			//tabloyu silme islemini basa ekle
			$('#gameList').find('tbody').remove();
			
			var mainTable = $('#gameList');
			var body = $('<tbody></tbody>');
			
			data.forEach(function(e , i){
				
				var d = new Date(e.date);

				var curr_day = d.getDate();
				var curr_month = d.getMonth();
				var curr_year = d.getFullYear();

				curr_month++ ; // In js, first month is 0, not 1
				
				body.append('<tr></tr>');
				body.find('tr:last-child').append('<td>'+e.name+'</td>');
				body.find('tr:last-child').append('<td>'+curr_month+ "-" + curr_day + "-" + curr_year+'</td>');
				body.find('tr:last-child').append(
						'<td class="text-center">' + 
						'<a class="btn btn-primary" title="Edit" id="update" name="update" path="update" href="'+$('#contextPath').val()+'listGames/edit/'+e.id+'">'+
						'<i class="fa fa-pencil"></i> Edit' +
					    '</a>'+ 
					    '<a class="btn btn-danger deleteGame" title="Delete" href="'+$('#contextPath').val()+'listGames/delete/'+e.id+'">' + 
					    '<i class="fa fa-trash-o"></i> Delete' +
					    '</a>'+ 
					    '</td>');
			});
			body.appendTo(mainTable);
			//append main table
			$("#gameList").show();
		},
		error : function(request, status, error) {

			console.log(status, error);
		}
	});

});