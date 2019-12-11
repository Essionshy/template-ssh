package com.tingyu.template.ssh.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @author Essionshy
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User {
	
	private Integer id;
	private String 	username;
	private String 	password;
	private Integer gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	birth;
	private String 	phone;
	private String 	email;
	private String 	address;
}
