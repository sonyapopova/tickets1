package com.example.tikkets;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BusTicket> tickets = new ArrayList<BusTicket>();
    private float totalSum = 0f;
    private TextView busTicketOut;

    private void addTickets(int ticketsNumber, String departurePoint, String arrivalPoint,
                            String departureDate,
                            String travelTime, int distance, float ticketFullPrice,
                            BusTicketType type){
        for (int i = 0; i < ticketsNumber; i++) {
            tickets.add(new BusTicket(departurePoint, arrivalPoint, departureDate,
                    travelTime, distance, ticketFullPrice, type));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTickets(9,
                "Горно-Алтайск","Артыбаш",
                "1 июня 2023 7:00",
                "4 часа 30 мин", 5, 70f,
                BusTicketType.FULL);
        addTickets(5,
                "Горно-Алтайск","Артыбаш",
                "1 июня 2023 7:00",
                "4 часа 30 мин", 5, 70f,
                BusTicketType.PENSIONER);
        addTickets(11,
                "Горно-Алтайск","Артыбаш",
                "1 июня 2023 7:00",
                "4 часа 30 мин", 5, 70f,
                BusTicketType.CHILD);
        tickets.forEach( ticket -> {
            totalSum+= ticket.getTicketPrice();
        } );
        busTicketOut = findViewById(R.id.busTicketOut);
        busTicketOut.setText(
                tickets.stream().map(Object::toString)
                    .collect(Collectors.joining("-------------- \n ")) +
                "Общая стоимость: " + totalSum + " монет"
        );

    }


}