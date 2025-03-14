package ru.skillbox.model;

import ru.skillbox.exceptions.AddCommandException;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(Builder builder) throws AddCommandException {
        StringBuilder error = new StringBuilder("");
        if (builder.name.isBlank()) {
            error.append("Не указано имя для контакта\n");
        }
        if (builder.phone.isBlank()) {
            error.append("Не указан телефон контакта\n");
        }
        if (builder.email.isBlank()) {
            error.append("Не указан email контакта\n");
        }
        if (error.length() > 0) {
            throw new AddCommandException(error.toString());
        }
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact={");
        sb.append("name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private String name;
        private String phone;
        private String email;

        public Builder() {
            super();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

}
