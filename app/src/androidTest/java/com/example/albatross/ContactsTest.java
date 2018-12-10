package com.example.albatross;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactsTest {

    @Test
    public void testCreation()
    {
        Contacts newContact = new Contacts();
        newContact.setName("Airwick Granolla");
        newContact.setPhone_num(11011010);
        assertEquals(newContact.getnum(), 11011010);

    }

    @Test
    public void testCreation2()
    {
        Contacts newContact = new Contacts();
        newContact.setName("Jefferson Cebollas");
        newContact.setPhone_num(123);
        assertEquals(newContact.getnum(), 123);

    }

    @Test
    public void testChange()
    {
        Contacts newContact = new Contacts();
        newContact.setName("Jefferson Cebollas");
        newContact.setPhone_num(123);
        newContact.setPhone_num(345);
        assertEquals(newContact.getnum(), 345);

    }
}