//package singleDirectionAssociation;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Entity
//public class Team {
//    @Id
//    @GeneratedValue
//    @Column(name = "TEAM_ID")
//    private Long id;
//
//    @Column(name = "TEAM_NAME")
//    private String name;
//
//    @OneToMany(mappedBy = "team")
//    List<OldMember> oldMembers = new ArrayList<OldMember>();
//
//    public Team(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Team() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
