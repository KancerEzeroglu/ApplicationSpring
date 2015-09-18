$(function() {
	$("#datepickerDate").datepicker({
		format : 'mm-dd-yyyy'
	});
});
$(document).ready(function() {
	$("#gameList").hide();
	$("#search").click(function() {
		$("#gameList").show();
		return false;
	});

});
$(function()
		{
		    $(document).on('click', '.btn-add', function(e)
		    {
		        e.preventDefault();

		        var controlForm = $('.controls');
		       // var currentEntry = $(this).parents('.entry:first');
		        var entry = $('<div class="entry input-group col-md-6">' +
											'<input class="form-control" id="fields" name="fields" path="fields" type="text" />' +
												'<span class="input-group-btn">' +
												'<button class="btn btn-remove btn-danger" type="button">' +
													'<span class="glyphicon glyphicon-minus">' + '</span>' +
												'</button>' +
											'</span>' +
										'</div>');
		        var text_value = $('#fields').val();
		        entry.find(":input").val(text_value || "");
		        var newEntry = entry.appendTo(controlForm);

		    }).on('click', '.btn-remove', function(e)
		    {
				$(this).parents('.entry:last').remove();

				e.preventDefault();
				return false;
			});
		});


$('#create').click(function(e){
	e.preventDefault();
	$.ajax({
		  type: "POST",
		  url: "saveWebGame",
		  /*contentType : "application/json; charset=utf-8",*/
		  data: $('#newWebGameFo').serialize(),
		  success: function(data) {
				alert('Well Done!!!!');
			},
			error: function (request, status, error) {
		        alert(request.responseText);
		        console.log(status,error);
		    },
		  dataType: "json"
		});
});

$('#createPCGame').click(function(e){
	e.preventDefault();
	$.ajax({
		  type: "POST",
		  url: "savePCGame",
		  /*contentType : "application/json; charset=utf-8",*/
		  data: $('#newPCGameForm').serialize(),
		  success: function(data) {
				alert('Well Done!!!!');
			},
			error: function (request, status, error) {
		        alert(request.responseText);
		        console.log(status,error);
		    },
		  dataType: "json"
		});
});
