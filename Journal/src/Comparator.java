public class Comparator<Student> {
        public int compare(Student first, Student second){
            return (int) (first.getAverageMark() - second.getAverageMark());
        }
}