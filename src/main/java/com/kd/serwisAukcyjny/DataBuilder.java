package com.kd.serwisAukcyjny;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Getter
@Setter
@Embeddable
public class DataBuilder {

@GeneratedValue(strategy = GenerationType.AUTO)
private Date date;


}
