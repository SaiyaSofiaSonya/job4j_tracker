package ru.job4j.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(Pupil::getSubjects)
                .mapToInt(Subject::getScore)
                .average()
                .orElse();
 }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {

        return List.of();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
