package com.example.himanshu.servercalls.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 4/5/17.
 */

public class UserData  implements Parcelable {


    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
   private String username;
    @SerializedName("email")
   private String email;
    @SerializedName("address")
    private Address address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("website")
    private String website;
    @SerializedName("company")
    private Company company;

    public UserData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
    }

    public UserData() {
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(website);
    }

    public static class Geo {
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(final String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(final String lng) {
            this.lng = lng;
        }
    }

    public static class Address {
        @SerializedName("street")
        private String street;
        @SerializedName("suite")
       private String suite;
        @SerializedName("city")
        private String city;
        @SerializedName("zipcode")
        private String zipcode;
        @SerializedName("geo")
        private Geo geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(final String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(final String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(final String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(final String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(final Geo geo) {
            this.geo = geo;
        }
    }

    public static class Company {
        @SerializedName("name")
        private String name;
        @SerializedName("catchPhrase")
        private String catchPhrase;
        @SerializedName("bs")
        private String bs;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(final String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(final String bs) {
            this.bs = bs;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(final String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }
}
