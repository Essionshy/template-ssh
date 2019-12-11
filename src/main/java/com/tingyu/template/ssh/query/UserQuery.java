package com.tingyu.template.ssh.query;

import java.util.Date;

import com.tingyu.template.ssh.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
/**
 * UserQuery
 * @author Essionshy
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UserQuery extends User{
	private Date	startBirth;
	private Date	endBirth;
}
