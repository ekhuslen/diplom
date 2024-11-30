//package com.example.gymnasticsScoringSystem.entity.db;
//
//import com.example.gymnasticsScoringSystem.entity.cilent.ClntTeam;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "team")
//@NoArgsConstructor
//@SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq", allocationSize = 1)
//public class Team {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
//    private Long id;
//
//    @Column(name = "club_id", nullable = false)
//    private Long clubId;
//
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "ath_id", nullable = false)
//    private Athlete athlete;
//
//    @ManyToOne
//    @JoinColumn(name = "comp_type_id", nullable = false)
//    private CompType compType;
//
//    public ClntTeam toClient() {
//        ClntTeam c = new ClntTeam();
//        c.setId(id);
//        c.setName(name);
//        c.setClubId(clubId);
//        c.setAthlete(athlete);
//        c.setCompType(compType);
//        return c;
//    }
//}
