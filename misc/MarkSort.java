import java.util.*;

class Student {
    int id;
    String name;
    int []marks = new int[5];

    public Student(int id, String name, int []marks) {
        this.id = id;
        this.name = name;

        System.arraycopy(marks, 0, this.marks, 0, 5);
    }
}

class MarksSort {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student []arr = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int []marks = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int []res = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }

    static int[] marksSort(int n, Student []arr) {

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int []s1MArr = s1.marks;
                int s1TotMarks = 0;
                for (int mark : s1MArr) {
                    s1TotMarks += mark;
                }

                int []s2MArr = s2.marks;
                int s2TotMarks = 0;
                for (int mark : s2MArr) {
                    s2TotMarks += mark;
                }

                if (s1TotMarks != s2TotMarks) {
                    return s2TotMarks - s1TotMarks;
                }
                if (s1.name.compareTo(s2.name) != 0) {
                    return s1.name.compareTo(s2.name);
                }
                return s1.id - s2.id;
            }
        });

        int []ids = new int[n];
        for (int i=0; i<n; i++) {
            ids[i] = arr[i].id;
        }

        return ids;
    }
}