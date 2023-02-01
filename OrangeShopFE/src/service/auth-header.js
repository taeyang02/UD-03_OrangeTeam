export default function authHeader(data) {
    let user = JSON.parse(localStorage.getItem('user'));
    if (user && user.accessToken) {
        return { Authorization: 'Bearer ' + user.accessToken,
            data:data};
    } else {
        return '';
    }
}