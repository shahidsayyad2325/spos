import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FIFO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        int buffer[];
        int reference[];
        int mem_layout[][];
        
        System.out.print("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());
        System.out.print("Please enter the length of the Reference string: ");
        ref_len = Integer.parseInt(br.readLine());
        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        buffer = new int[frames];
        
        for (int j = 0; j < frames; j++) {
            buffer[j] = -1;
        }
        
        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                buffer[pointer] = reference[i];
                fault++;
                pointer = (pointer + 1) % frames;
            }
            for (int j = 0; j < frames; j++) {
                mem_layout[i][j] = buffer[j];
            }
        }
        
        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++) {
                System.out.printf("%3d ", mem_layout[j][i]);
            }
            System.out.println();
        }
        
        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) hit / ref_len);
        System.out.println("The number of Faults: " + fault);
        
        br.close();
    }
}
