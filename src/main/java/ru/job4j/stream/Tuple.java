package ru.job4j.stream;

import java.util.Objects;

public class Tuple {
    private String name;
    private Double score;

    public Tuple(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
    if (this == null) {
        return false;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    Tuple tuple = (Tuple) o;
    return Double.compare(tuple.score, score) == 0
            && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
