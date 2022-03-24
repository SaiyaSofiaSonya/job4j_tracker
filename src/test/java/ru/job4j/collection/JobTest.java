package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest{

    @Test
   public void jobAscByName() {
        JobAcsByName jobAcsByName = new JobAcsByName();
        int rsl = jobAcsByName.compare(new Job("Fix", 1), new Job("Clean", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public  void jobDesByName() {
        JobDescName jobDescName = new JobDescName();
        int rsl = jobDescName.compare(new Job("Fix", 1), new Job("Clean", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobAcsPriority() {
        JobAscPriority jobAscPriority = new JobAscPriority();
        int rsl = jobAscPriority.compare(new Job("Fix", 1), new Job("Clean", 2));
        assertThat(rsl, lessThan(0));
    }


    @Test
    public void jobDescPriority() {
        JobDescPriority jobDescPriority = new JobDescPriority();
        int rsl = jobDescPriority.compare(new Job("Fix", 1), new Job("Clean", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAcsNameAndAcsPriority() {
            Comparator<Job> cmpNamePriority = new JobAcsByName().thenComparing(new JobAscPriority());
            int rsl = cmpNamePriority.compare(
                    new Job("Fix bug", 0),
                    new Job("Fix bug", 1)
            );
            assertThat(rsl, lessThan(0));
        }


    @Test
    public void whenComparatorByAscPriorityAndByAcsName() {
        Comparator<Job> cmpNamePriority = new JobAscPriority().thenComparing(new JobAcsByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompactorByPriorityDescAndNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescPriority().thenComparing(new JobDescName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}