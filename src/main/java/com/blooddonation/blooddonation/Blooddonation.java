package com.blooddonation.blooddonation;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Blooddonation {
    @NotBlank(message="Name cannot be blank")
    String name;
    @NotBlank(message="Gender cannot be blank")
    String gender;
    @Group(message="Invalid Blood group")
    String group;
    @Min(value = 18,message="Age must be above 18")
    int age;
    UUID id;

    public Blooddonation() {
        this.id = UUID.randomUUID(); // Initialize the id with a random UUID
    }

    public Blooddonation(String name, String gender, String group, int age) {
        this.name = name;
        this.gender = gender;
        this.group = group;
        this.age = age;
        this.id = UUID.randomUUID(); // Initialize the id with a random UUID
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}