package com.human.data;

import java.util.ArrayList;

public interface imenu {
	ArrayList<menuDTO> listmenu();
	void insert(String name,int fare);
	void delete(int seqno);
	menuDTO viewMenu(int seqno);
	void update(String name,int price, int seqno);
}
