package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "entityMember")
@Table(name = "tbl_member")
@Access(AccessType.FIELD) // 클래스 레벨에 설정 가능 | FIELD : 필드 직접 접근 방식(default) / PROPERTY : Getter를 이용한 접근
public class Member {
    @Id     // PK
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue는 PK를 어떻게 처리할 것인지를 정함. 여기서는 IDENTITY 타입 사용(Auto_Increment)
    private int memberNo;

    @Access(AccessType.FIELD) // 필드 레벨에도 설정 가능
    @Column(
            name = "member_id", unique = true,
            nullable = false, columnDefinition = "varchar(10)"
    )
    private String memberId;

    @Column(name = "member_pwd", nullable = false)
    private String memberPwd;

    @Column(name = "member_name")
    private String memberName;

//    @Transient  // @Transient : DB의 컬럼과 맵핑하지 않음.
    @Column(name = "phone")
    private String phone;

    @Column(name = "address", length = 900) // 문자열의 길이 제약. 문자열일때만 사용 가능
    private String address;

    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;

    @Column(name = "member_role")
    @Enumerated(EnumType.STRING) // EnumType.STRING을 쓰지 않으면 ORDINAL이 기본 타입이기 때문에 숫자로 다루게 된다.
    private MemberRole memberRole;

    @Column(name = "status", columnDefinition = "char(1) default 'Y'")
    private String status;

    protected Member() {}   // 기본 생성자는 필수!

    public Member(
            String memberId, String memberPwd, String memberName,
            String phone, String address, LocalDateTime enrollDate,
            MemberRole memberRole, String status
    ) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
    // Getter, Setter
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    @Access(AccessType.PROPERTY)    // PROPERTY : Getter를 이용한 접근
    public String getMemberName() {
        System.out.println("getMemberName 메소드를 통한 Access 확인");
        return memberName + "님";
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }
    public MemberRole getMemberRole() {
        return memberRole;
    }
    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
