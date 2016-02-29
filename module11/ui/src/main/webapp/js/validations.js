function checkLength(len_max, field_id) {
	var len_current = document.getElementById(field_id).value.length;
	var rest = len_max - len_current;
	if (len_current > len_max) {
		document.getElementById(field_id).value = document
				.getElementById(field_id).value.substr(0, len_max);
		if (rest < 0) {
			rest = 0;
		}

		alert(msg.length.quantityerror + ' ' + len_max)
	}

}

function countSymbols(len_max, field_id, counter_id) {
	var len_current = document.getElementById(field_id).value.length;
	document.getElementById(counter_id).firstChild.data = len_current + ' / '
			+ len_max;
}

function requireCheckboxes() {
	checkboxes = document.getElementsByName('selectedItems');
	for (var i = 0, n = checkboxes.length; i < n; i++) {
		if (checkboxes[i].checked == true) {
			return sureDelete();
		}
	}
	alert(msg.length.noselected);
	return false;
}

function checkEmptyAreas() {
	var txt001 = document.getElementById('Txt001');
	var txtA001 = document.getElementById('TxtA001');
	var txtA002 = document.getElementById('TxtA002');
	var lang = document.getElementsByTagName('html')[0].lang;
	var date = document.getElementById('Txt003').value;
	var message = validateDate(date, lang);
	var result = true;
	if (message != 0) {
		result = false;
	}
	var textmessage = validateText(txtA001, txtA002, txt001);
	if (textmessage != 0) {
		message = message + textmessage + '\n';
		result = false;
	}
	if (result == false) {
		alert(message);
	} else {
		if (lang == 'ru') {
			var splitted = date.split('/');
			var day = splitted[0];
			var month = splitted[1];
			var year = splitted[2];
			var endDate = month + '/' + day + '/' + year;
			document.getElementById('Txt003').value = endDate;
		}
	}
	return result;

}

function validateDate(date, lang) {
	var commonPattern = /^([0-9]{2}\/[0-9]{2}\/[0-9]{4})$/;
	var dayPattern = /^(0[1-9]|[12]\d|3[01])$/;
	var monthPattern = /^(0[1-9]|1[0-2])$/;
	var yearPattern = /^((([1]{1}[9]{1})|([2]{1}[0]{1}))[0-9]{2})$/;
	var splitted = date.split('/');
	var message = '';
	var day;
	var month;
	var year = splitted[2];

	if (commonPattern.test(date)) {
		if (lang == 'ru') {
			day = splitted[0];
			month = splitted[1];
		} else {
			day = splitted[1];
			month = splitted[0];
		}
		if (!dayPattern.test(day) || !monthPattern.test(month)
				|| !yearPattern.test(year)) {
			if (!dayPattern.test(day)) {
				message = msg.length.dayerror + '\n';
			}
			if (!monthPattern.test(month)) {

				message = message + msg.length.montherror + '\n';
			}
			if (!yearPattern.test(year)) {

				message = message + msg.length.yearerror + '\n';
			}
		}
	} else {
		message = msg.length.dateerror + '\n';
	}
	return message;
}

function validateText(txtA001, txtA002, txt001) {

	var empty = '';
	var message = '';

	if (txtA001.value == empty) {
		message = msg.length.nobrief + '\n';
	}
	if (txtA002.value == empty) {
		message = message + msg.length.nocontent + '\n';
	}
	if (txt001.value == empty) {
		message = message + msg.length.notitle + '\n';
	}

	return message;
}

function sureDelete() {
	if (confirm(msg.length.sure)) {
		return true;
	} else {
		return false;
	}
}
