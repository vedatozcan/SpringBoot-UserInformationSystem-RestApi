package com.springboot.userinfosys.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AccountDto {
	private long id;
	private String accountName;
	private String url;
	
}
