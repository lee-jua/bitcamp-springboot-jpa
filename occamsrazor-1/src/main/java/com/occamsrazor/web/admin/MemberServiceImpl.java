package com.occamsrazor.web.admin;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements AdminService{
	private Admin[] members;
	private int count;
public MemberServiceImpl() {
	members = new Admin[5] ;
	count = 0;
}
	@Override
	public void add(Admin member) {
	members[count] = member;
	count++;
		
	}

	@Override
	public Admin[] list() {
		return members;
	}

	@Override
	public Admin detail(String userid) {
		Admin returnmember = null;
		for (int i = 0; i < count; i++) {
			if (userid.equals(members[i].getUserid())) {
				returnmember = new Admin();
				returnmember = members[i];
				break;
			}
		}
		return returnmember;
	}

	@Override
	public Admin[] SearchByName(String name) {
		Admin[] returnmembers = null;
		if (namecount(name)!=0) {
			returnmembers = new Admin[namecount(name)];
			int j=0;
			for (int i = 0; i < count; i++) {
				if (name.equals(members[i].getUserid())) {
					returnmembers[j] = members[i];
							j++;
					if (namecount(name)==j) {
						break;
					}
				}
			}
		}
		return returnmembers;
	}

	@Override
	public Admin[] SearchByGender(String ssn) {
		Admin[] returnmembers = null;
		if (gendercount(ssn)!=0) {
			returnmembers = new Admin[gendercount(ssn)];
			int j=0;
			for (int i = 0; i < count; i++) {
				if (ssn.charAt(7)==(members[i].getSsn().charAt(7))) {
					returnmembers[j] = members[i];
							j++;
					if (gendercount(ssn)==j) {
						break;
					}
				}
			}
		}
		return returnmembers;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int namecount(String name) {
	int searchcount = 0;
	for (int i = 0; i < count; i++) {
		if (name.equals(members[i].getName())) {
			searchcount++;
		}
	}
		return searchcount;
	}

	@Override
	public int gendercount(String ssn) {
		int searchcount = 0;
		for (int i = 0; i < count; i++) {
			if (ssn.charAt(7)==members[i].getSsn().charAt(7)) {
				searchcount++;
			}
		}
			return searchcount;
		}

	@Override
	public boolean login(Admin member) {
		boolean ok = false;
		for (int i = 0; i < count; i++) {
			if(member.getUserid().equals(members[i].getUserid())&&
					member.getPasswd().equals(members[i].getPasswd())) {
				ok =true;
			}
				
		}
		
		return ok;
	}

	@Override
	public void update(Admin member) {
			for (int i = 0; i < count; i++) {
				if (member.getUserid().equals(members[i].getUserid())) {
					members[i].setPasswd(member.getPasswd());
					break;
				}
			}
	
	}


	@Override
	public void delete(Admin member) {
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPasswd(member.getPasswd());
				members[i]=members[count-1];
				members[count-1]=null;
				count--;
				break;
	}

}
	}
	}
