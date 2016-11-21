package com.christianphan.mednew;

import java.util.ArrayList;

/**
 * Created by chris on 11/19/16.
 */

public class ActivityItem {

    private String Name;
    private String[] checklist = new String[5];

    public ActivityItem(String name, String[] a) {
        Name = name;

        for(int i = 0; i < 5; i++)
        {
            checklist[i] = a[i];
        }
    }

    public String getName()
    {
        return Name;
    }

    public String[] getChecklist()
    {
        return checklist;
    }


    private static int lastContactId = 0;

    public static ArrayList<ActivityItem> createContactsList(int numContacts) {
        ArrayList<ActivityItem> contacts = new ArrayList<ActivityItem>();

        String[] checklist = new String[]{"HI", "NO", "Low", "Cat", "Hat"};


        for (int i = 1; i <= numContacts; i++) {

            contacts.add(new ActivityItem("Person " + ++lastContactId, checklist ));
        }

        return contacts;
    }
}

