package com.safecard.jpa.com.safecard.file.track;

import com.safecard.jpa.model.TrackRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackReader {

    public static void main(String[] args) throws IOException {
        List<TrackRecord> trackRecords = new TrackReader().readFile();
        String trackRecordResourceUrl = "http://localhost:8080/trackrecord/save";
        RestTemplate restTemplate = new RestTemplate();
        trackRecords.remove(0);
        for(TrackRecord trackRecord : trackRecords){
            HttpEntity<TrackRecord> request = new HttpEntity<>(trackRecord);
            ResponseEntity<TrackRecord> response =
                    restTemplate.exchange(trackRecordResourceUrl, HttpMethod.POST, request, TrackRecord.class);

        }
    }

    private List<TrackRecord> readFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("trackrecords.csv");
        File file = new File(resource.getFile());

        try {
            Scanner scanner = new Scanner(file);
            List<TrackRecord> trackRecords = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                String cols[] = line.split(",");
                TrackRecord trackRecord = new TrackRecord();
                trackRecord.setLotNumber(cols[0]);
                trackRecord.setControlNumber(cols[1]);
                trackRecord.setCardDesignId(cols[2]);
                trackRecord.setCardNumber(cols[3]);
                trackRecord.setCardHolderName(cols[4]);
                trackRecord.setCardDesignId(cols[5]);
                trackRecords.add(trackRecord);
               }
            scanner.close();
            return trackRecords;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}
