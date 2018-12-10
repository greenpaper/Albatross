package com.example.albatross;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkCreation()
    {
        User newguy = new User();
        newguy.setUsername("Thatdude");
        newguy.setPassword("abc123");
        newguy.setName("that dude");
        assertEquals(newguy.getUname(), "Thatdude");
        assertEquals(newguy.getPassword(), "abc123");
    }

    @Test
    public void checkContacts()
    {
        User newguy = new User();
        newguy.setUsername("Thatdude");
        newguy.setPassword("abc123");
        newguy.setPhone(8456);
        newguy.add_contact("Guis Larcia", 101010101,1);
        assertEquals(newguy.get_contact("Guis Larcia"),101010101);
        assertEquals(newguy.getphone(), 8456);
    }

}