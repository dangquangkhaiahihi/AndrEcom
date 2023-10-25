package com.allandroidprojects.ecomsample.fakedata;

import com.allandroidprojects.ecomsample.model.Word;

public class CatData extends ListData {

    public CatData()
    {
        super();
        words.add(new Word("Persian Cat", "Long, luxurious fur and distinctive flat face. Having a calm and gentle temperament.", "$500","0559261020"));
        words.add(new Word("Siamese Cat", "Sleek, slender bodies, short coat, and striking blue almond-shaped eyes. Vocal, social, and often form strong bonds with their owners.", "$400","0559261020"));
        words.add(new Word("Maine Coon", "Tufted ears, bushy tails, and tufted paws. Friendly, sociable, and often referred to as \"gentle giants.\"", "$800","0559261020"));
        words.add(new Word("Bengal Cat", "Distinctive spotted or marbled coat, resembling that of a wild leopard. Energetic, playful, and may exhibit very active behavior.", "$1.000 ","0559261020"));
    }
}
