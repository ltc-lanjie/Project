function $(obj) {
		result = document.querySelectorAll(obj);
		switch (result.length) {
		case 0:
			return null;
		case 1:
			return result[0];
		default:
			return result;
		}
}