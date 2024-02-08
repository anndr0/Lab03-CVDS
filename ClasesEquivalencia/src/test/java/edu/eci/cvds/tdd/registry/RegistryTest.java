package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("antonio", 1, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateRegistryResultAge() {
        Person person = new Person("julia", 2, 12, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateRegistryResultAlive() {
        Person person = new Person("pablo", 3, 40, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateRegistryResultDuplicated() {
        Person person = new Person("fafa", 4, 20, Gender.UNIDENTIFIED, true);
        registry.registerVoter(person);
        person = new Person("fofa", 4, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
    @Test
    public void validateRegistryResultInvalidAge() {
        Person person = new Person("fifif", 5, 600, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
}