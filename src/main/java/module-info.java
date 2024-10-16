open module banking {
    requires spring.context;
    requires static lombok;
    requires jakarta.persistence;
    requires iban4j;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.web;
    requires com.fasterxml.jackson.annotation;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.validation;

    exports com.eroudini.banking;
}