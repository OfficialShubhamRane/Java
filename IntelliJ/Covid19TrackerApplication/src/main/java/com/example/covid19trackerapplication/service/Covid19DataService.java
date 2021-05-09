package com.example.covid19trackerapplication.service;

import com.example.covid19trackerapplication.model.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Covid19DataService {

    private final String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {

        /** Collects CSV Data From URL in HttpResponse */
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create( VIRUS_DATA_URL ))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString() );

        /** Extracts data from CSV file */
        List<LocationStats> newStats = new ArrayList<>();
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records){

            LocationStats locationStats = new LocationStats();

            /** Last column data */
            int latestCases = Integer.parseInt(record.get( record.size() - 1) );
            /** Second last column data */
            int prevDayCases = Integer.parseInt(record.get( record.size() - 2) );

            /** Loads data of particular column into each member variable of an object */
            locationStats.setState(record.get("Province/State"));
            locationStats.setCountry(record.get("Country/Region"));
            locationStats.setLatestTotalCases( latestCases );
            locationStats.setDiffFromPrevDay( latestCases - prevDayCases );

            /** Saves object into a list format */
            newStats.add(locationStats);
        }

        this.allStats = newStats;

    }

}
