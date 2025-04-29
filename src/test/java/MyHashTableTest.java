import org.jokeoa.models.MyHashTable;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Random;

public class MyHashTableTest {

    private static class MyTestingClass {
        private final int id;

        public MyTestingClass(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id % 100; // Ensures that we don't use default hashing
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyTestingClass that = (MyTestingClass) o;
            return id == that.id;
        }
    }

    private static class Student {
        private final String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return name != null && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            for (int i = 0; i < name.length(); i++) {
                hash = hash * 31 + name.charAt(i);
            }
            return hash;
        }
    }
    @Test
    public void testMyHashTable() {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i), new Student("Student" + i));
        }

        Assert.assertEquals(table.size(), 10000);


        MyTestingClass key = new MyTestingClass(1);
        table.put(key, new Student("John"));
        Assert.assertEquals(table.get(key).toString(), "John");

        Assert.assertTrue(table.contains(new Student("John")));


        table.remove(key);
        Assert.assertNull(table.get(key));
    }
}