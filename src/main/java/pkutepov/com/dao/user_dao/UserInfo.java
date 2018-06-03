package pkutepov.com.dao.user_dao;

import java.util.Objects;

public class UserInfo {
    private int userInfoId;

    private String lastName;


    private String firstName;


    private String patronymic;


    private String PhoneNumber;

    public UserInfo(int userInfoId, String lastName, String firstName, String patronymic, String phoneNumber) {
        this.userInfoId = userInfoId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        PhoneNumber = phoneNumber;
    }

    public UserInfo(String lastName, String firstName, String patronymic, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        PhoneNumber = phoneNumber;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return userInfoId == userInfo.userInfoId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userInfoId);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
