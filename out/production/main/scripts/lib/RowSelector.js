var RowSelector = (function (){

	function bindEvents() {
		$("body").click(clickHandler);
	}
	
	function unbindEvents() {
		$("body").unbind("click", clickHandler);
	}
	
	function clickHandler(event) {
		var target = $(event.target);
		if (target.hasClass('rowSelector')) {
			toggleRow(target);
		} else if (target.hasClass('toggleAll')) {
			toggleAll(target);
		}
	}

	function toggleRow(checkbox) {
        var checked = $(checkbox).is(":checked");
        var inputs = $(checkbox).parents("tr").find(":input:not(.rowSelector)");
        $(inputs).each(function (i, input) {
            if (checked) {
                $(input).removeAttr("disabled");
            } else {
                $(input).attr("disabled", "disabled");
            }
        });
	}
	
	function toggleAll(checkbox) {
        $(":checkbox:not(.toggleAll)").click()
	}
	
	return {
		bindEvents: bindEvents,
		unbindEvents: unbindEvents
	};

}());
