package racing.output;

public class DashOutput {
    public DashOutput() {
    }

    public String getDashBySize(int size) {
        String dash = "";
        for (int i=0; i<size; i++){
            dash += "-";
        }
        return dash;
    }
}
