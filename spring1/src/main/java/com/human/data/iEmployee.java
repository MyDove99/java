package com.human.data;

import java.util.ArrayList;

import javax.swing.plaf.multi.MultiInternalFrameUI;

public interface iEmployee {
	ArrayList<empDTO> listEmpLoyees();
	member getMember(int id);
	int countMember(int id);
}
