export default class UserForm {
    constructor(staffId, fullName, email, password, confirmPassword, roles = [], department) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.department = department;
        this.roles = roles;
    }
}