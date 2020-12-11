package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    public HashSet<Event> Events = new HashSet<Event>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        this.Events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        HashSet<Event> ListeEvent=new HashSet();
        events.stream().filter(e -> (e.isInDay(day))).forEachOrdered(e -> {
            ListeEvent.add(e);
        });
        return ListeEvent;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList titres = new ArrayList();
        for (Event e : Events) {
            if (e.getTitle().equals(title)) {
                titres.add(e);
            }
        }
        return titres;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        for(Event ev:events){
            LocalDateTime evEnd=ev.getStart().plus(ev.getDuration());//Date de fin des events programmé
            LocalDateTime eEnd=e.getStart().plus(e.getDuration());//Date de fin des events programmé
            LocalDateTime evStart=ev.getStart();//Date de début des events programmé
            LocalDateTime eStart=e.getStart();//Date de début des events programmé
            
         if( ev.getStart().equals(e.getStart())||
                 (evStart.isBefore(eStart) && evEnd.isAfter(eEnd)) ) {
                 
            return false;}
         }
        return true;
    }
}
