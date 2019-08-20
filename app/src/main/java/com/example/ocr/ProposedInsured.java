package com.example.ocr;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ProposedInsured implements Parcelable {
    private String firstName;
    private String lastName;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String state;
    private String policyLength;
    private String coverageAmount;
    private List<String> rider;
    private String premium;
    private String billingFrequency;
    private String underwritingClass;
    private String rating;
    private boolean tobacco;

    protected ProposedInsured(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readString();
        addressLine1 = in.readString();
        addressLine2 = in.readString();
        zipCode = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
        state = in.readString();
        policyLength = in.readString();
        coverageAmount = in.readString();
        rider = in.createStringArrayList();
        premium = in.readString();
        billingFrequency = in.readString();
        underwritingClass = in.readString();
        rating = in.readString();
        tobacco = in.readByte() != 0;
    }

    public ProposedInsured() {
        super();
    }

    public static final Creator<ProposedInsured> CREATOR = new Creator<ProposedInsured>() {
        @Override
        public ProposedInsured createFromParcel(Parcel in) {
            return new ProposedInsured(in);
        }

        @Override
        public ProposedInsured[] newArray(int size) {
            return new ProposedInsured[size];
        }
    };

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setPolicyLength(String policyLength) {
        this.policyLength = policyLength;
    }
    public void setCoverageAmount(String coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
    public void setRider(List<String> rider) {
        this.rider = rider;
    }
    public void setPremium(String premium) {
        this.premium = premium;
    }

    public void setBillingFrequency(String billingFrequency) {
        this.billingFrequency = billingFrequency;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setTobacco(boolean tobacco) {
        this.tobacco = tobacco;
    }

    public void setUnderwritingClass(String underwritingClass) {
        this.underwritingClass = underwritingClass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(gender);
        parcel.writeString(addressLine1);
        parcel.writeString(addressLine2);
        parcel.writeString(zipCode);
        parcel.writeString(phoneNumber);
        parcel.writeString(email);
        parcel.writeString(state);
        parcel.writeString(policyLength);
        parcel.writeString(coverageAmount);
        parcel.writeStringList(rider);
        parcel.writeString(premium);
        parcel.writeString(billingFrequency);
        parcel.writeString(underwritingClass);
        parcel.writeString(rating);
        parcel.writeByte((byte) (tobacco ? 1 : 0));
    }
}
