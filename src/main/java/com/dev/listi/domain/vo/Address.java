
package com.dev.listi.domain.vo;


import com.dev.listi.domain.exceptions.AddressNotValidException;

public class Address {

        private final String street;
        private final String country;
        private final String streetNumber;

        private static final String REGEX_STREET_COUNTRY = "^[a-zA-Z\\s]+$";

        public Address(String street, String country, String streetNumber) {

            if(!isValidStreetNumber(streetNumber)) {
                throw new AddressNotValidException("Street number is not valid: " + streetNumber);
            }

            if(!isValidStreet(street)) {
                throw new AddressNotValidException("Street is not valid: " + street);
            }

            if(!isValidCountry(country)) {
                throw new AddressNotValidException("Country is not valid: " + country);
            }

            this.street = street;
            this.streetNumber = streetNumber;
            this.country = country;

        }



        public String getStreet() {
                return street;
        }

        public String getCountry() {
                return country;
        }

        public String getStreetNumber() {
                return streetNumber;
        }


        private boolean isValidStreetNumber(String streetNumber) {
            try {
                Integer number = Integer.parseInt(streetNumber);
                return number > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
            private boolean isValidStreet (String street){
                if (!street.matches(REGEX_STREET_COUNTRY)) {
                   return false;
                }

                return true;

            }

        private boolean isValidCountry (String country){
            if (!country.matches(REGEX_STREET_COUNTRY)) {
                return false;
            }

            return true;

        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", country='" + country + '\'' +
                    ", streetNumber='" + streetNumber + '\'' +
                    '}';
        }



}