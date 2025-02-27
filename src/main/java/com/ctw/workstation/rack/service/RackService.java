package com.ctw.workstation.rack.service;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackRequestDTO;
import com.ctw.workstation.rack.entity.RackResponseDTO;
import com.ctw.workstation.team.entity.TeamResponseDTO;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    private static RackService instance = null;

    public static RackService getInstance() {
        if (instance == null) {
            instance = new RackService();
        }
        return instance;
    }

    private RackService() {
        rackRepository = new RackRepository();
    }

    public List<RackResponseDTO> getAllRacks() {
        List<Rack> racks = rackRepository.listAll();
        return racks.stream().map(RackResponseDTO::new).collect(Collectors.toList());
    }

    public RackResponseDTO getRackDTOById(UUID id) {
        Rack rack = rackRepository.findById(id);
        return new RackResponseDTO(rack);
    }

    public Rack getRackById(UUID id) {
        return rackRepository.findById(id);
    }

    @Transactional
    public RackResponseDTO addRack(RackRequestDTO request) {
        Rack rack = new Rack(request.serialNumber(), request.status(), request.defaultLocation());
        rackRepository.persist(rack);
        rackRepository.flush();
        return new RackResponseDTO(rack); }

    @Transactional
    public void removeRack(UUID id) {
        rackRepository.delete(rackRepository.findById(id));
    }

    @Transactional
    public RackResponseDTO updateRack(Rack existingRack, RackRequestDTO rack) {
        existingRack.setSerialNumber(rack.serialNumber());
        existingRack.setStatus(rack.status());
        existingRack.setDefaultLocation(rack.defaultLocation());

        rackRepository.getEntityManager().merge(existingRack);

        return new RackResponseDTO(existingRack);
    }

    /*
    public List<Rack> findRacksByStatus(String status) {

        List<Rack> allRacks = new ArrayList<>(rackDatabase.getAllRacks().values());
        List<Rack> filteredRacks = new ArrayList<>();

        for (Rack rack : allRacks) {
            if (rack.getStatus() != null && rack.getStatus().equals(status)) {
                filteredRacks.add(rack);
            }
        }

        return filteredRacks;
    }
    */

    /*
    public void addRack(Rack rack) { rackDatabase.addRack(rack); }
    public void addTeam(Team team) { teamDatabase.addTeam(team); }
    public void addBooking(Booking booking) { bookingDatabase.addBooking(booking); }

    public void removeRack(String rackId) { rackDatabase.removeRack(rackId); }
    public void removeTeam(String teamId) { teamDatabase.removeTeam(teamId); }
    public void removeBooking(String bookingId) { bookingDatabase.removeBooking(bookingId); }

    public Rack findRackById(String rackId) {
        return rackDatabase.getRack(rackId); }
    public Team findTeamById(String teamId) {
        return teamDatabase.getTeam(teamId);
    }
    public Booking findBookingById(String bookingId) {
        return bookingDatabase.getBooking(bookingId);
    }

    public List<Rack> getAllRacks() {
        Map<String, Rack> availableRacks = rackDatabase.getAllRacks();
        return new ArrayList<>(availableRacks.values());
    }
    public List<Team> getAllTeams() {
        Map<String, Team> availableTeams = teamDatabase.getAllTeams();
        return new ArrayList<>(availableTeams.values());
    }
    public List<Booking> getAllBookings() {
        Map<String, Booking> availableBooking = bookingDatabase.getAllBookings();
        return new ArrayList<>(availableBooking.values());
    }

    public List<Rack> findRacksByStatus(String status) {

        List<Rack> allRacks = new ArrayList<>(rackDatabase.getAllRacks().values());
        List<Rack> filteredRacks = new ArrayList<>();

        for (Rack rack : allRacks) {
            if (rack.getStatus() != null && rack.getStatus().equals(status)) {
                filteredRacks.add(rack);
            }
        }

        return filteredRacks;
    }

    public void updateRack(String rackId, Rack rack) {
        Rack existingRack = rackDatabase.getRack(rackId);

        if (existingRack == null) { return; }

        //if (rack.getSerialNumber() != null && (rack.getSerialNumber().isEmpty() || rack.getSerialNumber().equals("string"))) {
        //    existingRack.setSerialNumber(rack.getSerialNumber()); }
        if (rack.getStatus() != null && (rack.getSerialNumber().isEmpty() || rack.getSerialNumber().equals("string"))) {
            existingRack.setStatus(rack.getStatus()); }
        if (rack.getTeamId() != null && (rack.getSerialNumber().isEmpty() || rack.getSerialNumber().equals("string"))) {
            existingRack.setTeamId(rack.getTeamId()); }

        rackDatabase.addRack(existingRack);
    }
    public void updateTeam(String teamId, Team team) {
        Team existingTeam = teamDatabase.getTeam(teamId);

        if (existingTeam == null) { return; }

        if (team.getProduct() != null || team.getProduct().equals("string")) {
            existingTeam.setProduct(team.getProduct()); }

        teamDatabase.addTeam(existingTeam);
    }


    public List<Booking> findAllBookingsForTeam(String teamId) throws Exception {
        if (teamDatabase.getTeam(teamId) != null) {
            throw new Exception("Team not found with id: " + teamId);
        }
        return bookingDatabase.getBookingsByTeamId(teamId);
    }

    public List<Booking> findAllBookingsForTeamInPeriod(String teamId, LocalDateTime from, LocalDateTime to) throws Exception {

        if (teamDatabase.getTeam(teamId) != null) {
            throw new Exception("Team not found with id: " + teamId);
        }
        List<Booking> allBookings = findAllBookingsForTeam(teamId);
        List<Booking> bookingsInPeriod = new ArrayList<>();
        for (Booking booking : allBookings) {
            if (booking.getFrom().isBefore(to) && booking.getTo().isAfter(from)) {
                bookingsInPeriod.add(booking);
            }
        }
        return bookingsInPeriod;
    }

     */
}