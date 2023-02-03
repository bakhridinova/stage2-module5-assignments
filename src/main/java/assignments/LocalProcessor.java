package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String s : stringList) {
            if (s != null) {
                System.out.println(s.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullNameProcessor(List<String> stringList) {
        for (String s : stringList) {
            processorVersion.append(s);
        }
        return processorVersion.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            informationScanner.close();
        }
    }
}
