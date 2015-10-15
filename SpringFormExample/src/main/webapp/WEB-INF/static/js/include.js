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
											'<input class="form-control" name="fields[]" type="text" />' +
												'<span class="input-group-btn">' +
												'<button class="btn btn-remove btn-danger" type="button">' +
													'<span class="glyphicon glyphicon-minus">' + '</span>' +
												'</button>' +
											'</span>' +
										'</div>');
		        var text_value = $('#screenshot').val();
		        entry.find(":input").val(text_value || "");
		        var newEntry = entry.appendTo(controlForm);

		        /*newEntry.find('input').val('');
		        controlForm.find('.entry:not(:last) .btn-add')
		            .removeClass('btn-add').addClass('btn-remove')
		            .removeClass('btn-success').addClass('btn-danger')
		            .html('<span class="glyphicon glyphicon-minus"></span>');*/
		    }).on('click', '.btn-remove', function(e)
		    {
				$(this).parents('.entry:last').remove();

				e.preventDefault();
				return false;
			});
		});