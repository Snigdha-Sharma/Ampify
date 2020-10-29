package sample;
class Line {
    int index;
    String text;
    int start, end;

    public Line(int i, String str, int s1, int s2) {
        index = i;
        text = str;
        start = s1;
        end = s2;
    }

    public void append(String str) {
        text = text + " " + str;
    }

    @Override
    public String toString() {
//        return "Line[" + index + "][" + start + "][" + end + "][" + text + "]";
        return text;
    }
}
