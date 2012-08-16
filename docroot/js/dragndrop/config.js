$(document).ready(
	function()
	{
		// Toggle Single jqportlet
		$('a.toggle').click(function()
			{
				$(this).parent('div').next('div').toggle();
				return false;
			}
		);

		// Invert All jqportlets
		$('a#all_invert').click(function()
			{
				$('div.jqportlet_content').toggle();
				return false;
			}
		);

		// Expand All jqportlets
		$('a#all_expand').click(function()
			{
				$('div.jqportlet_content:hidden').show();
				return false;
			}
		);

		// Collapse All jqportlets
		$('a#all_collapse').click(function()
			{
				$('div.jqportlet_content:visible').hide();
				return false;
			}
		);

		// Open All jqportlets
		$('a#all_open').click(function()
			{
				$('div.jqportlet:hidden').show();
				$('a#all_open:visible').hide();
				$('a#all_close:hidden').show();
				return false;
			}
		);

		// Close All jqportlets
		$('a#all_close').click(function()
			{
				$('div.jqportlet:visible').hide();
				$('a#all_close:visible').hide();
				$('a#all_open:hidden').show();
				return false;
			}
		);

		// Controls Drag + Drop
		$('#columns td').Sortable(
			{
				accept: 'jqportlet',
				helperclass: 'sort_placeholder',
				opacity: 0.7,
				tolerance: 'intersect'
			}
		);
	}
);