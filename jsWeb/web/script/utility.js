const today = new Date()
const tomorrow = new Date(today)
tomorrow.setDate(tomorrow.getDate() + 1)

function prepareDate(date) {
    let month = date.getMonth() + 1;
    let day = date.getDate();
    return date.getFullYear() + '-'
        + (month < 10 ? '0' : '') + month + '-'
        + (day < 10 ? '0' : '') + day;
}

function date(nameTable) {
    let date = ''
    if (nameTable === 'Today') {
        date = prepareDate(today)
    } else if (nameTable === 'Tomorrow') {
        date = prepareDate(tomorrow)
    }
    return date
}

function getCookie(name) {
    let matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

function CookiesDelete() {
    let cookies = document.cookie.split(";");
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i];
        let eqPos = cookie.indexOf("=");
        let name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT;";
        document.cookie = name + '=; path=/; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    }
}