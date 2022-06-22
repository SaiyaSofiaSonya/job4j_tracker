package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(subject -> subject.getScore())
                .average()
                .orElse(0.0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil ->
                        new Tuple(
                                pupil.getName(),
                                pupil
                                        .getSubjects()
                                        .stream()
                                        .mapToInt(subject -> subject.getScore())
                                        .average()
                                        .orElse(0.0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {

        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(pupil -> pupil.getName(),
                                LinkedHashMap::new,
                                Collectors.averagingDouble(subject -> subject.getScore())))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil
                                .getSubjects()
                                .stream()
                                .mapToInt(subject -> subject.getScore())
                                .asDoubleStream()
                                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors
                        .groupingBy(pupil -> pupil.getName(),
                                LinkedHashMap::new,
                                Collectors.summingDouble(subject -> subject.getScore())))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(),
                        entry.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}

