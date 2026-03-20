package Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Letter {
    A, B, C, D, E, F, G, H;
    private static final Random rng = new Random();

    public static Letter getRandomLetter(){
        List<Letter> bag = new ArrayList<>();

        bag.addAll(Arrays.asList(values()));
        
        Collections.shuffle(bag, rng);
        return bag.get(0);
    }

    public static Letter[] generateRandomFaces() {
        
        List<Letter> bag = new ArrayList<>();
        for (Letter l : values()) {
            bag.add(l);
            bag.add(l);
        }
        // The bag contains: {A, A, B, B, ... H, H}.
        Collections.shuffle(bag, rng);
        
        Letter[] faces = new Letter[6];
        for (int i = 0; i < 6; i++) {
            faces[i] = bag.get(i);
        }

        return faces;
    }
}
