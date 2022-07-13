package com.human.data;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpDAO {
	iEmployee iemp;
	public EmpDAO(iEmployee ie) {
		this.iemp=ie;
	}
	public Memberinfo getMemberinfo(int eid) {
		member member =iemp.getMember(eid);
		ArrayList<empDTO> emplist=iemp.listEmpLoyees();
		int n=iemp.countMember(eid);
		Memberinfo mi=new Memberinfo();
		mi.m=member;
		mi.mDTO=emplist;
		mi.n=n;
		return mi;
	}
}
