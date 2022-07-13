package com.human.data;

import java.util.ArrayList;

public interface itmember {
	ArrayList<TmemberDTO> listmember();
	void insert(String id,int pwd, String name,int mobile);
}
