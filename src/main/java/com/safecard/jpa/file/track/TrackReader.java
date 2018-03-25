package com.safecard.jpa.file.track;

import com.safecard.jpa.model.Job;
import com.safecard.jpa.model.TrackRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TrackReader {

    public static void main(String[] args) throws IOException {
        TrackReader trackReader = new TrackReader();
        URL resource = trackReader.getFileUrl();
        File file = new File(resource.getFile());

        List<TrackRecord> trackRecords = trackReader.createTrackRecords(file);

        if(trackRecords != null && trackRecords.isEmpty()) return;
        //trackRecords.remove(0);

        Job job = PersistJob(trackReader, file, trackRecords);
        PersistTrackRecords(trackRecords, job);
    }

    private static Job PersistJob(TrackReader trackReader, File file, List<TrackRecord> trackRecords) {
        return trackReader.createJob(file.getName(), trackRecords.size());
    }

    private static void PersistTrackRecords(List<TrackRecord> trackRecords, Job job) {
        String trackRecordResourceUrl = "http://localhost:8080/trackrecord/save";
        RestTemplate restTemplate = new RestTemplate();


        persistTrackRecords(job, trackRecords, trackRecordResourceUrl, restTemplate);
    }

    private static void persistTrackRecords(Job job, List<TrackRecord> trackRecords, String trackRecordResourceUrl, RestTemplate restTemplate) {
        int counter = 1;
        for(TrackRecord trackRecord : trackRecords){
            trackRecord.setFileId(job.getId());
            HttpEntity<TrackRecord> request = new HttpEntity<>(trackRecord);
            ResponseEntity<TrackRecord> response =
                    restTemplate.exchange(trackRecordResourceUrl, HttpMethod.POST, request, TrackRecord.class);

            if(response.getStatusCode() != HttpStatus.CREATED ){
                System.out.println("Job ID::"+job.getId() +" && Track Record Number ::"+counter+ " Failed to create");
            }
            counter++;
        }
    }


    private URL getFileUrl() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("sampletrackrecords1.csv");
        if(resource != null && null == resource.getFile()) {
            System.out.println("File Not Found ");
            //return null;
            System.exit(0);
        }
        return resource;
    }

    private Job createJob(String fileName, long size){
        Job job = new Job();
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("sampletrackrecords1.csv");
        if(resource != null && null == resource.getFile()) {
            System.out.println("File Not Found ");
            return null;
        }
        job.setFileName(fileName);
        job.setJobName(fileName);
        job.setJobDate(new Date());
        job.setRecordsCount(size);

        String jobRecordResourceUrl = "http://localhost:8080/job/save";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Job> request = new HttpEntity<>(job);
        ResponseEntity<Job> response =
                restTemplate.exchange(jobRecordResourceUrl, HttpMethod.POST, request, Job.class);

        return response.getBody();
    }

    private List<TrackRecord> createTrackRecords(File file){

        try {
            Scanner scanner = new Scanner(file);
            List<TrackRecord> trackRecords = new ArrayList<>();
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                if (line.equalsIgnoreCase(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,")) {
                    return trackRecords;
                }

                //String cols[] = line.split(",");

                if (i != 0) {
                    String cols[] = line.split(",");
                    TrackRecord trackRecord = new TrackRecord();
                    trackRecord.setJobId(Integer.parseInt(cols[0]));
                    trackRecord.setRecordNumber(Integer.parseInt(cols[1]));
                    trackRecord.setPan(cols[2]);
                    trackRecord.setCardHolderName(cols[3]);
                    trackRecord.setCardDesignID(cols[9]);
                    trackRecord.setMemberId(cols[24]);
                    trackRecord.setCardIssuanceTypeId(cols[61]); //CARD TYPE
                    trackRecord.setPanSequenceNumber(cols[63]);
                    trackRecord.setExpirationDate(new Date());  // cols[6]
                    trackRecord.setCvv2(cols[6]);
                    trackRecord.setCvv(cols[62]);
                    trackRecord.setTrack1DiscretionaryData(cols[7]);
                    trackRecord.setTrack2DiscretionaryData(cols[8]);
                    trackRecord.setKeyIndex(cols[64]);
                    // key index
                    trackRecord.setExpirationDate(new Date());
                    trackRecord.setCreatedDateTime(new Date());
                    trackRecords.add(trackRecord);
                }
                i++;
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
