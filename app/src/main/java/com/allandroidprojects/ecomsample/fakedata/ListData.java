package com.allandroidprojects.ecomsample.fakedata;

import com.allandroidprojects.ecomsample.model.Word;

import java.util.ArrayList;
import java.util.List;

public class ListData {

    protected final List<Word> words;

    public ListData()
    {
        words = new ArrayList<>();
    }

    public List<Word> getData(){return words;};
}
