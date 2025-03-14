package ru.skillbox.services;

public class ShellOutputService implements OutputService {

    @Override
    public void print(String value) {
        System.out.print(value);
    }

    @Override
    public void println(String value) {
        System.out.println(value);
    }
}
